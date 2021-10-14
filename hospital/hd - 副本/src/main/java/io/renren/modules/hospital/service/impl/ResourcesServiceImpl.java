package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.ResourcesDao;
import io.renren.modules.hospital.entity.ResourcesEntity;
import io.renren.modules.hospital.service.ResourcesService;


@Service("resourcesService")
public class ResourcesServiceImpl extends ServiceImpl<ResourcesDao, ResourcesEntity> implements ResourcesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ResourcesEntity> page = this.page(
                new Query<ResourcesEntity>().getPage(params),
                new QueryWrapper<ResourcesEntity>()
        );

        return new PageUtils(page);
    }

}