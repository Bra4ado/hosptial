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
@TableName("hospitalization")
public class HospitalizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer hid;
	/**
	 * 挂号信息外键
	 */
	private Integer rno;
	/**
	 * 床号
	 */
	private String bedNo;
	/**
	 * 押金
	 */
	private Double deposit;
	/**
	 * 病情描述
	 */
	private String description;
	/**
	 * 入院时间
	 */
	private String inDate;
	/**
	 * 护理
	 */
	private String protect;

}
