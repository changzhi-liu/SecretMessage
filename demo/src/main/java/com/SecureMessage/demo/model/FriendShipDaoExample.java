package com.SecureMessage.demo.model;

import java.util.ArrayList;
import java.util.List;

public class FriendShipDaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendShipDaoExample() {
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

        public Criteria andSenderIdIsNull() {
            addCriterion("sender_id is null");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNotNull() {
            addCriterion("sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenderIdEqualTo(Long value) {
            addCriterion("sender_id =", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotEqualTo(Long value) {
            addCriterion("sender_id <>", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThan(Long value) {
            addCriterion("sender_id >", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sender_id >=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThan(Long value) {
            addCriterion("sender_id <", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(Long value) {
            addCriterion("sender_id <=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdIn(List<Long> values) {
            addCriterion("sender_id in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotIn(List<Long> values) {
            addCriterion("sender_id not in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdBetween(Long value1, Long value2) {
            addCriterion("sender_id between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotBetween(Long value1, Long value2) {
            addCriterion("sender_id not between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdIsNull() {
            addCriterion("reciever_id is null");
            return (Criteria) this;
        }

        public Criteria andRecieverIdIsNotNull() {
            addCriterion("reciever_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecieverIdEqualTo(Long value) {
            addCriterion("reciever_id =", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdNotEqualTo(Long value) {
            addCriterion("reciever_id <>", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdGreaterThan(Long value) {
            addCriterion("reciever_id >", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reciever_id >=", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdLessThan(Long value) {
            addCriterion("reciever_id <", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdLessThanOrEqualTo(Long value) {
            addCriterion("reciever_id <=", value, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdIn(List<Long> values) {
            addCriterion("reciever_id in", values, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdNotIn(List<Long> values) {
            addCriterion("reciever_id not in", values, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdBetween(Long value1, Long value2) {
            addCriterion("reciever_id between", value1, value2, "recieverId");
            return (Criteria) this;
        }

        public Criteria andRecieverIdNotBetween(Long value1, Long value2) {
            addCriterion("reciever_id not between", value1, value2, "recieverId");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexIsNull() {
            addCriterion("msg_starting_index is null");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexIsNotNull() {
            addCriterion("msg_starting_index is not null");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexEqualTo(Integer value) {
            addCriterion("msg_starting_index =", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexNotEqualTo(Integer value) {
            addCriterion("msg_starting_index <>", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexGreaterThan(Integer value) {
            addCriterion("msg_starting_index >", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_starting_index >=", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexLessThan(Integer value) {
            addCriterion("msg_starting_index <", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexLessThanOrEqualTo(Integer value) {
            addCriterion("msg_starting_index <=", value, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexIn(List<Integer> values) {
            addCriterion("msg_starting_index in", values, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexNotIn(List<Integer> values) {
            addCriterion("msg_starting_index not in", values, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexBetween(Integer value1, Integer value2) {
            addCriterion("msg_starting_index between", value1, value2, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgStartingIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_starting_index not between", value1, value2, "msgStartingIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexIsNull() {
            addCriterion("msg_current_index is null");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexIsNotNull() {
            addCriterion("msg_current_index is not null");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexEqualTo(Integer value) {
            addCriterion("msg_current_index =", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexNotEqualTo(Integer value) {
            addCriterion("msg_current_index <>", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexGreaterThan(Integer value) {
            addCriterion("msg_current_index >", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_current_index >=", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexLessThan(Integer value) {
            addCriterion("msg_current_index <", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexLessThanOrEqualTo(Integer value) {
            addCriterion("msg_current_index <=", value, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexIn(List<Integer> values) {
            addCriterion("msg_current_index in", values, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexNotIn(List<Integer> values) {
            addCriterion("msg_current_index not in", values, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexBetween(Integer value1, Integer value2) {
            addCriterion("msg_current_index between", value1, value2, "msgCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andMsgCurrentIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_current_index not between", value1, value2, "msgCurrentIndex");
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