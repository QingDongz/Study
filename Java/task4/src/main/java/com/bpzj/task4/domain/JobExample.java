package com.bpzj.task4.domain;

import java.util.ArrayList;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierIsNull() {
            addCriterion("entry_barrier is null");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierIsNotNull() {
            addCriterion("entry_barrier is not null");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierEqualTo(Integer value) {
            addCriterion("entry_barrier =", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierNotEqualTo(Integer value) {
            addCriterion("entry_barrier <>", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierGreaterThan(Integer value) {
            addCriterion("entry_barrier >", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry_barrier >=", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierLessThan(Integer value) {
            addCriterion("entry_barrier <", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierLessThanOrEqualTo(Integer value) {
            addCriterion("entry_barrier <=", value, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierIn(List<Integer> values) {
            addCriterion("entry_barrier in", values, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierNotIn(List<Integer> values) {
            addCriterion("entry_barrier not in", values, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierBetween(Integer value1, Integer value2) {
            addCriterion("entry_barrier between", value1, value2, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andEntryBarrierNotBetween(Integer value1, Integer value2) {
            addCriterion("entry_barrier not between", value1, value2, "entryBarrier");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelIsNull() {
            addCriterion("difficult_level is null");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelIsNotNull() {
            addCriterion("difficult_level is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelEqualTo(Integer value) {
            addCriterion("difficult_level =", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelNotEqualTo(Integer value) {
            addCriterion("difficult_level <>", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelGreaterThan(Integer value) {
            addCriterion("difficult_level >", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficult_level >=", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelLessThan(Integer value) {
            addCriterion("difficult_level <", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelLessThanOrEqualTo(Integer value) {
            addCriterion("difficult_level <=", value, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelIn(List<Integer> values) {
            addCriterion("difficult_level in", values, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelNotIn(List<Integer> values) {
            addCriterion("difficult_level not in", values, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelBetween(Integer value1, Integer value2) {
            addCriterion("difficult_level between", value1, value2, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andDifficultLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("difficult_level not between", value1, value2, "difficultLevel");
            return (Criteria) this;
        }

        public Criteria andGrowTimeIsNull() {
            addCriterion("grow_time is null");
            return (Criteria) this;
        }

        public Criteria andGrowTimeIsNotNull() {
            addCriterion("grow_time is not null");
            return (Criteria) this;
        }

        public Criteria andGrowTimeEqualTo(String value) {
            addCriterion("grow_time =", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeNotEqualTo(String value) {
            addCriterion("grow_time <>", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeGreaterThan(String value) {
            addCriterion("grow_time >", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeGreaterThanOrEqualTo(String value) {
            addCriterion("grow_time >=", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeLessThan(String value) {
            addCriterion("grow_time <", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeLessThanOrEqualTo(String value) {
            addCriterion("grow_time <=", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeLike(String value) {
            addCriterion("grow_time like", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeNotLike(String value) {
            addCriterion("grow_time not like", value, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeIn(List<String> values) {
            addCriterion("grow_time in", values, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeNotIn(List<String> values) {
            addCriterion("grow_time not in", values, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeBetween(String value1, String value2) {
            addCriterion("grow_time between", value1, value2, "growTime");
            return (Criteria) this;
        }

        public Criteria andGrowTimeNotBetween(String value1, String value2) {
            addCriterion("grow_time not between", value1, value2, "growTime");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumIsNull() {
            addCriterion("firm_required_num is null");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumIsNotNull() {
            addCriterion("firm_required_num is not null");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumEqualTo(Integer value) {
            addCriterion("firm_required_num =", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumNotEqualTo(Integer value) {
            addCriterion("firm_required_num <>", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumGreaterThan(Integer value) {
            addCriterion("firm_required_num >", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("firm_required_num >=", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumLessThan(Integer value) {
            addCriterion("firm_required_num <", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumLessThanOrEqualTo(Integer value) {
            addCriterion("firm_required_num <=", value, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumIn(List<Integer> values) {
            addCriterion("firm_required_num in", values, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumNotIn(List<Integer> values) {
            addCriterion("firm_required_num not in", values, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumBetween(Integer value1, Integer value2) {
            addCriterion("firm_required_num between", value1, value2, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andFirmRequiredNumNotBetween(Integer value1, Integer value2) {
            addCriterion("firm_required_num not between", value1, value2, "firmRequiredNum");
            return (Criteria) this;
        }

        public Criteria andSalary1IsNull() {
            addCriterion("salary1 is null");
            return (Criteria) this;
        }

        public Criteria andSalary1IsNotNull() {
            addCriterion("salary1 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary1EqualTo(String value) {
            addCriterion("salary1 =", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1NotEqualTo(String value) {
            addCriterion("salary1 <>", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1GreaterThan(String value) {
            addCriterion("salary1 >", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1GreaterThanOrEqualTo(String value) {
            addCriterion("salary1 >=", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1LessThan(String value) {
            addCriterion("salary1 <", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1LessThanOrEqualTo(String value) {
            addCriterion("salary1 <=", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1Like(String value) {
            addCriterion("salary1 like", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1NotLike(String value) {
            addCriterion("salary1 not like", value, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1In(List<String> values) {
            addCriterion("salary1 in", values, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1NotIn(List<String> values) {
            addCriterion("salary1 not in", values, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1Between(String value1, String value2) {
            addCriterion("salary1 between", value1, value2, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary1NotBetween(String value1, String value2) {
            addCriterion("salary1 not between", value1, value2, "salary1");
            return (Criteria) this;
        }

        public Criteria andSalary2IsNull() {
            addCriterion("salary2 is null");
            return (Criteria) this;
        }

        public Criteria andSalary2IsNotNull() {
            addCriterion("salary2 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary2EqualTo(String value) {
            addCriterion("salary2 =", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2NotEqualTo(String value) {
            addCriterion("salary2 <>", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2GreaterThan(String value) {
            addCriterion("salary2 >", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2GreaterThanOrEqualTo(String value) {
            addCriterion("salary2 >=", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2LessThan(String value) {
            addCriterion("salary2 <", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2LessThanOrEqualTo(String value) {
            addCriterion("salary2 <=", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2Like(String value) {
            addCriterion("salary2 like", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2NotLike(String value) {
            addCriterion("salary2 not like", value, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2In(List<String> values) {
            addCriterion("salary2 in", values, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2NotIn(List<String> values) {
            addCriterion("salary2 not in", values, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2Between(String value1, String value2) {
            addCriterion("salary2 between", value1, value2, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary2NotBetween(String value1, String value2) {
            addCriterion("salary2 not between", value1, value2, "salary2");
            return (Criteria) this;
        }

        public Criteria andSalary3IsNull() {
            addCriterion("salary3 is null");
            return (Criteria) this;
        }

        public Criteria andSalary3IsNotNull() {
            addCriterion("salary3 is not null");
            return (Criteria) this;
        }

        public Criteria andSalary3EqualTo(String value) {
            addCriterion("salary3 =", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3NotEqualTo(String value) {
            addCriterion("salary3 <>", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3GreaterThan(String value) {
            addCriterion("salary3 >", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3GreaterThanOrEqualTo(String value) {
            addCriterion("salary3 >=", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3LessThan(String value) {
            addCriterion("salary3 <", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3LessThanOrEqualTo(String value) {
            addCriterion("salary3 <=", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3Like(String value) {
            addCriterion("salary3 like", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3NotLike(String value) {
            addCriterion("salary3 not like", value, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3In(List<String> values) {
            addCriterion("salary3 in", values, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3NotIn(List<String> values) {
            addCriterion("salary3 not in", values, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3Between(String value1, String value2) {
            addCriterion("salary3 between", value1, value2, "salary3");
            return (Criteria) this;
        }

        public Criteria andSalary3NotBetween(String value1, String value2) {
            addCriterion("salary3 not between", value1, value2, "salary3");
            return (Criteria) this;
        }

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, "tips");
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