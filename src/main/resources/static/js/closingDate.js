layui.use(['element', 'form', 'table', 'layer', 'laydate','laypage','upload'], function () {
    var layer = layui.layer;
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;
    var laydate = layui.laydate;
    var laypage = layui.laypage;

    //执行一个实例
    table.render({
        elem: '#userTable',
        url: '../ClosingDateController/selectClosingDate',
        title: '成交清算数据报表',
        page: true, //开启分页
        toolbar: '#toolbarDemo',
        height: 'full-50',
        cellMinWidth: 60,
        cols: [
            [
                {type: 'checkbox', field: 'left'}
                , {field: 'securitiesId', title: '证券代码', align: 'center'}
                , {field: 'securitiesName', title: '证券名称', align: 'center'}
                , {
                field: 'num', title: '交易数量', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'price', title: '交易金额', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'commission', title: '佣金费用', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'stamp', title: '印花税', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'brokerage', title: '经手费', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'transfer', title: '过户费', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'management', title: '征管费', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {
                field: 'security', title: '国债利息', align: 'center',
                templet: function (item) {
                    if (item.securitiesId == '流入合计') {
                        return '';
                    }
                    if (item.securitiesId == '流出合计') {
                        return '';
                    }
                    if (item.securitiesId == '清算合计') {
                        return '';
                    }
                }
            }
                , {field: 'flag', title: '交易标识', align: 'center', hide: true}
                , {field: 'securitiesType', title: '证券类型', align: 'center', hide: true}
                , {
                field: 'netReceipts', title: '实际清算金额', align: 'center',
                templet: function (items) {
                    if (items.netReceipts != null) {
                        if (items.flag == -1) {
                            return "<span style='color: red'>" + items.netReceipts + "</span>"
                        }
                        if (items.securitiesId == '流出合计') {
                            return "<span style='color: red'>" + items.netReceipts + "</span>"
                        }
                        if (items.netReceipts < 0) {
                            return "<span style='color: red'>" + items.netReceipts + "</span>"
                        }
                        return items.netReceipts
                    } else {
                        return 0;
                    }
                }
            }
                , {
                field: 'transactionDataMode', title: '业务类型', align: 'center',
                templet: function (item) {
                    if (item.transactionDataMode == 1 && item.securitiesType == 1) {
                        return '买入债券'
                    } else if (item.transactionDataMode == 2 && item.securitiesType == 1) {
                        return '卖出债券'
                    } else if (item.transactionDataMode == 3) {
                        return '分红'
                    } else if (item.transactionDataMode == 4) {
                        return '送股'
                    }
                    if (item.transactionDataMode == 0) {
                        return ''
                    }
                    if (item.transactionDataMode == 1 && item.securitiesType == 2) {
                        return '买入股票'
                    } else if (item.transactionDataMode == 2 && item.securitiesType == 2) {
                        return '卖出股票'
                    }
                }
            }
            ]
        ]

    });

    laydate.render({
        elem: '#date'
    });

    table.on('toolbar(userTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (objs.event) {
            case 'search':
                var a = $("#date").val();
                table.reload('userTable', {
                    page: {
                        curr: 1
                    },
                    url: '',
                    where: {
                        dateTime: $('#date').val(),
                    }
                });
                $("#date").remove();
                $("#date2").before('<input type="text" name="date" id="date" style="width: 190px;"  lay-verify="date"  autocomplete="off" class="layui-input">');
                laydate.render({
                    elem: '#date', //指定元素
                });
                break;
        }
    })
});