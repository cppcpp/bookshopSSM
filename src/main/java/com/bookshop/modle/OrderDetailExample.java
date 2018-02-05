package com.bookshop.modle;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andODIdIsNull() {
            addCriterion("o_d_id is null");
            return (Criteria) this;
        }

        public Criteria andODIdIsNotNull() {
            addCriterion("o_d_id is not null");
            return (Criteria) this;
        }

        public Criteria andODIdEqualTo(String value) {
            addCriterion("o_d_id =", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdNotEqualTo(String value) {
            addCriterion("o_d_id <>", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdGreaterThan(String value) {
            addCriterion("o_d_id >", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_d_id >=", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdLessThan(String value) {
            addCriterion("o_d_id <", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdLessThanOrEqualTo(String value) {
            addCriterion("o_d_id <=", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdLike(String value) {
            addCriterion("o_d_id like", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdNotLike(String value) {
            addCriterion("o_d_id not like", value, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdIn(List<String> values) {
            addCriterion("o_d_id in", values, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdNotIn(List<String> values) {
            addCriterion("o_d_id not in", values, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdBetween(String value1, String value2) {
            addCriterion("o_d_id between", value1, value2, "oDId");
            return (Criteria) this;
        }

        public Criteria andODIdNotBetween(String value1, String value2) {
            addCriterion("o_d_id not between", value1, value2, "oDId");
            return (Criteria) this;
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

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(String value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(String value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(String value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(String value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(String value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(String value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLike(String value) {
            addCriterion("b_id like", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotLike(String value) {
            addCriterion("b_id not like", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<String> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<String> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(String value1, String value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(String value1, String value2) {
            addCriterion("b_id not between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBNameIsNull() {
            addCriterion("b_name is null");
            return (Criteria) this;
        }

        public Criteria andBNameIsNotNull() {
            addCriterion("b_name is not null");
            return (Criteria) this;
        }

        public Criteria andBNameEqualTo(String value) {
            addCriterion("b_name =", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotEqualTo(String value) {
            addCriterion("b_name <>", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThan(String value) {
            addCriterion("b_name >", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_name >=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThan(String value) {
            addCriterion("b_name <", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThanOrEqualTo(String value) {
            addCriterion("b_name <=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLike(String value) {
            addCriterion("b_name like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotLike(String value) {
            addCriterion("b_name not like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameIn(List<String> values) {
            addCriterion("b_name in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotIn(List<String> values) {
            addCriterion("b_name not in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameBetween(String value1, String value2) {
            addCriterion("b_name between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotBetween(String value1, String value2) {
            addCriterion("b_name not between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNumsIsNull() {
            addCriterion("b_nums is null");
            return (Criteria) this;
        }

        public Criteria andBNumsIsNotNull() {
            addCriterion("b_nums is not null");
            return (Criteria) this;
        }

        public Criteria andBNumsEqualTo(Integer value) {
            addCriterion("b_nums =", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsNotEqualTo(Integer value) {
            addCriterion("b_nums <>", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsGreaterThan(Integer value) {
            addCriterion("b_nums >", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_nums >=", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsLessThan(Integer value) {
            addCriterion("b_nums <", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsLessThanOrEqualTo(Integer value) {
            addCriterion("b_nums <=", value, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsIn(List<Integer> values) {
            addCriterion("b_nums in", values, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsNotIn(List<Integer> values) {
            addCriterion("b_nums not in", values, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsBetween(Integer value1, Integer value2) {
            addCriterion("b_nums between", value1, value2, "bNums");
            return (Criteria) this;
        }

        public Criteria andBNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("b_nums not between", value1, value2, "bNums");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNull() {
            addCriterion("b_price is null");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNotNull() {
            addCriterion("b_price is not null");
            return (Criteria) this;
        }

        public Criteria andBPriceEqualTo(Float value) {
            addCriterion("b_price =", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotEqualTo(Float value) {
            addCriterion("b_price <>", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThan(Float value) {
            addCriterion("b_price >", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_price >=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThan(Float value) {
            addCriterion("b_price <", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThanOrEqualTo(Float value) {
            addCriterion("b_price <=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceIn(List<Float> values) {
            addCriterion("b_price in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotIn(List<Float> values) {
            addCriterion("b_price not in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceBetween(Float value1, Float value2) {
            addCriterion("b_price between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotBetween(Float value1, Float value2) {
            addCriterion("b_price not between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceIsNull() {
            addCriterion("b_discountprice is null");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceIsNotNull() {
            addCriterion("b_discountprice is not null");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceEqualTo(Float value) {
            addCriterion("b_discountprice =", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceNotEqualTo(Float value) {
            addCriterion("b_discountprice <>", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceGreaterThan(Float value) {
            addCriterion("b_discountprice >", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_discountprice >=", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceLessThan(Float value) {
            addCriterion("b_discountprice <", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceLessThanOrEqualTo(Float value) {
            addCriterion("b_discountprice <=", value, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceIn(List<Float> values) {
            addCriterion("b_discountprice in", values, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceNotIn(List<Float> values) {
            addCriterion("b_discountprice not in", values, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceBetween(Float value1, Float value2) {
            addCriterion("b_discountprice between", value1, value2, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBDiscountpriceNotBetween(Float value1, Float value2) {
            addCriterion("b_discountprice not between", value1, value2, "bDiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceIsNull() {
            addCriterion("b_sumprice is null");
            return (Criteria) this;
        }

        public Criteria andBSumpriceIsNotNull() {
            addCriterion("b_sumprice is not null");
            return (Criteria) this;
        }

        public Criteria andBSumpriceEqualTo(Float value) {
            addCriterion("b_sumprice =", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceNotEqualTo(Float value) {
            addCriterion("b_sumprice <>", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceGreaterThan(Float value) {
            addCriterion("b_sumprice >", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_sumprice >=", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceLessThan(Float value) {
            addCriterion("b_sumprice <", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceLessThanOrEqualTo(Float value) {
            addCriterion("b_sumprice <=", value, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceIn(List<Float> values) {
            addCriterion("b_sumprice in", values, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceNotIn(List<Float> values) {
            addCriterion("b_sumprice not in", values, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceBetween(Float value1, Float value2) {
            addCriterion("b_sumprice between", value1, value2, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumpriceNotBetween(Float value1, Float value2) {
            addCriterion("b_sumprice not between", value1, value2, "bSumprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceIsNull() {
            addCriterion("b_sumdiscountprice is null");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceIsNotNull() {
            addCriterion("b_sumdiscountprice is not null");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceEqualTo(Float value) {
            addCriterion("b_sumdiscountprice =", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceNotEqualTo(Float value) {
            addCriterion("b_sumdiscountprice <>", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceGreaterThan(Float value) {
            addCriterion("b_sumdiscountprice >", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_sumdiscountprice >=", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceLessThan(Float value) {
            addCriterion("b_sumdiscountprice <", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceLessThanOrEqualTo(Float value) {
            addCriterion("b_sumdiscountprice <=", value, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceIn(List<Float> values) {
            addCriterion("b_sumdiscountprice in", values, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceNotIn(List<Float> values) {
            addCriterion("b_sumdiscountprice not in", values, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceBetween(Float value1, Float value2) {
            addCriterion("b_sumdiscountprice between", value1, value2, "bSumdiscountprice");
            return (Criteria) this;
        }

        public Criteria andBSumdiscountpriceNotBetween(Float value1, Float value2) {
            addCriterion("b_sumdiscountprice not between", value1, value2, "bSumdiscountprice");
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