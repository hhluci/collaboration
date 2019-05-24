$(function () {
    initTreeTable();
});

function initTreeTable() {
    var $menuTableForm = $(".menu-table-form");
    var setting = {
        id: 'id',
        code: 'id',
        url: ctx + 'syspermission/list',
        expandAll: true,
        expandColumn: "2",
        ajaxParams: {
            name: $menuTableForm.find("input[name='name']").val().trim(),
            type: $menuTableForm.find("select[name='type']").val(),
            state: $menuTableForm.find("select[name='state']").val()
        },
        columns: [
            {
                field: 'selectItem',
                checkbox: true
            },
            {
                title: '编号',
                field: 'id',
                width: '50px'
            },
            {
                title: '名称',
                field: 'name'
            },
            {
                title: '地址',
                field: 'url',
                formatter: function (item, index) {
                    return item.url === 'null' ? '' : item.url;
                }
            },
            {
                title: '权限标识',
                field: 'permission',
                formatter: function (item, index) {
                    return item.permission === 'null' ? '' : item.permission;
                }
            },
            {
                title: '图标',
                field: 'icon',
                formatter: function (item, index) {
                    return '<i class="zmdi ' + item.icon + '"></i>';
                }

            },
            {
                field: 'state',
                title: '状态',
                formatter: function (item, row, index) {
                    if (item.state === '1') return '<span class="badge badge-success">有效</span>';
                    if (item.state === '0') return '<span class="badge badge-warning">锁定</span>';
                    if (item.state === '' || item.state === null) return '<span class="badge badge-warning">锁定</span>';
                }
            },
            {
                title: '类型',
                field: 'type',
                formatter: function (item, index) {
                    if (item.type === '0') return '<span class="badge badge-success">菜单</span>';
                    if (item.type === '1') return '<span class="badge badge-warning">按钮</span>';
                }

            }
        ]
    };

    $MB.initTreeTable('menuTable', setting);
}

function search() {
    initTreeTable();
}

function refresh() {
    $(".menu-table-form")[0].reset();
    initTreeTable();
    $MB.refreshJsTree("menuTree", createMenuTree());
}

function deleteMenus() {
    var ids = $("#menuTable").bootstrapTreeTable("getSelections");
    var ids_arr = "";
    if (!ids.length) {
        $MB.n_warning("请勾选需要删除的菜单或按钮！");
        return;
    }
    for (var i = 0; i < ids.length; i++) {
        ids_arr += ids[i].id;
        if (i !== (ids.length - 1)) ids_arr += ",";
    }
    $MB.confirm({
        text: "确定删除选中菜单或按钮？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'syspermission/delete', {"ids": ids_arr}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

// function exportMenuExcel() {
//     $.post(ctx + "menu/excel", $(".menu-table-form").serialize(), function (r) {
//         if (r.code === 0) {
//             window.location.href = "file/download?fileName=" + r.msg + "&delete=" + true;
//         } else {
//             $MB.n_warning(r.msg);
//         }
//     });
// }
//
// function exportMenuCsv() {
//     $.post(ctx + "menu/csv", $(".menu-table-form").serialize(), function (r) {
//         if (r.code === 0) {
//             window.location.href = "file/download?fileName=" + r.msg + "&delete=" + true;
//         } else {
//             $MB.n_warning(r.msg);
//         }
//     });
// }