package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.ChargeRegisterEntity;
import io.renren.modules.hospital.service.ChargeRegisterService;
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
@RequestMapping("hospital/chargeregister")
public class ChargeRegisterController {
    @Autowired
    private ChargeRegisterService chargeRegisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:chargeregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chargeRegisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{crId}")
    //@RequiresPermissions("hospital:chargeregister:info")
    public R info(@PathVariable("crId") Integer crId){
		ChargeRegisterEntity chargeRegister = chargeRegisterService.getById(crId);

        return R.ok().put("chargeRegister", chargeRegister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:chargeregister:save")
    public R save(@RequestBody ChargeRegisterEntity chargeRegister){
		chargeRegisterService.save(chargeRegister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:chargeregister:update")
    public R update(@RequestBody ChargeRegisterEntity chargeRegister){
		chargeRegisterService.updateById(chargeRegister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:chargeregister:delete")
    public R delete(@RequestBody Integer[] crIds){
		chargeRegisterService.removeByIds(Arrays.asList(crIds));

        return R.ok();
    }

}
