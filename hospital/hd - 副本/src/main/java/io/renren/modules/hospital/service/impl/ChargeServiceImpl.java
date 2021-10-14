package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.ChargeDao;
import io.renren.modules.hospital.entity.ChargeEntity;
import io.renren.modules.hospital.service.ChargeService;


@Service("chargeService")
public class ChargeServiceImpl extends ServiceImpl<ChargeDao, ChargeEntity> implements ChargeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChargeEntity> page = this.page(
                new Query<ChargeEntity>().getPage(params),
                new QueryWrapper<ChargeEntity>()
        );

        return new PageUtils(page);
    }

}