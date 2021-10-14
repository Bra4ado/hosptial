package io.renren.modules.hospital.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.hospital.entity.RoleEntity;
import io.renren.modules.hospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.UsersDao;
import io.renren.modules.hospital.entity.UsersEntity;
import io.renren.modules.hospital.service.UsersService;


@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

    @Autowired
    RoleService roleService;

    @Override
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
    }

    @Override
    public PageUtils listWithName(Map<String, Object> params) {
        List<UsersEntity> doctorAndDepartment = this.baseMapper.findDoctorAndDepartment();
        IPage<UsersEntity> page =new Page<>();
        page.setRecords(doctorAndDepartment);
        return new PageUtils(page);
    }


}