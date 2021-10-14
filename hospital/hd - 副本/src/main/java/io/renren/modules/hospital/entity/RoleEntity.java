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
@TableName("role")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer roleid;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 角色名称
	 */
	private String rolename;


}
