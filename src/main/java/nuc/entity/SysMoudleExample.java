package nuc.entity;

import java.util.ArrayList;
import java.util.List;

public class SysMoudleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMoudleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Integer value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Integer value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Integer value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Integer value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Integer> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Integer> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Integer value1, Integer value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("module_name =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("module_name <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("module_name >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("module_name >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("module_name <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("module_name <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("module_name like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("module_name not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("module_name in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("module_name not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("module_name between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("module_name not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleParentIsNull() {
            addCriterion("module_parent is null");
            return (Criteria) this;
        }

        public Criteria andModuleParentIsNotNull() {
            addCriterion("module_parent is not null");
            return (Criteria) this;
        }

        public Criteria andModuleParentEqualTo(Integer value) {
            addCriterion("module_parent =", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentNotEqualTo(Integer value) {
            addCriterion("module_parent <>", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentGreaterThan(Integer value) {
            addCriterion("module_parent >", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_parent >=", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentLessThan(Integer value) {
            addCriterion("module_parent <", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentLessThanOrEqualTo(Integer value) {
            addCriterion("module_parent <=", value, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentIn(List<Integer> values) {
            addCriterion("module_parent in", values, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentNotIn(List<Integer> values) {
            addCriterion("module_parent not in", values, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentBetween(Integer value1, Integer value2) {
            addCriterion("module_parent between", value1, value2, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleParentNotBetween(Integer value1, Integer value2) {
            addCriterion("module_parent not between", value1, value2, "moduleParent");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyIsNull() {
            addCriterion("module_hierarchy is null");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyIsNotNull() {
            addCriterion("module_hierarchy is not null");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyEqualTo(String value) {
            addCriterion("module_hierarchy =", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyNotEqualTo(String value) {
            addCriterion("module_hierarchy <>", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyGreaterThan(String value) {
            addCriterion("module_hierarchy >", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyGreaterThanOrEqualTo(String value) {
            addCriterion("module_hierarchy >=", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyLessThan(String value) {
            addCriterion("module_hierarchy <", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyLessThanOrEqualTo(String value) {
            addCriterion("module_hierarchy <=", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyLike(String value) {
            addCriterion("module_hierarchy like", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyNotLike(String value) {
            addCriterion("module_hierarchy not like", value, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyIn(List<String> values) {
            addCriterion("module_hierarchy in", values, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyNotIn(List<String> values) {
            addCriterion("module_hierarchy not in", values, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyBetween(String value1, String value2) {
            addCriterion("module_hierarchy between", value1, value2, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleHierarchyNotBetween(String value1, String value2) {
            addCriterion("module_hierarchy not between", value1, value2, "moduleHierarchy");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIsNull() {
            addCriterion("module_level is null");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIsNotNull() {
            addCriterion("module_level is not null");
            return (Criteria) this;
        }

        public Criteria andModuleLevelEqualTo(Integer value) {
            addCriterion("module_level =", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotEqualTo(Integer value) {
            addCriterion("module_level <>", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelGreaterThan(Integer value) {
            addCriterion("module_level >", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_level >=", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelLessThan(Integer value) {
            addCriterion("module_level <", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelLessThanOrEqualTo(Integer value) {
            addCriterion("module_level <=", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIn(List<Integer> values) {
            addCriterion("module_level in", values, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotIn(List<Integer> values) {
            addCriterion("module_level not in", values, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelBetween(Integer value1, Integer value2) {
            addCriterion("module_level between", value1, value2, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("module_level not between", value1, value2, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andIconNameIsNull() {
            addCriterion("icon_name is null");
            return (Criteria) this;
        }

        public Criteria andIconNameIsNotNull() {
            addCriterion("icon_name is not null");
            return (Criteria) this;
        }

        public Criteria andIconNameEqualTo(String value) {
            addCriterion("icon_name =", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameNotEqualTo(String value) {
            addCriterion("icon_name <>", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameGreaterThan(String value) {
            addCriterion("icon_name >", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameGreaterThanOrEqualTo(String value) {
            addCriterion("icon_name >=", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameLessThan(String value) {
            addCriterion("icon_name <", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameLessThanOrEqualTo(String value) {
            addCriterion("icon_name <=", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameLike(String value) {
            addCriterion("icon_name like", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameNotLike(String value) {
            addCriterion("icon_name not like", value, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameIn(List<String> values) {
            addCriterion("icon_name in", values, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameNotIn(List<String> values) {
            addCriterion("icon_name not in", values, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameBetween(String value1, String value2) {
            addCriterion("icon_name between", value1, value2, "iconName");
            return (Criteria) this;
        }

        public Criteria andIconNameNotBetween(String value1, String value2) {
            addCriterion("icon_name not between", value1, value2, "iconName");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNull() {
            addCriterion("module_url is null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNotNull() {
            addCriterion("module_url is not null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlEqualTo(String value) {
            addCriterion("module_url =", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotEqualTo(String value) {
            addCriterion("module_url <>", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThan(String value) {
            addCriterion("module_url >", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("module_url >=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThan(String value) {
            addCriterion("module_url <", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThanOrEqualTo(String value) {
            addCriterion("module_url <=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLike(String value) {
            addCriterion("module_url like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotLike(String value) {
            addCriterion("module_url not like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIn(List<String> values) {
            addCriterion("module_url in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotIn(List<String> values) {
            addCriterion("module_url not in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlBetween(String value1, String value2) {
            addCriterion("module_url between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotBetween(String value1, String value2) {
            addCriterion("module_url not between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}