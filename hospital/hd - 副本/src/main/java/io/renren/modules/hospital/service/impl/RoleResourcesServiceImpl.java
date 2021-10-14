package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.RoleResourcesDao;
import io.renren.modules.hospital.entity.RoleResourcesEntity;
import io.renren.modules.hospital.service.RoleResourcesService;


@Service("roleResourcesService")
public class RoleResourcesServiceImpl extends ServiceImpl<RoleResourcesDao, RoleResourcesEntity> implements RoleResourcesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoleResourcesEntity> page = this.page(
                new Query<RoleResourcesEntity>().getPage(params),
                new QueryWrapper<RoleResourcesEntity>()
        );

        return new PageUtils(page);
    }

}