package io.renren.modules.hospital.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.hospital.dao.MedicineDao;
import io.renren.modules.hospital.entity.MedicineEntity;
import io.renren.modules.hospital.service.MedicineService;


@Service("medicineService")
public class MedicineServiceImpl extends ServiceImpl<MedicineDao, MedicineEntity> implements MedicineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MedicineEntity> page = this.page(
                new Query<MedicineEntity>().getPage(params),
                new QueryWrapper<MedicineEntity>()
        );

        return new PageUtils(page);
    }

}