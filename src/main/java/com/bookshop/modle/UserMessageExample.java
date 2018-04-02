package com.bookshop.modle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserMessageExample() {
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

        public Criteria andUAccountIsNull() {
            addCriterion("u_account is null");
            return (Criteria) this;
        }

        public Criteria andUAccountIsNotNull() {
            addCriterion("u_account is not null");
            return (Criteria) this;
        }

        public Criteria andUAccountEqualTo(String value) {
            addCriterion("u_account =", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotEqualTo(String value) {
            addCriterion("u_account <>", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThan(String value) {
            addCriterion("u_account >", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThanOrEqualTo(String value) {
            addCriterion("u_account >=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThan(String value) {
            addCriterion("u_account <", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThanOrEqualTo(String value) {
            addCriterion("u_account <=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLike(String value) {
            addCriterion("u_account like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotLike(String value) {
            addCriterion("u_account not like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountIn(List<String> values) {
            addCriterion("u_account in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotIn(List<String> values) {
            addCriterion("u_account not in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountBetween(String value1, String value2) {
            addCriterion("u_account between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotBetween(String value1, String value2) {
            addCriterion("u_account not between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUMessageIsNull() {
            addCriterion("u_message is null");
            return (Criteria) this;
        }

        public Criteria andUMessageIsNotNull() {
            addCriterion("u_message is not null");
            return (Criteria) this;
        }

        public Criteria andUMessageEqualTo(String value) {
            addCriterion("u_message =", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageNotEqualTo(String value) {
            addCriterion("u_message <>", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageGreaterThan(String value) {
            addCriterion("u_message >", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageGreaterThanOrEqualTo(String value) {
            addCriterion("u_message >=", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageLessThan(String value) {
            addCriterion("u_message <", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageLessThanOrEqualTo(String value) {
            addCriterion("u_message <=", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageLike(String value) {
            addCriterion("u_message like", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageNotLike(String value) {
            addCriterion("u_message not like", value, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageIn(List<String> values) {
            addCriterion("u_message in", values, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageNotIn(List<String> values) {
            addCriterion("u_message not in", values, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageBetween(String value1, String value2) {
            addCriterion("u_message between", value1, value2, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUMessageNotBetween(String value1, String value2) {
            addCriterion("u_message not between", value1, value2, "uMessage");
            return (Criteria) this;
        }

        public Criteria andUAddTimeIsNull() {
            addCriterion("u_add_time is null");
            return (Criteria) this;
        }

        public Criteria andUAddTimeIsNotNull() {
            addCriterion("u_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andUAddTimeEqualTo(Date value) {
            addCriterion("u_add_time =", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeNotEqualTo(Date value) {
            addCriterion("u_add_time <>", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeGreaterThan(Date value) {
            addCriterion("u_add_time >", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("u_add_time >=", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeLessThan(Date value) {
            addCriterion("u_add_time <", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("u_add_time <=", value, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeIn(List<Date> values) {
            addCriterion("u_add_time in", values, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeNotIn(List<Date> values) {
            addCriterion("u_add_time not in", values, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeBetween(Date value1, Date value2) {
            addCriterion("u_add_time between", value1, value2, "uAddTime");
            return (Criteria) this;
        }

        public Criteria andUAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("u_add_time not between", value1, value2, "uAddTime");
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