
layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
	var layer = layui.layer;
	var $ = layui.$;
	var table = layui.table;
	var form = layui.form;
	var formSelects = layui.formSelects;
	var laydate = layui.laydate;

	//执行一个laydate实例
	laydate.render({
		elem: '#start' //指定元素
	});
	laydate.render({
		elem: '#start3'
	})
	laydate.render({
		elem: '#start2'
	})

	laydate.render({
		elem: '#equitiesRecord'
	})

	laydate.render({
		elem: '#equitiesExright'
	})

	laydate.render({
		elem: '#receivedDate'
	})

	//新增提交
	form.on('submit(addsubmit)', function (data) {
		var formData = $('#addform').serialize();
		$.post("/cashClosedPay/insertCashClosedPay", formData, function (msg) {
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
		$.post("/cashClosedPay/updateCashClosedPay", formData, function (msg) {
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
	table.render({
		elem: '#userTable',
		url: '/cashClosedPay/selectCashClosedPay',
		page: true,
		height: 498,
		toolbar: '#userToolBar',//显示在表头的工具条
		minLength: 80,
		cellMinWidth: 60,
		cols: [
			[ //表头
				{type: 'checkbox', fixed: 'left'}
				, {field: 'cashClosedPayId', title: '现金应收应付编号', align: 'center',hide:true}
				, {field: 'fundId', title: '基金代码', align: 'center',hide:true}
				, {field: 'fundName', title: '基金名称', align: 'center',hide:true}
				, {field: 'dateTime', title: '业务日期', align: 'center'}
				, {field: 'accountId', title: '银行编号', align: 'center'}
				, {field: 'accountName', title: '账户名称', align: 'center'}
				, {field: 'serviceType', title: '业务类型', align: 'center'
				, templet: function (item) {
					if (item.serviceType == '1') {
						return '管理费';
					} else if (item.serviceType == '2') {
						return '托管费';
					} else if (item.serviceType == '3') {
						return '存款利息';
					} else if (item.serviceType == '4') {
						return '申购赎回款';
					}
				}}
				, {
				field: 'flag', title: '资金流向', align: 'center'
				, templet: function (item) {
					if (item.flag == '1') {
						return '流入';
					} else if (item.flag == '-1') {
						return '流出';
					}
				}}
				, {field: 'amount', title: '金额', align: 'center'}
				, {title: '操作', minWidth: 100, toolbar: '#barDemo', align: "center"}
			]
		]
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
				var dateTime = $("#start").val();
				var serviceType=$("#serviceType").val();
				//表格的重新加载事件
				table.reload('userTable', {
					method: 'post'
					, where: {
						'dateTime': dateTime,
						'serviceType': serviceType
					}
					, page: {
						curr: 1
					}
				});
				break;

			case 'deleteAll':
				var data = checkStatus.data;
				if (data.length == 0) {
					layer.msg("请至少选择一条数据",)
				} else {
					var ids = [];
					for (var i = 0; i < data.length; i++) {
						ids.push(data[i].cashClosedPayId);
					}
					layer.confirm('真的删除行么', {icon: 2}, function (index) {
						layer.close(index);
						$.post("/cashClosedPay/deleteCashClosedPay", {cashClosedPayId: ids.join(',')}, function (msg) {
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
		alert(data.cashClosedPayId);
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', {icon: 2}, function (index) {
				layer.close(index);
				$.post("/cashClosedPay/deleteCashClosedPay", {cashClosedPayId: data.cashClosedPayId + ""}, function (msg) {
					table.reload('userTable');
				});

			});
		} else if (obj.event === 'edit') {
			alert(JSON.stringify(data));

			form.val('editform', $.parseJSON(JSON.stringify(data)));
			var index = layer.open({
				type: 1,
				title: '修改权益数据',
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