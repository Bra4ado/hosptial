package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.ChargeEntity;
import io.renren.modules.hospital.service.ChargeService;
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
@RequestMapping("hospital/charge")
public class ChargeController {
    @Autowired
    private ChargeService chargeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:charge:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chargeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hospital:charge:info")
    public R info(@PathVariable("id") Integer id){
		ChargeEntity charge = chargeService.getById(id);

        return R.ok().put("charge", charge);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:charge:save")
    public R save(@RequestBody ChargeEntity charge){
		chargeService.save(charge);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:charge:update")
    public R update(@RequestBody ChargeEntity charge){
		chargeService.updateById(charge);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:charge:delete")
    public R delete(@RequestBody Integer[] ids){
		chargeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
