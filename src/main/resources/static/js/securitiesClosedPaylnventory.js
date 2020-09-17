
layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var formSelects = layui.formSelects;
    var laydate = layui.laydate;

    //执行一个laydate实例
    //时间下拉表
    laydate.render({
        elem: '#dateTime' //指定元素
    });
    laydate.render({
        elem: '#dateTime1' //指定元素
    });
    laydate.render({
        elem: '#dateTime2' //指定元素
    });


    //数据表格
    table.render({
        elem: '#securitiesClosedPayInventoryTable',
        url: '../securitiesClosedPayInventory/select',
        count:0,
        page: true,
        height: 'full-55',
        toolbar: '#securitiesClosedPayInventoryToolBar',//显示在表头的工具条
        minLength:80,
        cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'securitiesClosedPayInventoryId', title: '证券应收应付存库Id'}
                ,{field: 'dateTime', title: '业务日期'}
                ,{field: 'fundId', title: '基金编号'}
                ,{field: 'securitiesId', title: '证券编号'}
                ,{field: 'securitiesName', title: '证券名称', hide: true}
                ,{field: 'securitiesType', title: '证券类型',
                templet:function (item) {
                    if (item.securitiesType==1){
                        return '估值增值';
                    }else if (item.securitiesType==2){
                        return '证券清算款';
                    }else if (item.securitiesType==3){
                        return '债券利息';
                    }
                }
            }
                ,{field: 'totalPrice', title: '总金额'}
                ,{field: 'securitiesClosedPayDesc', title: '备注', hide:true}
                ,{field: 'flag', title: '业务状态',
                templet:function (item) {
                    if (item.flag==1){
                        return '流入';
                    }else if (item.flag==-1){
                        return '流出';
                    }
                }
            }
                ,{field: 'securityPeriodFlag', title: '期初标志',
                templet:function (item) {
                    if (item.securityPeriodFlag==0){
                        return "<span style='color: red'>否</span>";
                    }else if (item.securityPeriodFlag==1){
                        return "<span style='color: green'>是</span>";
                    }
                }
            }
                ,{title: 'right', title: '操作', toolbar:'#barDemo',fixed: 'right'}
            ]
        ]
    });


    //期初数据选中
    form.on('checkbox(initialSigns)', function(data){
        var addbtn = document.getElementById('addbtn');
        if(data.elem.checked){
            addbtn.classList.remove("layui-btn-disabled")
            addbtn.setAttribute("lay-event","add")

        }else{
            addbtn.classList.add("layui-btn-disabled")
            addbtn.setAttribute("lay-event","")
        }
    });


    //新增提交
    form.on('submit(addsubmit)', function(data){
        var formData=$('#addform').serialize();
        $.post("../securitiesClosedPayInventory/insert",formData,function(msg){
            if(msg>0){
                table.reload('securitiesClosedPayInventoryTable');
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
        $.post("../securitiesClosedPayInventory/update",formData,function(msg){
            if(msg>0){
                table.reload('securitiesClosedPayInventoryTable');
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


    //给工具条的按钮添加事件
    table.on('toolbar(securitiesClosedPayInventoryTable)',function (obj) {
        //获取选中复选框的对象，
        var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
        switch (obj.event) {
            case 'add':
                var index=layer.open({
                    type: 1,
                    title: '添加数据信息',
                    closeBtn: 1,
                    move:false,
                    area:['800px','600px'],
                    content:$("#addContent"),
                    btn:[]
                });

                form.render();
                break;

                //条件搜索
            case 'search':
                // alert("搜索");
                var securitiesType= $("#securitiesType2").val();
                var dateTime= $("#dateTime").val();
                //表格的重新加载事件
                table.reload('securitiesClosedPayInventoryTable',{
                    method: 'post'
                    , where: {
                        'securitiesType': securitiesType,
                        'dateTime': dateTime
                    }
                    , page: {
                        curr: 1
                    }
                });
                laydate.render({
                    elem: '#dateTime' //指定元素
                });
                $("#securitiesType2").val(securitiesType);
                $("#dateTime").val(dateTime);
                break;

                //批量删除
            case 'deleteAll':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                if(data.length==0){
                    layer.msg("请至少选择一条数据",)
                }else
                {
                    var ids=[];
                    for (var i = 0; i <data.length; i++) {
                        ids.push(data[i].securitiesClosedPayInventoryId);
                    }
                    layer.confirm('真的删除行么',{icon: 2}, function(index){
                        layer.close(index);
                        $.post("../securitiesClosedPayInventory/delete", {securitiesClosedPayInventoryId:ids.join(',')},function(msg){
                            table.reload('securitiesClosedPayInventoryTable');
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
    table.on('tool(securitiesClosedPayInventoryTable)', function(obj) {
        var data = obj.data;//得到删除行整行的数据
        if (obj.event === 'del') {
            layer.confirm('真的删除行么',{icon: 2}, function(index){
                layer.close(index);
                $.post("../securitiesClosedPayInventory/delete", {securitiesClosedPayInventoryId:data.securitiesClosedPayInventoryId+""},function(msg){
                    table.reload('securitiesClosedPayInventoryTable');
                });

            });
        } else if (obj.event === 'edit') {
            form.val('editform',$.parseJSON(JSON.stringify(data)));
            var index = layer.open({
                type: 1,
                title: '修改现金库存',
                closeBtn: 1,
                move:false,
                area: ['800px', '600px'],
                content:$('#editContent')
            });
            form.render();
        };
    })
});
//取消按钮
function myclose() {
    layer.closeAll();
}


