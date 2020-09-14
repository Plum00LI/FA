layui.use(['form', 'table', 'layer','laydate','jquery'], function() {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var laydate = layui.laydate;
    table =  $.extend(table, {config: {checkName: 'checked'}});

    table.render({
        elem : '#mytable',
        url : '../assetValuationController/selecAssetValuationData',
        //data:data,
        page : true,
        height : 498,
        toolbar : '#toolbarDemo',
        skin: 'row',
        even: true,
       /* done:function(res){
            $.each(res,function(index,item){
            console.log(item)
            var strSub= [];
            for(var i=0;i<item.length;i++){
                if(item[i].strAppraisement != null){
                    strSub=item[i].strAppraisement.split(',');
                    for(var j=0;j<strSub.length;j++){
                        if(strSub[i] ==1){
                            item[i].checked = true;
                        }
                        if(strSub[i] ==2){
                            item[i].checked = true;
                        }
                    }
                }
                }
            })
        },*/
        cols : [ [
            {
                field:'assetValuationId',
                checkbox:true
            }, {
                field : 'assetValuationType',
                align: 'center',
                title : '业务类型'
            }, {
                field : 'state',
                align: 'center',
                title : '状态'
            }] ]
    });

    laydate.render({
        elem:'#valuation1',
        type:'date',
        value:new Date(),
        done:function(value){
            var checked = table.checkStatus('mytable').data;
            var strAppraisement = [];
            for(var i=0;i<checked.length;i++){
                strAppraisement.push(checked[i].assetValuationId);
            }
            var toDay = value;
            table.reload('mytable', {
                page: {curr: 1},
                where:{
                    toDay:toDay,
                    strAppraisement:strAppraisement.join(",")

                }
            });
            date1(value);
        }
    })
    function date1(val){
        $("#valuation1").remove();
        $("#valuation2").before('<input type="text" name="toDay" readonly="readonly"  style="height: 32px;" class="layui-input" id="valuation1" />');
        laydate.render({
            elem: '#valuation1',//指定元素
            value:val,
            done:function(value){
                var checked = table.checkStatus('mytable').data;
                var strAppraisement = [];
                for(var i=0;i<checked.length;i++){
                    strAppraisement.push(checked[i].assetValuationId);
                }
                table.reload('mytable', {
                    page: {curr: 1},
                    where:{
                        toDay:value,
                        strAppraisement:strAppraisement.join(",")
                    }
                });
                //$("#valuation1").val(value);
                date2(value);
            }
        });
    }
    function date2(val){
        $("#valuation1").remove();
        $("#valuation2").before('<input type="text" name="toDay" readonly="readonly"  style="height: 32px;" class="layui-input" id="valuation1" />');
        laydate.render({
            elem: '#valuation1',//指定元素
            value:val,
            done:function(value){
                var checked = table.checkStatus('mytable').data;
                var strAppraisement = [];
                for(var i=0;i<checked.length;i++){
                    strAppraisement.push(checked[i].assetValuationId);
                }
                table.reload('mytable', {
                    page: {curr: 1},
                    where:{
                        toDay:value,
                        strAppraisement:strAppraisement.join(",")
                    }
                });
                //$("#valuation1").val(value);
                date1(value);
            }
        });
    }

    table.on('toolbar(mytable)', function(obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        var data=checkStatus.data;
        switch (obj.event) {
            case 'valuation':
                if(data.length === 0){
                    layer.msg("请选择估值项")
                }else{
                    var toDay= $("#valuation1").val();
                    if(toDay == null || toDay == ''){
                        layer.msg("请输入日期")
                    }else{
                        var strJson = [];
                        for (var i = 0; i < data.length; i++) {
                            strJson.push(data[i].assetValuationId)
                        }
                        layer.confirm('是否确认估值？', {
                            btn: ['确认','取消'] ,//按钮
                            icon:1
                        }, function(){
                            layer.closeAll('dialog');
                            $.post('assetValuationController/selectAllAssetValuation',{toDay:toDay,strAppraisement:strJson.join(",")},function(res){
                                if(res.assetValuationList == ''){
                                    //边缘弹出
                                    layer.open({
                                        type: 1
                                        ,offset: 'rb' //具体配置参考：offse t参数项
                                        ,content: '<div style="padding: 15px 80px;">估值失败，请检查当天的证券库存</div>'
                                        ,skin: 'layui-layer-molv'
                                        ,btn: '关闭'
                                        ,time: 4000
                                        ,btnAlign: 'c' //按钮居中
                                        ,shade: 0 //不显示遮罩
                                        ,yes: function(){
                                            layer.closeAll();
                                        }
                                    });
                                }else if(res.cashClosedPays != '' || res.taTransactionList != ''){
                                    table.reload('mytable', {
                                        page: {curr: 1},
                                        where:{
                                            toDay:toDay,
                                            strAppraisement:strJson.join(",")
                                        }
                                    });
                                    //边缘弹出
                                    layer.open({
                                        type: 1
                                        ,offset: 'rb' //具体配置参考：offset参数项
                                        ,content: '<div style="padding: 15px 80px;">估值完毕！</div>'
                                        ,skin: 'layui-layer-molv'
                                        ,btn: '关闭'
                                        ,time: 4000
                                        ,btnAlign: 'c' //按钮居中
                                        ,shade: 0 //不显示遮罩
                                        ,yes: function(){
                                            layer.closeAll();
                                        }
                                    });
                                    date1(toDay)
                                }
                            })
                        });
                    }
                }
                break;
        }
    });
});