package com.SecureMessage.demo.model;

import java.util.ArrayList;
import java.util.List;

public class friendspkDaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public friendspkDaoExample() {
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

        public Criteria andFriendspkIdIsNull() {
            addCriterion("friendspk_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdIsNotNull() {
            addCriterion("friendspk_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdEqualTo(Long value) {
            addCriterion("friendspk_id =", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdNotEqualTo(Long value) {
            addCriterion("friendspk_id <>", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdGreaterThan(Long value) {
            addCriterion("friendspk_id >", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("friendspk_id >=", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdLessThan(Long value) {
            addCriterion("friendspk_id <", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdLessThanOrEqualTo(Long value) {
            addCriterion("friendspk_id <=", value, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdIn(List<Long> values) {
            addCriterion("friendspk_id in", values, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdNotIn(List<Long> values) {
            addCriterion("friendspk_id not in", values, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdBetween(Long value1, Long value2) {
            addCriterion("friendspk_id between", value1, value2, "friendspkId");
            return (Criteria) this;
        }

        public Criteria andFriendspkIdNotBetween(Long value1, Long value2) {
            addCriterion("friendspk_id not between", value1, value2, "friendspkId");
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

        public Criteria andReceiverIdIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(Long value) {
            addCriterion("receiver_id =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(Long value) {
            addCriterion("receiver_id <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(Long value) {
            addCriterion("receiver_id >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(Long value) {
            addCriterion("receiver_id <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<Long> values) {
            addCriterion("receiver_id in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<Long> values) {
            addCriterion("receiver_id not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(Long value1, Long value2) {
            addCriterion("receiver_id between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id not between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andKeySenderIsNull() {
            addCriterion("key_sender is null");
            return (Criteria) this;
        }

        public Criteria andKeySenderIsNotNull() {
            addCriterion("key_sender is not null");
            return (Criteria) this;
        }

        public Criteria andKeySenderEqualTo(String value) {
            addCriterion("key_sender =", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderNotEqualTo(String value) {
            addCriterion("key_sender <>", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderGreaterThan(String value) {
            addCriterion("key_sender >", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderGreaterThanOrEqualTo(String value) {
            addCriterion("key_sender >=", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderLessThan(String value) {
            addCriterion("key_sender <", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderLessThanOrEqualTo(String value) {
            addCriterion("key_sender <=", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderLike(String value) {
            addCriterion("key_sender like", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderNotLike(String value) {
            addCriterion("key_sender not like", value, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderIn(List<String> values) {
            addCriterion("key_sender in", values, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderNotIn(List<String> values) {
            addCriterion("key_sender not in", values, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderBetween(String value1, String value2) {
            addCriterion("key_sender between", value1, value2, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeySenderNotBetween(String value1, String value2) {
            addCriterion("key_sender not between", value1, value2, "keySender");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverIsNull() {
            addCriterion("key_receiver is null");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverIsNotNull() {
            addCriterion("key_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverEqualTo(String value) {
            addCriterion("key_receiver =", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverNotEqualTo(String value) {
            addCriterion("key_receiver <>", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverGreaterThan(String value) {
            addCriterion("key_receiver >", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("key_receiver >=", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverLessThan(String value) {
            addCriterion("key_receiver <", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverLessThanOrEqualTo(String value) {
            addCriterion("key_receiver <=", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverLike(String value) {
            addCriterion("key_receiver like", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverNotLike(String value) {
            addCriterion("key_receiver not like", value, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverIn(List<String> values) {
            addCriterion("key_receiver in", values, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverNotIn(List<String> values) {
            addCriterion("key_receiver not in", values, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverBetween(String value1, String value2) {
            addCriterion("key_receiver between", value1, value2, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andKeyReceiverNotBetween(String value1, String value2) {
            addCriterion("key_receiver not between", value1, value2, "keyReceiver");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedIsNull() {
            addCriterion("receiver_decided is null");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedIsNotNull() {
            addCriterion("receiver_decided is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedEqualTo(Boolean value) {
            addCriterion("receiver_decided =", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedNotEqualTo(Boolean value) {
            addCriterion("receiver_decided <>", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedGreaterThan(Boolean value) {
            addCriterion("receiver_decided >", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("receiver_decided >=", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedLessThan(Boolean value) {
            addCriterion("receiver_decided <", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedLessThanOrEqualTo(Boolean value) {
            addCriterion("receiver_decided <=", value, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedIn(List<Boolean> values) {
            addCriterion("receiver_decided in", values, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedNotIn(List<Boolean> values) {
            addCriterion("receiver_decided not in", values, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedBetween(Boolean value1, Boolean value2) {
            addCriterion("receiver_decided between", value1, value2, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andReceiverDecidedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("receiver_decided not between", value1, value2, "receiverDecided");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedIsNull() {
            addCriterion("sender_retrieved is null");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedIsNotNull() {
            addCriterion("sender_retrieved is not null");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedEqualTo(Boolean value) {
            addCriterion("sender_retrieved =", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedNotEqualTo(Boolean value) {
            addCriterion("sender_retrieved <>", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedGreaterThan(Boolean value) {
            addCriterion("sender_retrieved >", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sender_retrieved >=", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedLessThan(Boolean value) {
            addCriterion("sender_retrieved <", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedLessThanOrEqualTo(Boolean value) {
            addCriterion("sender_retrieved <=", value, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedIn(List<Boolean> values) {
            addCriterion("sender_retrieved in", values, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedNotIn(List<Boolean> values) {
            addCriterion("sender_retrieved not in", values, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedBetween(Boolean value1, Boolean value2) {
            addCriterion("sender_retrieved between", value1, value2, "senderRetrieved");
            return (Criteria) this;
        }

        public Criteria andSenderRetrievedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sender_retrieved not between", value1, value2, "senderRetrieved");
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