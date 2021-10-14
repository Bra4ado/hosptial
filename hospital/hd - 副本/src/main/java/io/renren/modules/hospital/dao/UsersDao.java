package io.renren.modules.hospital.dao;

import io.renren.modules.hospital.entity.UsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author zxl
 * @email 710465130@qq.com
 * @date 2021-09-26 11:17:30
 */
@Mapper
public interface UsersDao extends BaseMapper<UsersEntity> {
   List<UsersEntity> findDoctorAndDepartment();
}
