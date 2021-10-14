package io.renren.modules.hospital.dao;

import io.renren.modules.hospital.entity.DeptEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.hospital.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zxl
 * @email 710465130@qq.com
 * @date 2021-09-26 11:17:30
 */
@Mapper
public interface DeptDao extends BaseMapper<DeptEntity> {
    DeptEntity findById(String deptid);
}
