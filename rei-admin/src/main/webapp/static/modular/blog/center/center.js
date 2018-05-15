/**
 * 博客管理管理初始化
 */
var Center = {
    id: "CenterTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Center.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '座右铭', field: 'motto', visible: true, align: 'center', valign: 'middle'},
            {title: '出生年月', field: 'birthday', visible: true, align: 'center', valign: 'middle'},
            {title: '工作年限', field: 'workYears', visible: true, align: 'center', valign: 'middle'},
            {title: '居住地', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '公司', field: 'company', visible: true, align: 'center', valign: 'middle'},
            {title: '行业', field: 'industry', visible: true, align: 'center', valign: 'middle'},
            {title: '职业简介', field: 'simpleDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '详细介绍', field: 'detail', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Center.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Center.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加博客管理
 */
Center.openAddCenter = function () {
    var index = layer.open({
        type: 2,
        title: '添加博客管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/center/center_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看博客管理详情
 */
Center.openCenterDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '博客管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/center/center_update/' + Center.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除博客管理
 */
Center.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/center/delete", function (data) {
            Feng.success("删除成功!");
            Center.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("centerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询博客管理列表
 */
Center.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Center.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Center.initColumn();
    var table = new BSTable(Center.id, "/center/list", defaultColunms);
    table.setPaginationType("client");
    Center.table = table.init();
});
