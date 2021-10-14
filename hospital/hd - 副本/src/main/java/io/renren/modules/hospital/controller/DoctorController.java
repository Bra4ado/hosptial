package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.DoctorEntity;
import io.renren.modules.hospital.service.DoctorService;
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
@RequestMapping("hospital/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:doctor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = doctorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{did}")
    //@RequiresPermissions("hospital:doctor:info")
    public R info(@PathVariable("did") Integer did){
		DoctorEntity doctor = doctorService.getById(did);

        return R.ok().put("doctor", doctor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:doctor:save")
    public R save(@RequestBody DoctorEntity doctor){
		doctorService.save(doctor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:doctor:update")
    public R update(@RequestBody DoctorEntity doctor){
		doctorService.updateById(doctor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:doctor:delete")
    public R delete(@RequestBody Integer[] dids){
		doctorService.removeByIds(Arrays.asList(dids));

        return R.ok();
    }

}
