package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.HospitalizationDao;
import io.renren.modules.hospital.entity.HospitalizationEntity;
import io.renren.modules.hospital.service.HospitalizationService;


@Service("hospitalizationService")
public class HospitalizationServiceImpl extends ServiceImpl<HospitalizationDao, HospitalizationEntity> implements HospitalizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HospitalizationEntity> page = this.page(
                new Query<HospitalizationEntity>().getPage(params),
                new QueryWrapper<HospitalizationEntity>()
        );

        return new PageUtils(page);
    }

}