package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.RegisterEntity;
import io.renren.modules.hospital.service.RegisterService;
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
@RequestMapping("hospital/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:register:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = registerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rno}")
    //@RequiresPermissions("hospital:register:info")
    public R info(@PathVariable("rno") Integer rno){
		RegisterEntity register = registerService.getById(rno);

        return R.ok().put("register", register);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:register:save")
    public R save(@RequestBody RegisterEntity register){
		registerService.save(register);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:register:update")
    public R update(@RequestBody RegisterEntity register){
		registerService.updateById(register);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:register:delete")
    public R delete(@RequestBody Integer[] rnos){
		registerService.removeByIds(Arrays.asList(rnos));

        return R.ok();
    }

}
