package nuc.entity;

public class SysMoudle {
    private Integer moduleId;

    private String moduleName;

    private Integer moduleParent;

    private String moduleHierarchy;

    private Integer moduleLevel;

    private String iconName;

    private String moduleUrl;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getModuleParent() {
        return moduleParent;
    }

    public void setModuleParent(Integer moduleParent) {
        this.moduleParent = moduleParent;
    }

    public String getModuleHierarchy() {
        return moduleHierarchy;
    }

    public void setModuleHierarchy(String moduleHierarchy) {
        this.moduleHierarchy = moduleHierarchy == null ? null : moduleHierarchy.trim();
    }

    public Integer getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(Integer moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl == null ? null : moduleUrl.trim();
    }
}