package com.yyz.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class VSysUser  implements Serializable {

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



}
