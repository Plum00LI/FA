layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
	var layer = layui.layer;
	var $ = layui.$;
	var table = layui.table;
	var form = layui.form;
	var formSelects = layui.formSelects;
	var laydate = layui.laydate;

	//执行一个laydate实例
	laydate.render({
		elem: '#start',//指定元素
	});
	//执行一个laydate实例
	laydate.render({
		elem: '#updatetime'//指定元素
	});
	//执行一个laydate实例
	laydate.render({
		elem: '#editopen',//指定元素
	});
	//执行一个laydate实例
	laydate.render({
		elem: '#editend'//指定元素
	});

	//新增提交
	form.on('submit(addsubmit)', function (data) {
		var formData = $('#addform').serialize();
		$.post("/Securities/insertSecurities", formData, function (msg) {
			if (msg > 0) {
				table.reload('userTable');
				layer.closeAll();
				layer.msg('添加成功', {
					title: '提示',
					area: ['200px',
						'140px'],
					time: 0,
					btn: ['知道了']
				});
			} else {
				layer.closeAll();
				layer.msg('添加失败', {
					title: '提示',
					area: ['200px',
						'140px'],
					time: 0,
					btn: ['知道了']
				});
			}
		});
		return false;
	});

	//修改提交
	form.on('submit(editsubmit)', function (data) {
		var formData = $('#editform').serialize();
		$.post("/Securities/updateSecurities", formData, function (msg) {
			if (msg > 0) {
				table.reload('userTable');
				layer.closeAll();
				layer.msg('修改成功', {
					title: '提示',
					area: ['200px',
						'140px'],
					time: 0,
					btn: ['知道了']
				});
			} else {
				layer.closeAll();
				layer.msg('修改失败', {
					title: '提示',
					area: ['200px',
						'140px'],
					time: 0,
					btn: ['知道了']
				});
			}
		});
		return false;
	});

	//查询
	table.render({
		elem: '#userTable',
		url: '../Securities/selectSecurities',
		toolbar: '#userToolBar',
		defaultToolbar: ['filter', 'exports', 'print'],
		height:'full-170',
		cellMinWidth:60,
		cols: [
			[
				{type: "checkbox", width: 50},
				{field: 'securitiesId', title: '证券编号', sort: true},
				{field: 'securitiesName', title: '证券名称'},
				{field: 'securitiesType', title: '证券类型', sort: true,
					templet:function (item) {
						if (item.securitiesType=="1"){
							return '债券';
						}else if (item.securitiesType=="2"){
							return '股票';``
						}
					}
				},
				{field: 'issueDate', title: '发行日期'},
				{field: 'delayDate', title: '延迟日期'},
				{field: 'stockName', title: '股票板块', sort: true,
					hide:function (item) {
						if (item.stockParentId==="000"){
							return false;
						}else{
							return true;
						}
					}
				},
				{field: 'exchange', title: '交易所', sort: true,
					templet:function (item) {
						if (item.exchange=="1"){
							return '上交所';
						}else if (item.exchange=="2"){
							return '深交所';
						}
					}
				},
				{field: 'securitiesDesc', title: '备注', sort: true},
				{title: '操作', minWidth: 100, toolbar: '#barDemo', align: "center"}
			]
		],
		limits: [10, 15, 20, 25, 50, 100],
		limit: 15,
		page: true,
		skin: 'line'
	});

	//给工具条的按钮添加事件
	table.on('toolbar(userTable)', function (obj) {
		//获取选中复选框的对象，
		var checkStatus = table.checkStatus(obj.config.id);//得到表格选中行的ID
		switch (obj.event) {
			case 'add':
				var index = layer.open({
					type: 1,
					title: '添加数据信息',
					closeBtn: 1,
					move: false,
					content: $("#addContent"),
					btn: []
				});
				form.render();
				//全屏
				layer.full(index);
				break;
			case 'search':
				alert("搜索");
				var securitiesIds = $("#securitiesId_3").val();
				var securitiesNames = $("#securitiesNames_3").val();
				var securitiesTypes = $("#exchangeName_3").val();
				var exchanges =  $("#rateType_3").val();
				//表格的重新加载事件
				table.reload('userTable', {
					method: 'post'
					, where: {
						'securitiesIds': securitiesIds,
						'securitiesNames': securitiesNames,
						'securitiesTypes': securitiesTypes,
						'exchanges': exchanges
					}
					, page: {
						curr: 1
					}
				});
				break;
			case 'deleteAll':
				var data = checkStatus.data;
				//    layer.alert(JSON.stringify(data));
				if (data.length == 0) {
					layer.msg("请至少选择一条数据",)
				} else {
					var securitiesIds = [];
					for (var i = 0; i < data.length; i++) {
						securitiesIds.push(data[i].securitiesId);
					}
					layer.confirm('真的删除行么', {icon: 2}, function (index) {
						layer.close(index);
						$.post("/Securities/deleteSecurities2", {securitiesId: securitiesIds.join(',')}, function (msg) {
							table.reload('userTable');
							layer.msg('删除' + checkStatus.data.length + '条记录', {
								title: '提示',
								area: ['200px', '140px'],
								time: 0,
								btn: ['知道了']
							});
						});
					});
				}
				break;
		}
	});
	//给表格编辑，删除按钮添加点击事件
	table.on('tool(userTable)', function (obj) {
		var data = obj.data;//得到删除行整行的数据
		alert(data.securitiesId);
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', {icon: 2}, function (index) {
				layer.close(index);
				$.post("../Securities/deleteSecurities",{securitiesId: data.securitiesId}, function (msg) {
					table.reload('userTable');
				});

			});
		} else if (obj.event === 'edit') {
			alert(JSON.stringify(data));
			form.val('editform', $.parseJSON(JSON.stringify(data)));
			var index = layer.open({
				type: 1,
				title: '修改证券信息',
				closeBtn: 1,
				move: false,
				area: ['500px', '400px'],
				content: $('#editContent')
			});

			form.render();
			layer.full(index);
		};
	})
});
function myclose() {
	layer.closeAll();
}