package com.bookshop.modle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andONumIsNull() {
            addCriterion("o_num is null");
            return (Criteria) this;
        }

        public Criteria andONumIsNotNull() {
            addCriterion("o_num is not null");
            return (Criteria) this;
        }

        public Criteria andONumEqualTo(Integer value) {
            addCriterion("o_num =", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumNotEqualTo(Integer value) {
            addCriterion("o_num <>", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumGreaterThan(Integer value) {
            addCriterion("o_num >", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_num >=", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumLessThan(Integer value) {
            addCriterion("o_num <", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumLessThanOrEqualTo(Integer value) {
            addCriterion("o_num <=", value, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumIn(List<Integer> values) {
            addCriterion("o_num in", values, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumNotIn(List<Integer> values) {
            addCriterion("o_num not in", values, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumBetween(Integer value1, Integer value2) {
            addCriterion("o_num between", value1, value2, "oNum");
            return (Criteria) this;
        }

        public Criteria andONumNotBetween(Integer value1, Integer value2) {
            addCriterion("o_num not between", value1, value2, "oNum");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNull() {
            addCriterion("o_price is null");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNotNull() {
            addCriterion("o_price is not null");
            return (Criteria) this;
        }

        public Criteria andOPriceEqualTo(Float value) {
            addCriterion("o_price =", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotEqualTo(Float value) {
            addCriterion("o_price <>", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThan(Float value) {
            addCriterion("o_price >", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("o_price >=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThan(Float value) {
            addCriterion("o_price <", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThanOrEqualTo(Float value) {
            addCriterion("o_price <=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceIn(List<Float> values) {
            addCriterion("o_price in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotIn(List<Float> values) {
            addCriterion("o_price not in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceBetween(Float value1, Float value2) {
            addCriterion("o_price between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotBetween(Float value1, Float value2) {
            addCriterion("o_price not between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOTimeIsNull() {
            addCriterion("o_time is null");
            return (Criteria) this;
        }

        public Criteria andOTimeIsNotNull() {
            addCriterion("o_time is not null");
            return (Criteria) this;
        }

        public Criteria andOTimeEqualTo(Date value) {
            addCriterion("o_time =", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotEqualTo(Date value) {
            addCriterion("o_time <>", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeGreaterThan(Date value) {
            addCriterion("o_time >", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("o_time >=", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeLessThan(Date value) {
            addCriterion("o_time <", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeLessThanOrEqualTo(Date value) {
            addCriterion("o_time <=", value, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeIn(List<Date> values) {
            addCriterion("o_time in", values, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotIn(List<Date> values) {
            addCriterion("o_time not in", values, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeBetween(Date value1, Date value2) {
            addCriterion("o_time between", value1, value2, "oTime");
            return (Criteria) this;
        }

        public Criteria andOTimeNotBetween(Date value1, Date value2) {
            addCriterion("o_time not between", value1, value2, "oTime");
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

        public Criteria andUReceiverIsNull() {
            addCriterion("u_receiver is null");
            return (Criteria) this;
        }

        public Criteria andUReceiverIsNotNull() {
            addCriterion("u_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andUReceiverEqualTo(String value) {
            addCriterion("u_receiver =", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverNotEqualTo(String value) {
            addCriterion("u_receiver <>", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverGreaterThan(String value) {
            addCriterion("u_receiver >", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("u_receiver >=", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverLessThan(String value) {
            addCriterion("u_receiver <", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverLessThanOrEqualTo(String value) {
            addCriterion("u_receiver <=", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverLike(String value) {
            addCriterion("u_receiver like", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverNotLike(String value) {
            addCriterion("u_receiver not like", value, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverIn(List<String> values) {
            addCriterion("u_receiver in", values, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverNotIn(List<String> values) {
            addCriterion("u_receiver not in", values, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverBetween(String value1, String value2) {
            addCriterion("u_receiver between", value1, value2, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andUReceiverNotBetween(String value1, String value2) {
            addCriterion("u_receiver not between", value1, value2, "uReceiver");
            return (Criteria) this;
        }

        public Criteria andOCheaperIsNull() {
            addCriterion("o_cheaper is null");
            return (Criteria) this;
        }

        public Criteria andOCheaperIsNotNull() {
            addCriterion("o_cheaper is not null");
            return (Criteria) this;
        }

        public Criteria andOCheaperEqualTo(Float value) {
            addCriterion("o_cheaper =", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperNotEqualTo(Float value) {
            addCriterion("o_cheaper <>", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperGreaterThan(Float value) {
            addCriterion("o_cheaper >", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperGreaterThanOrEqualTo(Float value) {
            addCriterion("o_cheaper >=", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperLessThan(Float value) {
            addCriterion("o_cheaper <", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperLessThanOrEqualTo(Float value) {
            addCriterion("o_cheaper <=", value, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperIn(List<Float> values) {
            addCriterion("o_cheaper in", values, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperNotIn(List<Float> values) {
            addCriterion("o_cheaper not in", values, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperBetween(Float value1, Float value2) {
            addCriterion("o_cheaper between", value1, value2, "oCheaper");
            return (Criteria) this;
        }

        public Criteria andOCheaperNotBetween(Float value1, Float value2) {
            addCriterion("o_cheaper not between", value1, value2, "oCheaper");
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