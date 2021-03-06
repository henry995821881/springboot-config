package org.henry.wx_account.bean;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.type
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.remark
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.user_id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.money
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private Integer money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tab_account.create_date
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    private Date createDate;
    private String createDateStr;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.id
     *
     * @return the value of tab_account.id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.id
     *
     * @param id the value for tab_account.id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.type
     *
     * @return the value of tab_account.type
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.type
     *
     * @param type the value for tab_account.type
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.remark
     *
     * @return the value of tab_account.remark
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.remark
     *
     * @param remark the value for tab_account.remark
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.user_id
     *
     * @return the value of tab_account.user_id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.user_id
     *
     * @param userId the value for tab_account.user_id
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.money
     *
     * @return the value of tab_account.money
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.money
     *
     * @param money the value for tab_account.money
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tab_account.create_date
     *
     * @return the value of tab_account.create_date
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tab_account.create_date
     *
     * @param createDate the value for tab_account.create_date
     *
     * @mbggenerated Wed Sep 20 15:27:42 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", remark=" + remark + ", userId=" + userId + ", money=" + money
				+ ", createDate=" + createDate + "]";
	}
    
}