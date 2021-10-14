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
@TableName("medicine")
public class MedicineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String mid;
	/**
	 * 图片地址
	 */
	private String picture;
	/**
	 * 进价
	 */
	private Double inPrice;
	/**
	 * 售价
	 */
	private Double salPrice;
	/**
	 * 药品名称
	 */
	private String name;
	/**
	 * 药品类型 0处方1中药2西药
	 */
	private Integer type;
	/**
	 * 简单描述
	 */
	private String descs;
	/**
	 * 保质期
	 */
	private Integer qualityDate;
	/**
	 * 详细描述
	 */
	private String description;
	/**
	 * 生产厂商
	 */
	private String produceFirm;
	/**
	 * 服用说明
	 */
	private String readme;
	/**
	 * 总的进货量
	 */
	private Integer countAll;
	/**
	 * 剩余量
	 */
	private Integer countSurplus;
	/**
	 * 备注
	 */
	private String remark;

}
