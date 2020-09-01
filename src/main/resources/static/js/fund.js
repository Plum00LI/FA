layui.config({
	base: 'exts/',
})
layui.use([ 'element', 'form', 'table', 'layer','dynamicCondition','tableSelect','laydate'], function() {
	var layer = layui.layer;
	var dynamicCondition=layui.dynamicCondition;
	var $ = layui.$;
	var table = layui.table;
	var form = layui.form;
	var formSelects = layui.formSelects;
	var tableSelect = layui.tableSelect;
	 var laydate = layui.laydate;
	 
	
	$('.cancel').click(function(){
		layer.closeAll();
	});
	//新增提交
	form.on('submit(addsubmit)', function(data){
		var formData=$('#addform').serialize();
		$.post("fund/insertFund",formData,function(msg){
			if(msg>0){
				$("#addform")[0].reset();
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
	form.on('submit(editsubmit)', function(data){
		var formData=$('#editform').serialize();
		$.post("fund/updateFund",formData,function(msg){
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
		elem : '#userTable',
		url : 'fund/selectFund',
		page : true,
		height : 498,
		toolbar : '#toolbarDemo',
		cols : [ [
     		{
				field : 'id',
				checkbox : true
			},
      		{
				field : 'fundId',
				align: 'center',
				title : '基金代码',
				style:'color: #01BDF4;'
			}, {
				field : 'fundName',
				align: 'center',
				title : '基金名称',

			}, {
				field : 'managerCompany',
				title : '基金管理公司',
				align: 'center',
				

			}, {
				field : 'trusteeCompany',
				title : '基金托管银行',
				align: 'center'

			}
			, {
				field : 'trusteeBlank',
				title : '基金托管银行id',
				align: 'center',
					hide:true,
			}
			, {
				field : 'fundType',
				title : '基金类型',
				align: 'center',
				templet :function(item){
					if(item.fundType==1){
						return '开放式';
					}
					return '封闭式';
					}

			},  {
				field : 'sizeOfThe',
				title : '基金规模',
				hide:true,
				align: 'center',
				
			}, 
			   {
				field : 'accountId',
				title:'现金账户',
				hide:true,
				align: 'center',
				
			}, 
			 {
				field : 'initNetWorth',
				title:'资产净值',
				hide:true,
				align: 'center',
				
			},
			 {
				field : 'managerRate',
				title:'管理人费率',
				hide:true,
				align: 'center',
				
			},
			 {
				field : 'hostingRate',
				title:'托管人费率',
				hide:true,
				align: 'center',
				
			},
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
			{
				field : 'setUpDate',
				title:'成立日期',
				  hide:true,
				align: 'center',
				templet :function(item){
					var a=item.setUpDate.substring(0,item.setUpDate.length-9);
					return a;
				}
				
			},
			{
				field : 'fundDesc',
				title:'备注',
				hide:true,
				align: 'center',
			},
			{
				field : 'managerId',
				title:'基金公司id',
				hide:true,
				align: 'center',
				
			},
			{
				fixed : 'right',
				title : '操作',
				toolbar : '#barDemo',
				width : 150
			} 
		] ]
	});

	  form.verify({
  numbers: function(value){
      if(value.length < 6){
        return '至少要6位数';
      }
    }
	 })
	 laydate.render({
    elem: '#date'
  });
   laydate.render({
    elem: '#dates'
  });
			
tableSelect.render({
	elem: '#fundcompany',	//定义输入框input对象 必填
	checkedKey: 'managerCompany', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'managerCompany',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '请根据管理公司搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'manager/selectmanager',
		cols: [[
		{
		 type: 'radio'
		},
		{
				field : 'managerId',
				align: 'center',
				title : '管理人id ',

			}, {
				field : 'managerCompany',
				title : '管理人名称   ',
				align: 'center',

			}, {
				field : 'managerFee',
				title : '管理费率  ',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
			var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.managerCompany);
				$("#fundcompany01").val(item.managerId);
			})
			elem.val(NEWJSON.join(","));
	}
})

/*tableSelect.render({
	elem: '#accountmoney',	//定义输入框input对象 必填
	checkedKey: 'accountId', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'accountName',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		//data:data4,
		cols: [[{
		 type: 'radio'
		},
		{
				field : 'accountId',
				align: 'center',
				title : '账户id ',

			}, {
				field : 'accountName',
				title : '账户名称 ',
				align: 'center',

			}, {
				field : 'blankName',
				title : '开户银行',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
		var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.accountId);
			})
			elem.val(NEWJSON.join(","));
	}
}) 

*/


	tableSelect.render({
	elem: '#fundbank',	//定义输入框input对象 必填
	checkedKey: 'trusteeCompany', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'trusteeCompany',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '请根据托管公司搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'trustee/selectTrustee',
		cols: [[
		{
		 type: 'radio'
		},
		{
				field : 'trusteeId',
				align: 'center',
				title : '托管id',

			}, {
				field : 'trusteeCompany',
				title : '托管人名称  ',
				align: 'center',

			}, {
				field : 'trusteeFee',
				title : '托管费率 ',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
			var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.trusteeCompany);
				$("#fundbank01").val(item.trusteeId);
			
			})
			elem.val(NEWJSON.join(","));
	}
})
	table.on('toolbar(userTable)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'add':
			var index=layer.open({
				type: 1,
				title: '添加基金',
				closeBtn: 1,
				move:false,
				content:$('#addContent'),
				btn:[]
			});
			form.render();
			//全屏
			layer.full(index);
			break;
		case 'search':
			var fundidVal = $('#fundId').val();
		    var fundtypeVal = $('#fundType').val();
			table.reload('userTable', {
				page: {
				  curr: 1
				},
				where:{
					fundId:fundidVal,
					fundType:fundtypeVal
				}
			});
			$("#fundId").remove();
			$("#fundIds2").before('<input type="text" id="fundIds003"  style="width: 190px;height: 32px;"  autocomplete="off" class="layui-input">');
			 
			/*$("#fundType").remove();
			$("#fundTypes01").before('<select id="fundTypes001" name="fundType"><option value=""></option><option value="1">开放式</option><option value="0">封闭式</option></select>');
			 */
			$('#fundIds003').val(fundidVal);
			// $('#fundTypes001').val(1);
			 form.render();
			break;
		case 'delete':
			if(checkStatus.data.length==0){
				layer.msg('请至少选择一行数据',{time:800});	
			}else{
				var ids=[];
				for (var i = 0; i < checkStatus.data.length; i++) {
					ids.push(checkStatus.data[i].fundId);
				}
				layer.confirm('真的删除行么',{icon: 2}, function(index){
					layer.close(index);
					$.post("fund/deleteFunds", {fundId:ids.join(',')},function(msg){
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
	table.on('tool(userTable)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除行么',{icon: 2}, function(index){
				layer.close(index);
				$.post("fund/deleteFund", {fundId:data.fundId+""},function(msg){
					table.reload('userTable');
				});
				
			});
		} else if (obj.event === 'edit') {
			form.val('editform',$.parseJSON(JSON.stringify(data)));
			
			 $("#dates").val(data.setUpDate.substring(0,data.setUpDate.length-11));
		$('#fundcompanys').attr('ts-selected',data.managerCompany);
		$('#fundbanks').attr('ts-selected',data.trusteeCompany);
		
			
	tableSelect.render({
	elem: '#fundcompanys',	//定义输入框input对象 必填
	checkedKey: 'managerCompany', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'managerCompany',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '请根据管理公司搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'manager/selectmanager',
		cols: [[
		{
		 type: 'radio'
		},
		{
				field : 'managerId',
				align: 'center',
				title : '管理人id ',

			}, {
				field : 'managerCompany',
				title : '管理人名称   ',
				align: 'center',

			}, {
				field : 'managerFee',
				title : '管理费率  ',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
			var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.managerCompany);
				$("#managerId").val(item.managerId);
			})
			elem.val(NEWJSON.join(","));
	}
})
	
/*	 tableSelect.render({
	elem: '#accountmoneys',	//定义输入框input对象 必填
	checkedKey: 'accountId', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'accountName',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		//data:data4,
		cols: [[{
		 type: 'radio'
		},
		{
				field : 'accountId',
				align: 'center',
				title : '账户id ',

			}, {
				field : 'accountName',
				title : '账户名称 ',
				align: 'center',

			}, {
				field : 'blankName',
				title : '开户银行',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
		var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.accountId);
			})
			elem.val(NEWJSON.join(","));
	}
}) */
	tableSelect.render({
	elem: '#fundbanks',	//定义输入框input对象 必填
	checkedKey: 'trusteeCompany', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'trusteeId',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '请根据托管公司搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'trustee/selectTrustee',
		cols: [[
		{
		 type: 'radio'
		},
		{
				field : 'trusteeId',
				align: 'center',
				title : '托管id',

			}, {
				field : 'trusteeCompany',
				title : '托管人名称  ',
				align: 'center',

			}, {
				field : 'trusteeFee',
				title : '托管费率 ',
				align: 'center',
			}
		]]
	},
	done: function (elem, data) {
			var NEWJSON = []
			layui.each(data.data, function (index, item) {
				NEWJSON.push(item.trusteeCompany);
				 $("#trusteeId").val(item.trusteeId);
			})
			elem.val(NEWJSON.join(","));
	}
})
			var index = layer.open({
				type: 1,
				title: '修改基金信息',
				closeBtn: 1,
				move:false,
				area: ['500px', '400px'],
				content:$('#editContent')
			});
			 form.render();
			/*$.ajax({
				url : 'role/getRoleListForSelect',
				success : function(data) {
					console.log(JSON.parse(JSON.stringify(data)));
					formSelects.data('edit', 'local', {
						arr : JSON.parse(JSON.stringify(data))
					});
					formSelects.value('edit', [roleId]);
				}
			})*/
			layer.full(index);
		}
	});
});