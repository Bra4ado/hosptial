package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.HospitalizationEntity;
import io.renren.modules.hospital.service.HospitalizationService;
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
@RequestMapping("hospital/hospitalization")
public class HospitalizationController {
    @Autowired
    private HospitalizationService hospitalizationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:hospitalization:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hospitalizationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{hid}")
    //@RequiresPermissions("hospital:hospitalization:info")
    public R info(@PathVariable("hid") Integer hid){
		HospitalizationEntity hospitalization = hospitalizationService.getById(hid);

        return R.ok().put("hospitalization", hospitalization);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:hospitalization:save")
    public R save(@RequestBody HospitalizationEntity hospitalization){
		hospitalizationService.save(hospitalization);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:hospitalization:update")
    public R update(@RequestBody HospitalizationEntity hospitalization){
		hospitalizationService.updateById(hospitalization);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:hospitalization:delete")
    public R delete(@RequestBody Integer[] hids){
		hospitalizationService.removeByIds(Arrays.asList(hids));

        return R.ok();
    }

}
