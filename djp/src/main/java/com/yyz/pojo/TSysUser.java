package com.yyz.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class TSysUser {
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


    @Override
    public String toString() {
        return "TSysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", type=" + type +
                ", accountNumber='" + accountNumber + '\'' +
                ", passWord='" + passWord + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }

}
