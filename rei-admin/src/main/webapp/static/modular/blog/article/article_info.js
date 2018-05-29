/**
 * 初始化文章管理详情对话框
 */
var ArticleInfoDlg = {
    articleInfoData : {},
    editor:null
};

/**
 * 清除数据
 */
ArticleInfoDlg.clearData = function() {
    this.articleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ArticleInfoDlg.set = function(key, val) {
    this.articleInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ArticleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ArticleInfoDlg.close = function() {
    parent.layer.close(window.parent.Article.layerIndex);
}

/**
 * 收集数据
 */
ArticleInfoDlg.collectData = function() {
    this.articleInfoData['detail'] = ArticleInfoDlg.editor.txt.html();
    this
    .set('categoryId')
    .set('author')
    .set('title')
    .set('copyFrom')
    .set('simpleDesc')
    .set('bannerUrl')
    .set('keywords')
    .set('onShow')
    .set('createStatus');
}

/**
 * 提交添加
 */
ArticleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    validatorFun();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/article/add", function(data){
        Feng.success("添加成功!");
        window.parent.Article.table.refresh();
        ArticleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.articleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ArticleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    validatorFun();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/article/update", function(data){
        Feng.success("修改成功!");
        window.parent.Article.table.refresh();
        ArticleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.articleInfoData);
    ajax.start();
}

$(function () {
    Feng.initValidator("articleInfoForm", ArticleInfoDlg.validateFields);

    //初始化编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
    editor.txt.html($("#detailVal").val());
    ArticleInfoDlg.editor = editor;
});


function validatorFun(){
    if($("#title").val() == ""){
        Feng.error("标题不能为空");
        return;
    }
    if($("#author").val() == ""){
        Feng.error("作者不能为空");
        return;
    }
    if($("#simpleDesc").val() == ""){
        Feng.error("描述不能为空");
        return;
    }
    if($("#bannerUrl").val() == ""){
        Feng.error("图片链接不能为空");
        return;
    }
    if($("#categoryId").val() == ""){
        Feng.error("文章类别不能为空");
        return;
    }
    if($("#keywords").val() == ""){
        Feng.error("标签不能为空");
        return;
    }
    if($("#onShow").val() == ""){
        Feng.error("请选择展示规则");
        return;
    }
    if($("#createStatus").val() == ""){
        Feng.error("请选择原创或转载");
        return;
    }
}
