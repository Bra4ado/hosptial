package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.MedicineEntity;
import io.renren.modules.hospital.service.MedicineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author zxl
 * @email 710465130@qq.com
 * @date 2021-09-26 11:17:30
 */
@RestController
@RequestMapping("hospital/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:medicine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = medicineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mid}")
    //@RequiresPermissions("hospital:medicine:info")
    public R info(@PathVariable("mid") String mid){
		MedicineEntity medicine = medicineService.getById(mid);

        return R.ok().put("medicine", medicine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:medicine:save")
    public R save(@RequestBody MedicineEntity medicine){
		medicineService.save(medicine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:medicine:update")
    public R update(@RequestBody MedicineEntity medicine){
		medicineService.updateById(medicine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:medicine:delete")
    public R delete(@RequestBody String[] mids){
		medicineService.removeByIds(Arrays.asList(mids));

        return R.ok();
    }

}
