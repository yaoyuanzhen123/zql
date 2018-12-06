package com.yyz.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_USER")
public class TSysUser implements Serializable {

    /**   主键 id   */
    private Integer  id;
    /**    用户名   */
    private String   userName;
    /**    性别     */
    private String   sex;
    /**    权限类型 */
    private Integer  type;
    /**    用户账号  */
    private String   accountNumber;
    /**    用户密码  */
    private String   passWord;
    /**    创建时间  */
    private Date     createTime;
    /**    创建人    */
    private String   createUser;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }
    @Column(name = "USER_NAME",nullable = true,length = 255)
    public String getUserName() {
        return userName;
    }
    @Column(name = "SEX",nullable = true,length = 4)
    public String getSex() {
        return sex;
    }
    @Column(name = "TYPE", nullable = true, precision = 0)
    public Integer getType() {
        return type;
    }
    @Column(name = "ACCOUNT_NUMBER",nullable = true,length = 255)
    public String getAccountNumber() {
        return accountNumber;
    }
    @Column(name = "PASS_WORD",nullable = true,length = 255)
    public String getPassWord() {
        return passWord;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }
    @Column(name = "CREATE_USER",nullable = true,length = 255)
    public String getCreateUser() {
        return createUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


}

