package io.renren.modules.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.hospital.entity.DoctorEntity;

import java.util.Map;

/**
 * 
 *
 * @author zxl
 * @email 710465130@qq.com
 * @date 2021-09-26 11:17:30
 */
public interface DoctorService extends IService<DoctorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

