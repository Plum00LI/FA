layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var formSelects = layui.formSelects;
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#selectEnd',//指定元素
    });
    //执行一个laydate实例
    laydate.render({
        elem: '#end'//指定元素
    });
    //执行一个laydate实例
    laydate.render({
        elem: '#up'//指定元素
    });
    //表格加载
    table.render({
        elem: '#userTable',
        url: '../selectDeposit',
        page: true,
        toolbar: '#userToolBar',//显示在表头的工具条
        cellMinWidth:60,
        height:'full-70',
        cols: [
            [ //表头
                {field: 'depositId', title: '存款业务Id',align:'center',hide:true}
                ,{field: 'fundId', title: '基金Id',align:'center',hide:true}
                ,{field: 'outAccountId', title: '流出账户Id',align:'center',hide:true}
                ,{field: 'outAccountName', title: '流出账户名称',align:'center'}
                ,{field: 'inAccountId', title: '流入账户Id',align:'center',hide:true}
                ,{field: 'intAccountName', title: '流入账户名称',align:'center'}
                ,{field: 'money', title: '存款金额',align:'center'}
                ,{field: 'interest', title: '所含利息',align:'center',hide:true}
                ,{field: 'businessType', title: '业务类型',align:'center',
                templet:function (item) {
                    if (item.businessType==1){
                        return '定期三天';
                    }else if (item.businessType==2){
                        return '定期七天';
                    }
                    return  '活期存款';
                }

            }
                ,{field: 'directionOfMoney', title: '调拨方向',align:'center',hide:true,
                templet:function (item) {
                    if (item.directionOfMoney==1){
                        return '流入';
                    }
                    return  '流出';
                }
            }
                ,{field: 'businessDate', title: '业务时间',align:'center',hide:true}
                ,{field: 'endDate', title: '到期日期',align:'center'}
                ,{field: 'flag', title: '是否处理',align:'center',
                templet:function (item) {
                    if (item.flag==0){
                        return '未办理';
                    }
                    return  '已办理';
                }

            }
                ,{field: 'right', title: '操作',width: 180, align:'center', toolbar: '#barDemo'}
            ]
        ]
    });
    //新增提交
    form.on('submit(addsubmit)', function(data){
        var formData=$('#addform').serialize();
        $.post("../user/insertUser",formData,function(msg){
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
        $.post("../user/updateUser",formData,function(msg){
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
    //给工具条的按钮添加事件
    table.on('toolbar(userTable)',function (obj) {
        //获取选中复选框的对象，
        var checkStatus=table.checkStatus(obj.config.id);//得到表格选中行的ID
        switch (obj.event) {
            case 'add':
                var index=layer.open({
                    type: 1,
                    title: '添加存款',
                    closeBtn: 1,
                    move:false,
                    content:$("#addContent"),
                    area:['700px','500px'],
                    btn:[]
                });
                $.ajax({
                    url:'../user/selectRole',
                    dataType:'json',
                    type:'post',
                    success:function(obj){
                        $.each(obj,function(index,item){
                            $('#roleId').append(new Option(item.roleName,item.roleId));//往下拉菜单里添加元素
                        })
                        form.render();//菜单渲染 把内容加载进去
                    }
                })
                form.render();
                //全屏
                //layer.full(index);
                break;
            case 'search':
                alert("搜索");
                var businessType= $("#businessType").val();
                var endDate= $("#selectEnd").val();
                //表格的重新加载事件
                table.reload('userTable', {
                    method: 'post'
                    , where: {
                        'businessType': businessType,
                        'endDate': endDate,
                    }
                    , page: {
                        curr: 1
                    }
                });

                break;
            case 'deleteAll':
                var data = checkStatus.data;
                //    layer.alert(JSON.stringify(data));
                if(data.length==0){
                    layer.msg("请至少选择一条数据",)
                }else
                {
                    var ids=[];
                    for (var i = 0; i <data.length; i++) {
                        ids.push(data[i].userId);
                    }
                    layer.confirm('真的删除行么',{icon: 2}, function(index){
                        layer.close(index);
                        $.post("../user/deleteUser", {userId:ids.join(',')},function(msg){
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
        alert(data.userId);
        if (obj.event === 'del') {
            layer.confirm('真的删除行么',{icon: 2}, function(index){
                layer.close(index);
                $.post("../user/deleteUser", {userId:data.userId+""},function(msg){
                    table.reload('userTable');
                });

            });
        } else if (obj.event === 'edit') {
            alert(JSON.stringify(data));

            form.val('editform',$.parseJSON(JSON.stringify(data)));
            var index = layer.open({
                type: 1,
                title: '修改员工',
                closeBtn: 1,
                move:false,
                area:['700px','500px'],
                content:$('#editContent')
            });
            form.render();
            //layer.full(index);
        };
    })


});
function myclose() {
    layer.closeAll();
}