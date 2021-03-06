package cn.yiueil.meeting.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingRemindExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public MeetingRemindExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNull() {
            addCriterion("remindtime is null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIsNotNull() {
            addCriterion("remindtime is not null");
            return (Criteria) this;
        }

        public Criteria andRemindtimeEqualTo(Date value) {
            addCriterion("remindtime =", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotEqualTo(Date value) {
            addCriterion("remindtime <>", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThan(Date value) {
            addCriterion("remindtime >", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remindtime >=", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThan(Date value) {
            addCriterion("remindtime <", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeLessThanOrEqualTo(Date value) {
            addCriterion("remindtime <=", value, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeIn(List<Date> values) {
            addCriterion("remindtime in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotIn(List<Date> values) {
            addCriterion("remindtime not in", values, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeBetween(Date value1, Date value2) {
            addCriterion("remindtime between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andRemindtimeNotBetween(Date value1, Date value2) {
            addCriterion("remindtime not between", value1, value2, "remindtime");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Long value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Long value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Long value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Long value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Long value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Long value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Long> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Long> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Long value1, Long value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Long value1, Long value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andRemindtypeIsNull() {
            addCriterion("remindtype is null");
            return (Criteria) this;
        }

        public Criteria andRemindtypeIsNotNull() {
            addCriterion("remindtype is not null");
            return (Criteria) this;
        }

        public Criteria andRemindtypeEqualTo(Byte value) {
            addCriterion("remindtype =", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeNotEqualTo(Byte value) {
            addCriterion("remindtype <>", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeGreaterThan(Byte value) {
            addCriterion("remindtype >", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("remindtype >=", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeLessThan(Byte value) {
            addCriterion("remindtype <", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeLessThanOrEqualTo(Byte value) {
            addCriterion("remindtype <=", value, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeIn(List<Byte> values) {
            addCriterion("remindtype in", values, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeNotIn(List<Byte> values) {
            addCriterion("remindtype not in", values, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeBetween(Byte value1, Byte value2) {
            addCriterion("remindtype between", value1, value2, "remindtype");
            return (Criteria) this;
        }

        public Criteria andRemindtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("remindtype not between", value1, value2, "remindtype");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_meeting_remind
     *
     * @mbg.generated do_not_delete_during_merge Wed Mar 25 13:40:37 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_meeting_remind
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
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