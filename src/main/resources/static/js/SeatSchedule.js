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
    laydate.render({
        elem: '#datetime' //指定元素
    });

    //查询表格渲染
    table.render({
        elem: '#userTable',
        url: '../SeatSchedule/selectSeatSchedule',
        toolbar: '#userToolBar',
        defaultToolbar: ['filter', 'exports', 'print'],
        height:'full-20',
        cellMinWidth:60,
        cols: [
            [
                {type: "checkbox", width: 50},
                {field: 'securitiesId', title: '证券代码', sort: true},
                {field: 'fundName', title: '基金名称'},
                {field: 'flag', title: '交易标识', sort: true,
                    templet:function (item) {
                        if (item.securitiesType=="1"){
                            return '流入';
                        }else if (item.securitiesType=="-1"){
                            return '流出';
                        }
                    }
                },
                {field: 'num', title: '数量', sort: true},
                {field: 'price', title: '交易价格(单价)', sort: true},
                {field: 'commission', title: '佣金费', sort: true},
                {field: 'transfer', title: '过户费', sort: true},
                {field: 'brokerage', title: '经手费', sort: true},
                {field: 'stamp', title: '印花税', sort: true},
                {field: 'management', title: '征管费', sort: true},
                {field: 'totalSum', title: '交易金额', sort: true},
                {field: 'netReceipts', title: '实付金额', sort: true},
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
            case 'search':
                alert("搜索");
                var seateId = $("#seatTypes").val();
                var datefind = $("#datefind").val();
                var settlementDate =  $("#datetime").val();
                //表格的重新加载事件
                table.reload('userTable', {
                    method: 'post'
                    , where: {
                        'seateId': seateId,
                        'datefind': datefind,
                        'settlementDate': settlementDate
                    }
                    , page: {
                        curr: 1
                    }
                });
                break;
        }
    });
});
function myclose() {
    layer.closeAll();
}