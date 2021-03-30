package com.SecureMessage.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageDetailDaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageDetailDaoExample() {
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

        public Criteria andMsgIndexIsNull() {
            addCriterion("msg_index is null");
            return (Criteria) this;
        }

        public Criteria andMsgIndexIsNotNull() {
            addCriterion("msg_index is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIndexEqualTo(Long value) {
            addCriterion("msg_index =", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexNotEqualTo(Long value) {
            addCriterion("msg_index <>", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexGreaterThan(Long value) {
            addCriterion("msg_index >", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("msg_index >=", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexLessThan(Long value) {
            addCriterion("msg_index <", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexLessThanOrEqualTo(Long value) {
            addCriterion("msg_index <=", value, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexIn(List<Long> values) {
            addCriterion("msg_index in", values, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexNotIn(List<Long> values) {
            addCriterion("msg_index not in", values, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexBetween(Long value1, Long value2) {
            addCriterion("msg_index between", value1, value2, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andMsgIndexNotBetween(Long value1, Long value2) {
            addCriterion("msg_index not between", value1, value2, "msgIndex");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andRecieverIsNull() {
            addCriterion("reciever is null");
            return (Criteria) this;
        }

        public Criteria andRecieverIsNotNull() {
            addCriterion("reciever is not null");
            return (Criteria) this;
        }

        public Criteria andRecieverEqualTo(String value) {
            addCriterion("reciever =", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverNotEqualTo(String value) {
            addCriterion("reciever <>", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverGreaterThan(String value) {
            addCriterion("reciever >", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverGreaterThanOrEqualTo(String value) {
            addCriterion("reciever >=", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverLessThan(String value) {
            addCriterion("reciever <", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverLessThanOrEqualTo(String value) {
            addCriterion("reciever <=", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverLike(String value) {
            addCriterion("reciever like", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverNotLike(String value) {
            addCriterion("reciever not like", value, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverIn(List<String> values) {
            addCriterion("reciever in", values, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverNotIn(List<String> values) {
            addCriterion("reciever not in", values, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverBetween(String value1, String value2) {
            addCriterion("reciever between", value1, value2, "reciever");
            return (Criteria) this;
        }

        public Criteria andRecieverNotBetween(String value1, String value2) {
            addCriterion("reciever not between", value1, value2, "reciever");
            return (Criteria) this;
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andValidationIsNull() {
            addCriterion("validation is null");
            return (Criteria) this;
        }

        public Criteria andValidationIsNotNull() {
            addCriterion("validation is not null");
            return (Criteria) this;
        }

        public Criteria andValidationEqualTo(Integer value) {
            addCriterion("validation =", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotEqualTo(Integer value) {
            addCriterion("validation <>", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationGreaterThan(Integer value) {
            addCriterion("validation >", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationGreaterThanOrEqualTo(Integer value) {
            addCriterion("validation >=", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationLessThan(Integer value) {
            addCriterion("validation <", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationLessThanOrEqualTo(Integer value) {
            addCriterion("validation <=", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationIn(List<Integer> values) {
            addCriterion("validation in", values, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotIn(List<Integer> values) {
            addCriterion("validation not in", values, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationBetween(Integer value1, Integer value2) {
            addCriterion("validation between", value1, value2, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotBetween(Integer value1, Integer value2) {
            addCriterion("validation not between", value1, value2, "validation");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
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