/**
 * 初始化博客类别详情对话框
 */
var CategoryInfoDlg = {
    categoryInfoData : {}
};

/**
 * 清除数据
 */
CategoryInfoDlg.clearData = function() {
    this.categoryInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CategoryInfoDlg.set = function(key, val) {
    this.categoryInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CategoryInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CategoryInfoDlg.close = function() {
    parent.layer.close(window.parent.Category.layerIndex);
}

/**
 * 收集数据
 */
CategoryInfoDlg.collectData = function() {
    this
    .set('id')
    .set('userId')
    .set('name')
    .set('onShow')
    .set('updateTime')
    .set('createTime');
}

/**
 * 提交添加
 */
CategoryInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/category/add", function(data){
        Feng.success("添加成功!");
        window.parent.Category.table.refresh();
        CategoryInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.categoryInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CategoryInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/category/update", function(data){
        Feng.success("修改成功!");
        window.parent.Category.table.refresh();
        CategoryInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.categoryInfoData);
    ajax.start();
}

$(function() {

});
