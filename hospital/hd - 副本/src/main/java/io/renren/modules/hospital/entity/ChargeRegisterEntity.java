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
@TableName("charge_register")
public class ChargeRegisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer crId;
	/**
	 * 病人外键
	 */
	private Integer rno;
	/**
	 * 收费项目表外键
	 */
	private Integer cid;
	/**
	 * 
	 */
	private Double chargePrice;
	/**
	 * 
	 */
	private String chargeDate;

}
