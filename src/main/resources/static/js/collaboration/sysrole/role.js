$(function () {
    var settings = {
        url: ctx + "sysrole/listbyrole",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                roleName: $(".role-table-form").find("input[name='roleName']").val().trim(),
                state: $(".role-table-form").find("select[name='state']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: 'ID'
        }, {
            field: 'role',
            title: '角色'
        }, {
            field: 'description',
            title: '角色描述'
        }, {
            field: 'state',
            title: '状态',
            formatter: function (value, row, index) {
                if (value == '1') return '<span class="badge badge-success">有效</span>';
                if (value == '0') return '<span class="badge badge-warning">锁定</span>';
            }
        }
        ]
    };

    $MB.initTable('roleTable', settings);
});

function search() {
    $MB.refreshTable('roleTable');
}

function refresh() {
    $(".role-table-form")[0].reset();
    search();
}

function deleteRoles() {
    var selected = $("#roleTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的角色！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].id;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "删除选中角色将导致该角色对应账户失去相应的权限，确定删除？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'sysrole/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

// function exportRoleExcel() {
//     $.post(ctx + "role/excel", $(".role-table-form").serialize(), function (r) {
//         if (r.code === 0) {
//             window.location.href = "file/download?fileName=" + r.msg + "&delete=" + true;
//         } else {
//             $MB.n_warning(r.msg);
//         }
//     });
// }
//
// function exportRoleCsv() {
//     $.post(ctx + "role/csv", $(".role-table-form").serialize(), function (r) {
//         if (r.code === 0) {
//             window.location.href = "file/download?fileName=" + r.msg + "&delete=" + true;
//         } else {
//             $MB.n_warning(r.msg);
//         }
//     });
// }
