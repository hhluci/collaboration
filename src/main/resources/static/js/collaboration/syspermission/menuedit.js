function updateMenu() {
    var selected = $("#menuTable").bootstrapTreeTable("getSelections");
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的菜单或按钮！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个菜单或按钮！');
        return;
    }
    var menuId = selected[0].id;
    $.post(ctx + "syspermission/getMenu", {"menuId": menuId}, function (r) {
        if (r.code === 0) {
            var $form = $('#menu-add');
            var $menuTree = $('#menuTree');
            $form.modal();
            var menu = r.msg;
            $("#menu-add-modal-title").html('修改菜单/按钮');
            $("input:radio[value='" + menu.type + "']").trigger("click");
            $form.find("input[name='name']").val(menu.name);
            $form.find("input[name='oldMenuName']").val(menu.name);
            $form.find("input[name='id']").val(menu.id);
            $form.find("input[name='icon']").val(menu.icon);
            $form.find("input[name='permission']").val(menu.permission == null ? "" : menu.permission);
            $form.find("input[name='url']").val(menu.url == null ? "" : menu.url);


            //
            // $('#menu-perms-list').find(".autocomplete-input").val(menu.permission == null ? "" : menu.permission);
            // $('#menu-url-list').find(".autocomplete-input").val(menu.url == null ? "" : menu.url);
            $menuTree.jstree('select_node', menu.parentId, true);

            $menuTree.jstree('disable_node', menu.id);

            var $status = $form.find("input[name='state']");
            if (menu.state === '1') {
                $status.prop("checked", true);
                $status.parent().next().html('可用');
            } else {
                $status.prop("checked", false);
                $status.parent().next().html('禁用');
            }
            $("#menu-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}