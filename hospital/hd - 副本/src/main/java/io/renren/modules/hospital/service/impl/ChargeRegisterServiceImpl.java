package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.ChargeRegisterDao;
import io.renren.modules.hospital.entity.ChargeRegisterEntity;
import io.renren.modules.hospital.service.ChargeRegisterService;


@Service("chargeRegisterService")
public class ChargeRegisterServiceImpl extends ServiceImpl<ChargeRegisterDao, ChargeRegisterEntity> implements ChargeRegisterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChargeRegisterEntity> page = this.page(
                new Query<ChargeRegisterEntity>().getPage(params),
                new QueryWrapper<ChargeRegisterEntity>()
        );

        return new PageUtils(page);
    }

}