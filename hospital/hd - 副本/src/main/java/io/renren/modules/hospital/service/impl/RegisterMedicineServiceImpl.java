package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.RegisterMedicineDao;
import io.renren.modules.hospital.entity.RegisterMedicineEntity;
import io.renren.modules.hospital.service.RegisterMedicineService;


@Service("registerMedicineService")
public class RegisterMedicineServiceImpl extends ServiceImpl<RegisterMedicineDao, RegisterMedicineEntity> implements RegisterMedicineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RegisterMedicineEntity> page = this.page(
                new Query<RegisterMedicineEntity>().getPage(params),
                new QueryWrapper<RegisterMedicineEntity>()
        );

        return new PageUtils(page);
    }

}