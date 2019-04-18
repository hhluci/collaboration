package nuc.entity;

public class SysPermission {
    private Integer roleId;

    private Integer moudelId;

    private Integer crudOperation;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMoudelId() {
        return moudelId;
    }

    public void setMoudelId(Integer moudelId) {
        this.moudelId = moudelId;
    }

    public Integer getCrudOperation() {
        return crudOperation;
    }

    public void setCrudOperation(Integer crudOperation) {
        this.crudOperation = crudOperation;
    }
}