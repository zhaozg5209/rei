/**
 * 初始化通知详情对话框
 */
var ArticleInfoDlg = {
    articleInfoData: {},
    editor: null,
    validateFields: {
        title: {
            validators: {
                notEmpty: {
                    message: '标题不能为空'
                }
            }
        },
        author: {
            validators: {
                notEmpty: {
                    message: '作者不能为空'
                }
            }
        },
        simpleDesc: {
            validators: {
                notEmpty: {
                    message: '描述不能为空'
                }
            }
        },
        bannerUrl: {
            validators: {
                notEmpty: {
                    message: 'banner链接不能为空'
                }
            }
        },
        keywords: {
            validators: {
                notEmpty: {
                    message: '关键字不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
ArticleInfoDlg.clearData = function () {
    this.articleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ArticleInfoDlg.set = function (key, val) {
    this.articleInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ArticleInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ArticleInfoDlg.close = function () {
    parent.layer.close(window.parent.Article.layerIndex);
}

/**
 * 收集数据
 */
ArticleInfoDlg.collectData = function () {
    this.articleInfoData['detail'] = ArticleInfoDlg.editor.txt.html();
    this.set('categoryId').set('author').set('title').set('copyFrom').set('simpleDesc').set('bannerUrl').set('keywords').set('onShow').set('createStatus');
}

/**
 * 验证数据是否为空
 */
ArticleInfoDlg.validate = function () {
    $('#articleInfoForm').data("bootstrapValidator").resetForm();
    $('#articleInfoForm').bootstrapValidator('validate');
    return $("#articleInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加
 */
ArticleInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }
    if($("#createStatus").val() == ""){
        Feng.error("请选择是否原创");
        return;
    }
    if($("#onShow").val() == ""){
        Feng.error("请选择展示规则");
        return;
    }
    if(!$("#keywords").val().contains(",")){
        Feng.error("请把关键字拿英文逗号隔开");
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/article/add", function (data) {
        Feng.success("添加成功!");
        window.parent.Article.table.refresh();
        ArticleInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.articleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ArticleInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if($("#createStatus").val() == ""){
        Feng.error("请选择是否原创");
        return;
    }
    if($("#onShow").val() == ""){
        Feng.error("请选择展示规则");
        return;
    }
    if(!$("#keywords").val().contains(",")){
        Feng.error("请把关键字拿英文逗号隔开");
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/article/update", function (data) {
        Feng.success("修改成功!");
        window.parent.Article.table.refresh();
        ArticleInfoDlg.close();
    }, function (data) {
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
    editor.txt.html($("#contentVal").val());
    ArticleInfoDlg.editor = editor;
});
