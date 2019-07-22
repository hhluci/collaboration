$(function () {
    var $workflowTableForm = $(".workflow-table-form");
    var settings = {
        url: ctx + "workflow/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                key: $workflowTableForm.find("input[name='key']").val().trim(),
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: '流程定义ID',
        }, {
            field: 'name',
            title: '流程定义名称'
        }, {
            field: 'key',
            title: '流程定义Key'
        }, {
            field: 'version',
            title: '流程定义版本'
        }, {
            field: 'resourceName',
            title: '资源名称bpmn文件'
        }, {
            field: 'diagramResourceName',
            title: '资源名称png文件'
        }, {
            field: 'deploymentId',
            title: '部署对象deploymentId'
        }
        ]
    };
    $MB.initTable('workflowTable', settings);
});

function search() {
    $MB.refreshTable('workflowTable');
}

function refresh() {
    $(".workflow-table-form")[0].reset();
    $MB.refreshTable('workflowTable');
}

function deleteworkflows() {
    var selected = $("#workflowTable").bootstrapTable('getSelections');

    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的工作流程！');
        return;
    }
    var allkey = "";
    for (var i = 0; i < selected_length; i++) {
        allkey += selected[i].key;
        if (i !== (selected_length - 1)) allkey += ",";
    }

    $MB.confirm({
        text: "确定删除此key值的所有流程定义吗？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'workflow/delete', {"allkey": allkey}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function addworkflows() {
    var workflow = $('#i-file')[0].files[0];
    var formData = new FormData();
    formData.append("workflow", $('#i-file')[0].files[0]);
    $.ajax({
        url: ctx + 'workflow/actInsert',
        dataType: 'json',
        type: 'POST',
        async: false,
        data: formData,
        processData: false, // 使数据不做处理
        contentType: false, // 不要设置Content-Type请求头
        success: function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }

        }
    });
}

function startworkflow() {

    var selected = $("#workflowTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要启动的工作流程！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能启动一个工作流程！');
        return;
    }
    var key = selected[0].key;

    $.post(ctx + "workflow/start", {"key": key}, function (r) {
        if (r.code === 0) {
            $MB.n_success(r.msg)
        } else {
            $MB.n_danger(r.msg);
        }
    });


}

