package com.bpzj.task4.domain;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceIsNull() {
            addCriterion("brief_introduce is null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceIsNotNull() {
            addCriterion("brief_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceEqualTo(String value) {
            addCriterion("brief_introduce =", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceNotEqualTo(String value) {
            addCriterion("brief_introduce <>", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceGreaterThan(String value) {
            addCriterion("brief_introduce >", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("brief_introduce >=", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceLessThan(String value) {
            addCriterion("brief_introduce <", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceLessThanOrEqualTo(String value) {
            addCriterion("brief_introduce <=", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceLike(String value) {
            addCriterion("brief_introduce like", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceNotLike(String value) {
            addCriterion("brief_introduce not like", value, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceIn(List<String> values) {
            addCriterion("brief_introduce in", values, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceNotIn(List<String> values) {
            addCriterion("brief_introduce not in", values, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceBetween(String value1, String value2) {
            addCriterion("brief_introduce between", value1, value2, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andBriefIntroduceNotBetween(String value1, String value2) {
            addCriterion("brief_introduce not between", value1, value2, "briefIntroduce");
            return (Criteria) this;
        }

        public Criteria andIsStudyingIsNull() {
            addCriterion("is_studying is null");
            return (Criteria) this;
        }

        public Criteria andIsStudyingIsNotNull() {
            addCriterion("is_studying is not null");
            return (Criteria) this;
        }

        public Criteria andIsStudyingEqualTo(Integer value) {
            addCriterion("is_studying =", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingNotEqualTo(Integer value) {
            addCriterion("is_studying <>", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingGreaterThan(Integer value) {
            addCriterion("is_studying >", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_studying >=", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingLessThan(Integer value) {
            addCriterion("is_studying <", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingLessThanOrEqualTo(Integer value) {
            addCriterion("is_studying <=", value, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingIn(List<Integer> values) {
            addCriterion("is_studying in", values, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingNotIn(List<Integer> values) {
            addCriterion("is_studying not in", values, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingBetween(Integer value1, Integer value2) {
            addCriterion("is_studying between", value1, value2, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsStudyingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_studying not between", value1, value2, "isStudying");
            return (Criteria) this;
        }

        public Criteria andIsExcellentIsNull() {
            addCriterion("is_excellent is null");
            return (Criteria) this;
        }

        public Criteria andIsExcellentIsNotNull() {
            addCriterion("is_excellent is not null");
            return (Criteria) this;
        }

        public Criteria andIsExcellentEqualTo(Integer value) {
            addCriterion("is_excellent =", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentNotEqualTo(Integer value) {
            addCriterion("is_excellent <>", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentGreaterThan(Integer value) {
            addCriterion("is_excellent >", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_excellent >=", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentLessThan(Integer value) {
            addCriterion("is_excellent <", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentLessThanOrEqualTo(Integer value) {
            addCriterion("is_excellent <=", value, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentIn(List<Integer> values) {
            addCriterion("is_excellent in", values, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentNotIn(List<Integer> values) {
            addCriterion("is_excellent not in", values, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentBetween(Integer value1, Integer value2) {
            addCriterion("is_excellent between", value1, value2, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andIsExcellentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_excellent not between", value1, value2, "isExcellent");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Long value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Long value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Long value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Long value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Long value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Long> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Long> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Long value1, Long value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Long value1, Long value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Long value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Long value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Long value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Long value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Long value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Long> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Long> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Long value1, Long value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Long value1, Long value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
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