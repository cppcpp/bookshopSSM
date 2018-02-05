package com.bookshop.modle;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BooksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BooksExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBDescriptionIsNull() {
            addCriterion("b_description is null");
            return (Criteria) this;
        }

        public Criteria andBDescriptionIsNotNull() {
            addCriterion("b_description is not null");
            return (Criteria) this;
        }

        public Criteria andBDescriptionEqualTo(String value) {
            addCriterion("b_description =", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionNotEqualTo(String value) {
            addCriterion("b_description <>", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionGreaterThan(String value) {
            addCriterion("b_description >", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("b_description >=", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionLessThan(String value) {
            addCriterion("b_description <", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionLessThanOrEqualTo(String value) {
            addCriterion("b_description <=", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionLike(String value) {
            addCriterion("b_description like", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionNotLike(String value) {
            addCriterion("b_description not like", value, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionIn(List<String> values) {
            addCriterion("b_description in", values, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionNotIn(List<String> values) {
            addCriterion("b_description not in", values, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionBetween(String value1, String value2) {
            addCriterion("b_description between", value1, value2, "bDescription");
            return (Criteria) this;
        }

        public Criteria andBDescriptionNotBetween(String value1, String value2) {
            addCriterion("b_description not between", value1, value2, "bDescription");
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

        public Criteria andBDiscountIsNull() {
            addCriterion("b_discount is null");
            return (Criteria) this;
        }

        public Criteria andBDiscountIsNotNull() {
            addCriterion("b_discount is not null");
            return (Criteria) this;
        }

        public Criteria andBDiscountEqualTo(Integer value) {
            addCriterion("b_discount =", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountNotEqualTo(Integer value) {
            addCriterion("b_discount <>", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountGreaterThan(Integer value) {
            addCriterion("b_discount >", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_discount >=", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountLessThan(Integer value) {
            addCriterion("b_discount <", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("b_discount <=", value, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountIn(List<Integer> values) {
            addCriterion("b_discount in", values, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountNotIn(List<Integer> values) {
            addCriterion("b_discount not in", values, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountBetween(Integer value1, Integer value2) {
            addCriterion("b_discount between", value1, value2, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("b_discount not between", value1, value2, "bDiscount");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNull() {
            addCriterion("b_author is null");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNotNull() {
            addCriterion("b_author is not null");
            return (Criteria) this;
        }

        public Criteria andBAuthorEqualTo(String value) {
            addCriterion("b_author =", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotEqualTo(String value) {
            addCriterion("b_author <>", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThan(String value) {
            addCriterion("b_author >", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("b_author >=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThan(String value) {
            addCriterion("b_author <", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThanOrEqualTo(String value) {
            addCriterion("b_author <=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLike(String value) {
            addCriterion("b_author like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotLike(String value) {
            addCriterion("b_author not like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorIn(List<String> values) {
            addCriterion("b_author in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotIn(List<String> values) {
            addCriterion("b_author not in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorBetween(String value1, String value2) {
            addCriterion("b_author between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotBetween(String value1, String value2) {
            addCriterion("b_author not between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBPressIsNull() {
            addCriterion("b_press is null");
            return (Criteria) this;
        }

        public Criteria andBPressIsNotNull() {
            addCriterion("b_press is not null");
            return (Criteria) this;
        }

        public Criteria andBPressEqualTo(String value) {
            addCriterion("b_press =", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressNotEqualTo(String value) {
            addCriterion("b_press <>", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressGreaterThan(String value) {
            addCriterion("b_press >", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressGreaterThanOrEqualTo(String value) {
            addCriterion("b_press >=", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressLessThan(String value) {
            addCriterion("b_press <", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressLessThanOrEqualTo(String value) {
            addCriterion("b_press <=", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressLike(String value) {
            addCriterion("b_press like", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressNotLike(String value) {
            addCriterion("b_press not like", value, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressIn(List<String> values) {
            addCriterion("b_press in", values, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressNotIn(List<String> values) {
            addCriterion("b_press not in", values, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressBetween(String value1, String value2) {
            addCriterion("b_press between", value1, value2, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressNotBetween(String value1, String value2) {
            addCriterion("b_press not between", value1, value2, "bPress");
            return (Criteria) this;
        }

        public Criteria andBPressTimeIsNull() {
            addCriterion("b_press_time is null");
            return (Criteria) this;
        }

        public Criteria andBPressTimeIsNotNull() {
            addCriterion("b_press_time is not null");
            return (Criteria) this;
        }

        public Criteria andBPressTimeEqualTo(Date value) {
            addCriterionForJDBCDate("b_press_time =", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("b_press_time <>", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("b_press_time >", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_press_time >=", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeLessThan(Date value) {
            addCriterionForJDBCDate("b_press_time <", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("b_press_time <=", value, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeIn(List<Date> values) {
            addCriterionForJDBCDate("b_press_time in", values, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("b_press_time not in", values, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_press_time between", value1, value2, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBPressTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("b_press_time not between", value1, value2, "bPressTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeIsNull() {
            addCriterion("b_add_time is null");
            return (Criteria) this;
        }

        public Criteria andBAddTimeIsNotNull() {
            addCriterion("b_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andBAddTimeEqualTo(Date value) {
            addCriterion("b_add_time =", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeNotEqualTo(Date value) {
            addCriterion("b_add_time <>", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeGreaterThan(Date value) {
            addCriterion("b_add_time >", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("b_add_time >=", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeLessThan(Date value) {
            addCriterion("b_add_time <", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("b_add_time <=", value, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeIn(List<Date> values) {
            addCriterion("b_add_time in", values, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeNotIn(List<Date> values) {
            addCriterion("b_add_time not in", values, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeBetween(Date value1, Date value2) {
            addCriterion("b_add_time between", value1, value2, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("b_add_time not between", value1, value2, "bAddTime");
            return (Criteria) this;
        }

        public Criteria andBServiceIsNull() {
            addCriterion("b_service is null");
            return (Criteria) this;
        }

        public Criteria andBServiceIsNotNull() {
            addCriterion("b_service is not null");
            return (Criteria) this;
        }

        public Criteria andBServiceEqualTo(String value) {
            addCriterion("b_service =", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceNotEqualTo(String value) {
            addCriterion("b_service <>", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceGreaterThan(String value) {
            addCriterion("b_service >", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceGreaterThanOrEqualTo(String value) {
            addCriterion("b_service >=", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceLessThan(String value) {
            addCriterion("b_service <", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceLessThanOrEqualTo(String value) {
            addCriterion("b_service <=", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceLike(String value) {
            addCriterion("b_service like", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceNotLike(String value) {
            addCriterion("b_service not like", value, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceIn(List<String> values) {
            addCriterion("b_service in", values, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceNotIn(List<String> values) {
            addCriterion("b_service not in", values, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceBetween(String value1, String value2) {
            addCriterion("b_service between", value1, value2, "bService");
            return (Criteria) this;
        }

        public Criteria andBServiceNotBetween(String value1, String value2) {
            addCriterion("b_service not between", value1, value2, "bService");
            return (Criteria) this;
        }

        public Criteria andBSaleNumIsNull() {
            addCriterion("b_sale_num is null");
            return (Criteria) this;
        }

        public Criteria andBSaleNumIsNotNull() {
            addCriterion("b_sale_num is not null");
            return (Criteria) this;
        }

        public Criteria andBSaleNumEqualTo(Integer value) {
            addCriterion("b_sale_num =", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumNotEqualTo(Integer value) {
            addCriterion("b_sale_num <>", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumGreaterThan(Integer value) {
            addCriterion("b_sale_num >", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_sale_num >=", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumLessThan(Integer value) {
            addCriterion("b_sale_num <", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("b_sale_num <=", value, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumIn(List<Integer> values) {
            addCriterion("b_sale_num in", values, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumNotIn(List<Integer> values) {
            addCriterion("b_sale_num not in", values, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumBetween(Integer value1, Integer value2) {
            addCriterion("b_sale_num between", value1, value2, "bSaleNum");
            return (Criteria) this;
        }

        public Criteria andBSaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("b_sale_num not between", value1, value2, "bSaleNum");
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