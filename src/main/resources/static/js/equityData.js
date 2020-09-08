layui.use(['element', 'form', 'table', 'layer', 'laydate'], function () {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var formSelects = layui.formSelects;
    var laydate = layui.laydate;

    //执行一个laydate实例,显示日期
    laydate.render({
        elem: '#equitiesExright3' //指定元素
    });
    laydate.render({
        elem: '#start'
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
    laydate.render({
        elem: '#start2'
    });
    laydate.render({
        elem: '#equitiesRecord2'
    });
    laydate.render({
        elem: '#equitiesExright2'
    });
    laydate.render({
        elem: '#receivedDate2'
    });


    //新增提交
    form.on('submit(addsubmit)', function(data){
        var formData=$('#addform').serialize();
        $.post("../insertEquityData",formData,function(msg){
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
        alert(formData)
        $.post("../updateEquityData",formData,function(msg){
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

    //表格渲染
    table.render({
        elem: '#userTable',
        url: '../selectEquityData',
        page: true,
        toolbar: '#userToolBar',//显示在表头的工具条
        cellMinWidth: 50,
        height:'full-70',
        cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'equityDataId', title: '权益编号', align:'center', hide: true}
                ,{field: 'dateTime', title: '业务日期', align:'center', hide: true}
                ,{field: 'securityId', title: '证券ID', align:'center'}
                ,{field: 'securitiesName', title: '证券名称', align:'center'}
                ,{field: 'equitiesRecord', title: '权益登记日', align:'center'}
                ,{field: 'equitiesExright', title: '权益除权日', align:'center'}
                ,{field: 'receivedDate', title: '到账日期', align:'center'}
                ,{field: 'equitiesType', title: '权益类型', align: 'center',
                templet:function (item) {
                    if (item.equitiesType==1){
                        return '送股';
                    } else if(item.equitiesType=='2'){ return '分红';
                    }
                }
            }
                ,{field: 'proportion', title: '比例(%)', align:'center'}
                ,{field: 'disposeStatus', title: '处理状态', align:'center',
                templet:function (item) {
                    if (item.disposeStatus==0){
                        return '未处理';
                    }
                    return '已处理';
                }
            }
                ,{title: 'operation', title: '操作' , toolbar:'#barDemo', align:'center'}
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
                    content:$("#addContent"),
                    area:['800px','500px'],
                    btn:[]
                });
                form.render();
                //全屏
                // layer.full(index);
                break;

            //搜索按钮的条件查询
            case 'search':
                var equitiesExright= $("#equitiesExright").val();
                var equitiesType= $("#equitiesType").val();
                //表格的重新加载事件
                table.reload('userTable', {
                    method: 'post'
                    , where: {
                        'equitiesExright': equitiesExright,
                        'equitiesType': equitiesType,
                    }
                    , page: {
                        curr: 1
                    }
                });
                break;

            //批量删除
            case 'deleteAll':
                var data = checkStatus.data;
                if(data.length==0){
                    layer.msg("请至少选择一条数据",)
                }else
                {
                    var ids=[];
                    for (var i = 0; i <data.length; i++) {
                        ids.push(data[i].equityDataId);
                    }
                    layer.confirm('真的删除行么',{icon: 2}, function(index){
                        layer.close(index);
                        $.post("../deleteEquityData", {equityDataId:ids.join(',')},function(msg){
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
        if (obj.event === 'del') {
            layer.confirm('真的删除行么',{icon: 2}, function(index){
                layer.close(index);
                $.post("../deleteEquityData", {equityDataId:data.equityDataId+""},function(msg){
                    table.reload('userTable');
                });

            });
        } else if (obj.event === 'edit') {
            form.val('editform',$.parseJSON(JSON.stringify(data)));
            var index = layer.open({
                type: 1,
                title: '修改权益数据',
                closeBtn: 1,
                move:false,
                area: ['800px', '500px'],
                content:$('#editContent')
            });
            form.render();
            //layer.full(index);
        };
    })
});


//取消按钮点击事件
function myclose() {
    layer.closeAll();
}