layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var formSelects = layui.formSelects;
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#end' //指定元素
    });

    laydate.render({
        elem: '#dateTime'
    })

    laydate.render({
        elem: '#dateTime'
    })

    laydate.render({
        elem: '#dateTime1'
    })

    laydate.render({
        elem: '#settlementDate'
    })
    laydate.render({
        elem: '#settlementDate1'
    })


    //新增提交
    form.on('submit(addsubmit)', function(data){
        var formData=$('#addform').serialize();
        $.post("../insertTransactionData",formData,function(msg){
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
        $("#addform")[0].reset();
        return false;
    });
    //修改提交
    form.on('submit(editsubmit)', function(data){
        var formData=$('#editform').serialize();
        $.post("../updateTransactionData",formData,function(msg){
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
        url: '../selectTransactionData',
        page: true,
        height: 'full-55',
        toolbar: '#userToolBar',//显示在表头的工具条
        minLength: 80,
        cellMinWidth:60,
        cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'transactionDataId', title: '交易单号',width:130,align:'center',hide:true}
                ,{field: 'dateTime', title: '交易日期',  width:130, align:'center'}
                ,{field: 'num', title: '交易数量',  width:130, align:'center'}
                ,{field: 'price', title: '交易单价',  width:130,align:'center'}
                ,{field: 'totalSum', title: '结算金额',  width:130, align:'center'}
                ,{field: 'netReceipts', title: '交易金额',  width:130,align:'center'}
                ,{field: 'settlementDate', title: '结算日期', width:130, align:'center'}
                ,{field: 'accountName', title: ' 现金账户', width:130, align:'center'}
                ,{field: 'securitiesName', title: ' 证券名称', width:130, align:'center'}
                ,{field: 'brokersName', title: '券商名称', width:130,  align:'center'}
                ,{field: 'fundId', title: '基金代码', width:130,  align:'center',hide:true}
                ,{field: 'fundName', title: '基金名称',  width:130, align:'center',hide:true}
                ,{field: 'securitiesId', title: '证券ID',  width:130, align:'center',hide:true}
                ,{field: 'brokersId', title: '券商ID',  width:130, align:'center',hide:true}
                ,{field: 'brokersName', title: '券商名称',  width:130, align:'center',hide:true}
                ,{field: 'seateId', title: '席位ID',  width:130, align:'center',hide:true}
                ,{field: 'seateName', title: '席位名称',  width:130, align:'center',hide:true}
                ,{field: 'accountId', title: '现金账户ID',  width:130, align:'center',hide:true}
                ,{field: 'blankName', title: '银行名称',  width:130, align:'center',hide:true}
                ,{field: 'flag', title: '交易表示符1流入,-1流出',  width:130, align:'center',hide:true}
                ,{field: 'commission', title: '佣金费用',  width:130,align:'center',hide:true}
                ,{field: 'transfer', title: '过户费',  width:130, align:'center',hide:true}
                ,{field: 'brokerage', title: '经手费',  width:130, align:'center',hide:true}
                ,{field: 'stamp', title: '印花税',  width:130, align:'center',hide:true}
                ,{field: 'management', title: '征管费', width:130, align:'center',hide:true}
                ,{field: 'security', title: '证券利息',  width:130,align:'center',hide:true}
                ,{field: 'transactionDataDesc', title: '备注',  width:130,align:'center',hide:true}
                ,{field: 'transactionDataMode', title: '交易方式', width:130, align:'center', templet: function(item){
                    if(item.transactionDataMode=='1') {
                        return '买入';
                    } else if(item.transactionDataMode=='2'){
                        return '卖出';
                    } else if(item.transactionDataMode=='3'){
                        return '分红';
                    } else if(item.transactionDataMode=='4'){
                        return '送股';
                    }
                }
            }
                ,{field: 'status', title: '交易状态', width:130, align:'center', templet: function(item){
                    if(item.status=='0') {
                        return '未结算';
                    } else if(item.status=='1'){
                        return '已结算';
                    }
                }
            }
                ,{fixed: 'right',field: 'operation', title: '操作' ,  width:160, align:'center',toolbar:'#barDemo'}
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
                    title: '添加数据信息',
                    closeBtn: 1,
                    move:false,
                    area: ['893px','600px'],
                    content:$("#addContent"),
                    btn:[]
                });
                form.render();
                //全屏弹窗 layer.full(index);
                break;

            case 'search':
                var dateTime= $("#end").val();
                var securitiesName= $("#equityId").val();
                //表格的重新加载事件
                table.reload('userTable', {
                    method: 'post'
                    , where: {
                        'dateTime': dateTime,
                        'securitiesName': securitiesName
                    }
                    , page: {
                        curr: 1
                    }
                });
                laydate.render({
                    elem: '#end' //指定元素
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
                        ids.push(data[i].transactionDataId);
                    }
                    if(data.status==0){
                        layer.confirm('真的删除行么',{icon: 2}, function(index){
                            layer.close(index);
                            $.post("../deleteTransactionData", {transactionDataId:ids.join(',')},function(msg){
                                table.reload('userTable');
                                layer.msg('删除'+checkStatus.data.length+'条记录', {
                                    title:'提示',
                                    area: ['200px', '140px'],
                                    time: 0,
                                    btn: ['知道了']
                                });
                            });
                        });
                    }else {
                        layer.confirm('不能删除已结算数据');
                    }
                }
                break;
        }
    });
    //给表格编辑，删除按钮添加点击事件
    table.on('tool(userTable)', function(obj) {
        var data = obj.data;//得到行整行的数据
        // alert(data.transactionDataId);
        if (obj.event === 'del') {
           var status= data.status;
           if(status==0){
               layer.confirm('真的删除行么',{icon: 2}, function(index){
                   layer.close(index);
                   $.post("../deleteTransactionData", {transactionDataId:data.transactionDataId+""},function(msg){
                       table.reload('userTable');
                   });

               });
           }else {
               layer.confirm('不能删除已结算数据');
           }

        } else if (obj.event === 'edit') {
            // alert(JSON.stringify(data));
            form.val('editform',$.parseJSON(JSON.stringify(data)));
            var index = layer.open({
                type: 1,
                title: '修改交易数据',
                closeBtn: 1,
                move:false,
                area: ['893px','600px'],
                content:$('#editContent')
            });
            form.render();
            //全屏弹窗 layer.full(index);
        }
    })
});

//取消事件
function myclose() {
    layer.closeAll();
}
