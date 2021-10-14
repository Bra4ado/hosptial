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
@TableName("doctor")
public class DoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer did;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 证件号
	 */
	private String cardNo;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 科室
	 */
	private Integer department;
	/**
	 * 学历
	 */
	private Integer education;
	/**
	 * 备注
	 */
	private String remark;

	@TableField(exist = false)
	private String sexhy;

	@TableField(exist = false)
	private DeptEntity deptEntity;

}
