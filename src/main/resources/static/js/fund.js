layui.use([ 'element', 'form', 'table', 'layer','laydate'], function () {
	var layer = layui.layer;
	var $ = layui.$;
	var table = layui.table;
	var form = layui.form;
	var laydate = layui.laydate;
	// var dynamicCondition=layui.dynamicCondition;
	//执行一个laydate实例
	laydate.render({
		elem: '#start' //指定元素
	});

	laydate.render({
		elem: '#start2'
	});

	laydate.render({
		elem: '#equitiesRecord'
	});

	laydate.render({
		elem: '#equitiesExright'
	});

	laydate.render({
		elem: '#receivedDate'
	});

	//新增提交
	form.on('submit(addsubmit)', function(data){
		var formData=$('#addform').serialize();
		$.post("../insertFund",formData,function(msg){
			if(msg>0){
				table.reload('userTable');
				layer.closeAll();
				layer.msg('添加成功',{
					title : '提示',
					area : [ '200px',
						'140px' ],
					time : 0,
					btn : [ '知道了' ]
				});
			}else{
				layer.closeAll();
				layer.msg('添加失败',{
					title : '提示',
					area : [ '200px',
						'140px' ],
					time : 0,
					btn : [ '知道了' ]
				});
			}
		});
		return false;
	});
	//修改提交
	form.on('submit(editsubmit)', function(data){
		var formData=$('#editform').serialize();
		$.post("../updateFund",formData,function(msg){
			if(msg>0){
				table.reload('userTable');
				layer.closeAll();
				layer.msg('修改成功',{
					title : '提示',
					area : [ '200px',
						'140px' ],
					time : 0,
					btn : [ '知道了' ]
				});
			}else{
				layer.closeAll();
				layer.msg('修改失败',{
					title : '提示',
					area : [ '200px',
						'140px' ],
					time : 0,
					btn : [ '知道了' ]
				});
			}
		});
		return false;
	});
	table.render({
		elem: '#userTable',
		url: '../selectFund',
		page: true,
		height: 'full-20',
		toolbar: '#userToolBar',//显示在表头的工具条
		cellMinWidth:200,
		cols: [
			[ //表头
				{type: 'checkbox', field: 'left'}
				,{field: 'fundId', title: '基金代码', align:'center'}
				,{field: 'fundName', title: '基金名称', align:'center'}
				,{field: 'managerCompany', title: '基金管理公司', align:'center'}
				,{field: 'trusteeCompany', title: '基金托管银行', align:'center'}
				,{field: 'fundType', title: '基金类型', align:'center',templet: function(item){
					if(item.fundType=='2') {return '封闭式';
					} else if(item.fundType=='1'){ return '开放式';
					}
				}},
				{
					field : 'provisionDays',
					title:'计提天数',
					hide:true,
					align: 'center',
					templet :function(items){
						if(items.provisionDays==1){
							return '360';
						}
						if(items.provisionDays==2){
							return '365';
						}
						return '366';
					}
				},
				{fixed:'right',title: '操作' , align:'center',toolbar:'#barDemo'}

			]
		]
	});
	//给工具条的按钮添加事件
	table.on('toolbar(userTable)',function (obj) {
		//获取选中复选框的对象，
		var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
		switch (obj.event) {
			case 'add':
				var index=layer.open({
					type: 1,
					title: '添加基金信息',
					closeBtn: 1,
					move:false,
					content:$("#addContent"),
					btn:[],
					area:['800px','600px']
				});

				form.render();
				//全屏
				// layer.full(index);
				break;
			case 'search':
				alert("搜索");
				var fundId= $("#fundId").val();
				var fundType= $("#fundType").val();
				//表格的重新加载事件
				table.reload('userTable', {
					method: 'post'
					, where: {
						'fundId': fundId,
						'fundType':fundType
					}
					, page: {
						curr: 1
					}
				});

				break;
			case 'deleteAll':
				var data = checkStatus.data;

				if(data.length==0){
					layer.msg("请至少选择一条数据",)
				}else
				{
					var ids=[];
					for (var i = 0; i <data.length; i++) {
						ids.push(data[i].fundId);
					}
					layer.confirm('真的删除行么',{icon: 2}, function(index){
						layer.close(index);
						layer.alert(JSON.stringify(data));
						$.post("../deleteFund", {fundId:ids.join(',')},function(msg){
							table.reload('userTable');
							layer.msg('删除'+checkStatus.data.length+'条记录', {
								title:'提示',
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
	table.on('tool(userTable)', function(obj) {
		var data = obj.data;//得到删除行整行的数据
		alert(data.fundId);
		if (obj.event === 'del') {
			layer.confirm('真的删除行么',{icon: 2}, function(index){
				layer.close(index);
				$.post("../deleteFund", {fundId:data.fundId+""},function(msg){
					table.reload('userTable');
				});

			});
		} else if (obj.event === 'edit') {
			alert(JSON.stringify(data));
			form.val('editform',$.parseJSON(JSON.stringify(data)));
			var index = layer.open({
				type: 1,
				title: '修改基金参数',
				closeBtn: 1,
				move:false,
				area: ['800px', '600px'],
				content:$('#editContent')
			});

			form.render();
			// layer.full(index);
		};
	});

});
//取消事件
function myclose() {
	layer.closeAll();
}
