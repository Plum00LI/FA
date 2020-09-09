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
    table.render({
        elem: '#userTable',
        url: '../selectTransactionData',
        page: true,
        height:'full-55',
        toolbar: '#userToolBar',//显示在表头的工具条
        minLength: 80,
        cellMinWidth:60,
        cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'transactionDataId', title: '交易单号', width: 170, align: 'center', hide: true}
                , {field: 'accountName', title: '现金账户', width: 100, align: 'center'}
                , {field: 'securitiesName', title: '证券名称', width: 100, align: 'center'}
                , {field: 'brokersName', title: '券商名称', width: 100, align: 'center'}
                , {field: 'price', title: '交易单价', width: 100, align: 'center'}
                , {field: 'num', title: '交易数量', width: 100, align: 'center'}
                , {field: 'totalSum', title: '交易总金额', width: 100, align: 'center'}
                , {field: 'netReceipts', title: '实收金额', width: 100, align: 'center'}
                , {
                field: 'transactionDataMode', title: '交易方式', width: 100, align: 'center',
                templet: function (item) {
                    if (item.transactionDataMode == 1) {
                        return '买入';
                    } else if (item.transactionDataMode == 2) {
                        return '卖出';
                    } else if (item.transactionDataMode == 3) {
                        return '分红';
                    } else if (item.transactionDataMode == 4) {
                        return '送股';
                    }
                }
            }
                , {field: 'dateTime', title: '交易日期', width: 100, align: 'center'}
                , {field: 'settlementDate', title: '结算状态', width: 100, align: 'center'}
                , {
                field: 'status', title: '交易状态', width: 100, align: 'center',
                templet: function (item) {
                    if (item.state == 0) {
                        return '未结算';
                    } else if (item.state == 1) {
                        return '结算';
                    }
                }
            }
                , {field: 'fundId', title: '基金代码', width: 130, align: 'center',hide:true}
                , {field: 'fundName', title: '基金名称', width: 130, align: 'center',hide:true}
                , {field: 'securitiesId', title: '证券Id', width: 130, align: 'center',hide:true}
                , {field: 'brokersId', title: '券商Id', width: 130, align: 'center',hide:true}
                , {field: 'brokersName', title: '券商名称', width: 130, align: 'center',hide:true}
                , {field: 'seateId', title: '席位Id', width: 130, align: 'center',hide:true}
                , {field: 'seateName', title: '席位名称', width: 130, align: 'center',hide:true}
                , {field: 'accountId', title: '现金账户ID', width: 130, align: 'center',hide:true}
                , {field: 'blankName', title: '银行名称', width: 130, align: 'center',hide:true}
                , {field: 'flag', title: '交易标识,1流入，-1流出', width: 130, align: 'center',hide:true}
                , {field: 'commission', title: '佣金费用（券商）', width: 130, align: 'center',hide:true}
                , {field: 'transfer', title: '过户费（交易所）', width: 130, align: 'center',hide:true}
                , {field: 'brokerage', title: '经手费（交易所）', width: 130, align: 'center',hide:true}
                , {field: 'stamp', title: '印花税（上交国家的税）', width: 130, align: 'center',hide:true}
                , {field: 'management', title: '征管费（上交国家的税）', width: 130, align: 'center',hide:true}
                , {field: 'security', title: '证券利息', width: 130, align: 'center',hide:true}
                ,{field: 'operation', title: '操作' , width: 150, align:'center',toolbar:'#barDemo'}
            ]
        ]
    });
    table.render({
        elem: '#userTable2',
        url: '../selectTransactionData',
        page: true,
        height: 'full-55',
        toolbar: '#userToolBar',//显示在表头的工具条
        minLength: 80,
        cellMinWidth:60,
        cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'transactionDataId', title: '交易单号', width: 170, align: 'center', hide: true}
                , {field: 'accountName', title: '现金账户', width: 100, align: 'center'}
                , {field: 'securitiesName', title: '证券名称', width: 100, align: 'center'}
                , {field: 'brokersName', title: '券商名称', width: 100, align: 'center'}
                , {field: 'price', title: '交易单价', width: 100, align: 'center'}
                , {field: 'num', title: '交易数量', width: 100, align: 'center'}
                , {field: 'totalSum', title: '交易总金额', width: 100, align: 'center'}
                , {field: 'netReceipts', title: '实收金额', width: 100, align: 'center'}
                , {
                field: 'transactionDataMode', title: '交易方式', width: 100, align: 'center',
                templet: function (item) {
                    if (item.transactionDataMode == 1) {
                        return '买入';
                    } else if (item.transactionDataMode == 2) {
                        return '卖出';
                    } else if (item.transactionDataMode == 3) {
                        return '分红';
                    } else if (item.transactionDataMode == 4) {
                        return '送股';
                    }
                }
            }
                , {field: 'dateTime', title: '交易日期', width: 100, align: 'center'}
                , {field: 'settlementDate', title: '结算状态', width: 100, align: 'center'}
                , {
                field: 'status', title: '交易状态', width: 100, align: 'center',
                templet: function (item) {
                    if (item.state == 0) {
                        return '未结算';
                    } else if (item.state == 1) {
                        return '结算';
                    }
                }
            }
                , {field: 'fundId', title: '基金代码', width: 130, align: 'center',hide:true}
                , {field: 'fundName', title: '基金名称', width: 130, align: 'center',hide:true}
                , {field: 'securitiesId', title: '证券Id', width: 130, align: 'center',hide:true}
                , {field: 'brokersId', title: '券商Id', width: 130, align: 'center',hide:true}
                , {field: 'brokersName', title: '券商名称', width: 130, align: 'center',hide:true}
                , {field: 'seateId', title: '席位Id', width: 130, align: 'center',hide:true}
                , {field: 'seateName', title: '席位名称', width: 130, align: 'center',hide:true}
                , {field: 'accountId', title: '现金账户ID', width: 130, align: 'center',hide:true}
                , {field: 'blankName', title: '银行名称', width: 130, align: 'center',hide:true}
                , {field: 'flag', title: '交易标识,1流入，-1流出', width: 130, align: 'center',hide:true}
                , {field: 'commission', title: '佣金费用（券商）', width: 130, align: 'center',hide:true}
                , {field: 'transfer', title: '过户费（交易所）', width: 130, align: 'center',hide:true}
                , {field: 'brokerage', title: '经手费（交易所）', width: 130, align: 'center',hide:true}
                , {field: 'stamp', title: '印花税（上交国家的税）', width: 130, align: 'center',hide:true}
                , {field: 'management', title: '征管费（上交国家的税）', width: 130, align: 'center',hide:true}
                , {field: 'security', title: '证券利息', width: 130, align: 'center',hide:true}
                ,{field: 'operation', title: '操作' , width: 150, align:'center',toolbar:'#barDemo'}
            ]
        ]
    });
});