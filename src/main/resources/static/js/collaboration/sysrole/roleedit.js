function updateRole() {
    var selected = $("#roleTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的角色！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个角色！');
        return;
    }
    var roleId = selected[0].id;
    $.post(ctx + "sysrole/getRole", {"roleId": roleId}, function (r) {
        if (r.code === 0) {
            var $form = $('#role-add');
            var $menuTree = $('#menuTree');
            $form.modal();
            var role = r.msg;
            $("#role-add-modal-title").html('修改角色');
            $form.find("input[name='role']").val(role.role);
            $form.find("input[name='oldRoleName']").val(role.role);
            $form.find("input[name='id']").val(role.id);
            $form.find("input[name='description']").val(role.description);

            var $status = $form.find("input[name='state']");
            if (role.state === '1') {
                $status.prop("checked", true);
                $status.parent().next().html('可用');
            } else {
                $status.prop("checked", false);
                $status.parent().next().html('禁用');
            }


            var menuArr = [];
            for (var i = 0; i < role.permissionIds.length; i++) {
                menuArr.push(role.permissionIds[i]);
            }
            console.log(menuArr);

            // 获取树
            var menuTrees = $('#menuTree').jstree(true);
            // 清空级联关系
            var oldCascade = menuTrees.settings.checkbox.cascade;
            menuTrees.settings.checkbox.cascade = '';
            //选中查询到的数据
            $menuTree.jstree('select_node', menuArr, true);
            // 重置级联关系
            setTimeout(function () {
                menuTrees.settings.checkbox.cascade = oldCascade;
            }, 500);

            $menuTree.jstree().close_all();
            $("#role-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}