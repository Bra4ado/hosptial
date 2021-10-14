package io.renren.modules.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author zxl
 * @email 710465130@qq.com
 * @date 2021-09-26 11:17:30
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer userid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 修改时间
	 */
	private String modifytime;
	/**
	 * 
	 */
	private Integer roleid;

	@TableField(exist = false)
	private RoleEntity role;

}
