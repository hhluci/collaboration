var validator;
var $userAddForm = $("#user-add-form");
var $rolesSelect = $userAddForm.find("select[name='rolesSelect']");
var $roles = $userAddForm.find("input[name='roles']");

$(function () {
    validateRule();
    initRole();

    $("input[name='state']").change(function () {
        var checked = $(this).is(":checked");
        var $status_label = $("#state");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

    $("#user-add .btn-save").click(function () {
        var name = $(this).attr("name");
        var validator = $userAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "sysuser/add", $userAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("userTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "sysuser/update", $userAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("userTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#user-add .btn-close").click(function () {
        closeModal();
    });

});

function closeModal() {
    $("#user-add-button").attr("name", "save");
    validator.resetForm();
    $rolesSelect.multipleSelect('setSelects', []);
    $rolesSelect.multipleSelect("refresh");
    $userAddForm.find("input[name='username']").removeAttr("readonly");
    $userAddForm.find(".user_password").show();
    $userAddForm.find("input[name='state']").prop("checked", true);
    $("#user-add-modal-title").html('新增用户');
    $("#state").html('可用');
    // $MB.resetJsTree("deptTree");
    $MB.closeAndRestModal("user-add");

}


function validateRule() {
    var name = $("#user-add .btn-save").attr("name");

    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";

    validator = $userAddForm.validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 10,
                remote: {
                    url: "sysuser/checkUserName",
                    type: "get",
                    dataType: "json",
                    data: {
                        username: function () {
                            return $("input[name='username']").val().trim();
                        },
                        oldusername: function () {
                            return $("input[name='oldusername']").val().trim();
                        }

                    }
                }
            },
            name: {
                required: true,
                minlength: 3,
                maxlength: 10,
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 10,
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":checkbox") || element.is(":radio")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {
            username: {
                required: icon + "请输入用户名",
                minlength: icon + "用户名长度3到10个字符",
                remote: icon + "用户名已经存在"
            },
            name: {
                required: icon + "请输入昵称",
                minlength: icon + "昵称长度3到10个字符",
            },
            password: {
                required: icon + "请输入密码",
                minlength: icon + "昵称长度6到10个字符",
            },
        }
    });


}

function initRole() {
    $.post(ctx + "sysrole/list", {}, function (r) {
        var data = r.rows;
        var option = "";
        for (var i = 0; i < data.length; i++) {
            option += "<option value='" + data[i].id + "'>" + data[i].role + "</option>"
        }
        $rolesSelect.html("").append(option);
        var options = {
            selectAllText: '所有角色',
            allSelected: '所有角色',
            width: '100%',
            onClose: function () {
                $roles.val($rolesSelect.val());

                validator.element("input[name='roles']");
            }
        };

        $rolesSelect.multipleSelect(options);
    });
}
