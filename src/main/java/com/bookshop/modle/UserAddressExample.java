package com.bookshop.modle;

import java.util.ArrayList;
import java.util.List;

public class UserAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAddressExample() {
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

        public Criteria andUaddrIdIsNull() {
            addCriterion("uAddr_id is null");
            return (Criteria) this;
        }

        public Criteria andUaddrIdIsNotNull() {
            addCriterion("uAddr_id is not null");
            return (Criteria) this;
        }

        public Criteria andUaddrIdEqualTo(String value) {
            addCriterion("uAddr_id =", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdNotEqualTo(String value) {
            addCriterion("uAddr_id <>", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdGreaterThan(String value) {
            addCriterion("uAddr_id >", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdGreaterThanOrEqualTo(String value) {
            addCriterion("uAddr_id >=", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdLessThan(String value) {
            addCriterion("uAddr_id <", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdLessThanOrEqualTo(String value) {
            addCriterion("uAddr_id <=", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdLike(String value) {
            addCriterion("uAddr_id like", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdNotLike(String value) {
            addCriterion("uAddr_id not like", value, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdIn(List<String> values) {
            addCriterion("uAddr_id in", values, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdNotIn(List<String> values) {
            addCriterion("uAddr_id not in", values, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdBetween(String value1, String value2) {
            addCriterion("uAddr_id between", value1, value2, "uaddrId");
            return (Criteria) this;
        }

        public Criteria andUaddrIdNotBetween(String value1, String value2) {
            addCriterion("uAddr_id not between", value1, value2, "uaddrId");
            return (Criteria) this;
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

        public Criteria andUAddressIsNull() {
            addCriterion("u_address is null");
            return (Criteria) this;
        }

        public Criteria andUAddressIsNotNull() {
            addCriterion("u_address is not null");
            return (Criteria) this;
        }

        public Criteria andUAddressEqualTo(String value) {
            addCriterion("u_address =", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotEqualTo(String value) {
            addCriterion("u_address <>", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThan(String value) {
            addCriterion("u_address >", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThanOrEqualTo(String value) {
            addCriterion("u_address >=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThan(String value) {
            addCriterion("u_address <", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThanOrEqualTo(String value) {
            addCriterion("u_address <=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLike(String value) {
            addCriterion("u_address like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotLike(String value) {
            addCriterion("u_address not like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressIn(List<String> values) {
            addCriterion("u_address in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotIn(List<String> values) {
            addCriterion("u_address not in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressBetween(String value1, String value2) {
            addCriterion("u_address between", value1, value2, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotBetween(String value1, String value2) {
            addCriterion("u_address not between", value1, value2, "uAddress");
            return (Criteria) this;
        }

        public Criteria andOPhoneIsNull() {
            addCriterion("o_phone is null");
            return (Criteria) this;
        }

        public Criteria andOPhoneIsNotNull() {
            addCriterion("o_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOPhoneEqualTo(String value) {
            addCriterion("o_phone =", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotEqualTo(String value) {
            addCriterion("o_phone <>", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneGreaterThan(String value) {
            addCriterion("o_phone >", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("o_phone >=", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLessThan(String value) {
            addCriterion("o_phone <", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLessThanOrEqualTo(String value) {
            addCriterion("o_phone <=", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLike(String value) {
            addCriterion("o_phone like", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotLike(String value) {
            addCriterion("o_phone not like", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneIn(List<String> values) {
            addCriterion("o_phone in", values, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotIn(List<String> values) {
            addCriterion("o_phone not in", values, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneBetween(String value1, String value2) {
            addCriterion("o_phone between", value1, value2, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotBetween(String value1, String value2) {
            addCriterion("o_phone not between", value1, value2, "oPhone");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultIsNull() {
            addCriterion("u_isDefault is null");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultIsNotNull() {
            addCriterion("u_isDefault is not null");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultEqualTo(Integer value) {
            addCriterion("u_isDefault =", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultNotEqualTo(Integer value) {
            addCriterion("u_isDefault <>", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultGreaterThan(Integer value) {
            addCriterion("u_isDefault >", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_isDefault >=", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultLessThan(Integer value) {
            addCriterion("u_isDefault <", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultLessThanOrEqualTo(Integer value) {
            addCriterion("u_isDefault <=", value, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultIn(List<Integer> values) {
            addCriterion("u_isDefault in", values, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultNotIn(List<Integer> values) {
            addCriterion("u_isDefault not in", values, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultBetween(Integer value1, Integer value2) {
            addCriterion("u_isDefault between", value1, value2, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andUIsdefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("u_isDefault not between", value1, value2, "uIsdefault");
            return (Criteria) this;
        }

        public Criteria andOReceiverIsNull() {
            addCriterion("o_receiver is null");
            return (Criteria) this;
        }

        public Criteria andOReceiverIsNotNull() {
            addCriterion("o_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andOReceiverEqualTo(String value) {
            addCriterion("o_receiver =", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverNotEqualTo(String value) {
            addCriterion("o_receiver <>", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverGreaterThan(String value) {
            addCriterion("o_receiver >", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("o_receiver >=", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverLessThan(String value) {
            addCriterion("o_receiver <", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverLessThanOrEqualTo(String value) {
            addCriterion("o_receiver <=", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverLike(String value) {
            addCriterion("o_receiver like", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverNotLike(String value) {
            addCriterion("o_receiver not like", value, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverIn(List<String> values) {
            addCriterion("o_receiver in", values, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverNotIn(List<String> values) {
            addCriterion("o_receiver not in", values, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverBetween(String value1, String value2) {
            addCriterion("o_receiver between", value1, value2, "oReceiver");
            return (Criteria) this;
        }

        public Criteria andOReceiverNotBetween(String value1, String value2) {
            addCriterion("o_receiver not between", value1, value2, "oReceiver");
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