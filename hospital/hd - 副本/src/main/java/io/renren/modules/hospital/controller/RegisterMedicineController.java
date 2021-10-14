package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.RegisterMedicineEntity;
import io.renren.modules.hospital.service.RegisterMedicineService;
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
@RequestMapping("hospital/registermedicine")
public class RegisterMedicineController {
    @Autowired
    private RegisterMedicineService registerMedicineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:registermedicine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = registerMedicineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mid}")
    //@RequiresPermissions("hospital:registermedicine:info")
    public R info(@PathVariable("mid") Integer mid){
		RegisterMedicineEntity registerMedicine = registerMedicineService.getById(mid);

        return R.ok().put("registerMedicine", registerMedicine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:registermedicine:save")
    public R save(@RequestBody RegisterMedicineEntity registerMedicine){
		registerMedicineService.save(registerMedicine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:registermedicine:update")
    public R update(@RequestBody RegisterMedicineEntity registerMedicine){
		registerMedicineService.updateById(registerMedicine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:registermedicine:delete")
    public R delete(@RequestBody Integer[] mids){
		registerMedicineService.removeByIds(Arrays.asList(mids));

        return R.ok();
    }

}
