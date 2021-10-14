package io.renren.modules.hospital.service.impl;

import io.renren.modules.hospital.entity.DeptEntity;
import io.renren.modules.hospital.entity.RoleEntity;
import io.renren.modules.hospital.entity.UsersEntity;
import io.renren.modules.hospital.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.DoctorDao;
import io.renren.modules.hospital.entity.DoctorEntity;
import io.renren.modules.hospital.service.DoctorService;


@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, DoctorEntity> implements DoctorService {
    @Autowired
    DeptService deptService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DoctorEntity> page = this.page(
                new Query<DoctorEntity>().getPage(params),
                new QueryWrapper<DoctorEntity>()
        );
        List<DoctorEntity> collect = page.getRecords().stream().map(obj -> {
            if(obj.getSex()==0)
                obj.setSexhy("女");
            else
                obj.setSexhy("男");
            DeptEntity deptEntity = deptService.getById(obj.getDepartment());
            obj.setDeptEntity(deptEntity);
            return obj;
        }).collect(Collectors.toList());

        page.setRecords(collect);
        return new PageUtils(page);
    }
/*    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        List<UsersEntity> collect = page.getRecords().stream().map(obj -> {
            RoleEntity byId = roleService.getById(obj.getRoleid());
            obj.setRole(byId);
            return obj ;
        }).collect(Collectors.toList());
        page.setRecords(collect);


        return new PageUtils(page);
    }*/

}