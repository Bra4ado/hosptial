package io.renren.modules.hospital.entity;

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
@TableName("register")
public class RegisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 病历号
	 */
	@TableId
	private Integer rno;
	/**
	 * 
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 社保号
	 */
	private String siNumber;
	/**
	 * 挂号费用
	 */
	private Double registerMoney;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 是否自费
	 */
	private Integer isPay;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private String job;
	/**
	 * 初复诊
	 */
	private Integer consultation;
	/**
	 * 科室
	 */
	private Integer department;
	/**
	 * 医生外键
	 */
	private Integer did;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private String registerDate;

}
