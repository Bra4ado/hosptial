package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.RegisterDao;
import io.renren.modules.hospital.entity.RegisterEntity;
import io.renren.modules.hospital.service.RegisterService;


@Service("registerService")
public class RegisterServiceImpl extends ServiceImpl<RegisterDao, RegisterEntity> implements RegisterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RegisterEntity> page = this.page(
                new Query<RegisterEntity>().getPage(params),
                new QueryWrapper<RegisterEntity>()
        );

        return new PageUtils(page);
    }

}