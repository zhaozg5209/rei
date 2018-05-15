/**
 * 初始化博客管理详情对话框
 */
var CenterInfoDlg = {
    centerInfoData : {}
};

/**
 * 清除数据
 */
CenterInfoDlg.clearData = function() {
    this.centerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CenterInfoDlg.set = function(key, val) {
    this.centerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CenterInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CenterInfoDlg.close = function() {
    parent.layer.close(window.parent.Center.layerIndex);
}

/**
 * 收集数据
 */
CenterInfoDlg.collectData = function() {
    this
    .set('id')
    .set('motto')
    .set('birthday')
    .set('workYears')
    .set('address')
    .set('company')
    .set('industry')
    .set('simpleDesc')
    .set('detail');
}

/**
 * 提交添加
 */
CenterInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/center/add", function(data){
        Feng.success("添加成功!");
        window.parent.Center.table.refresh();
        CenterInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.centerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CenterInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/center/update", function(data){
        Feng.success("修改成功!");
        window.parent.Center.table.refresh();
        CenterInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.centerInfoData);
    ajax.start();
}

$(function() {

});
