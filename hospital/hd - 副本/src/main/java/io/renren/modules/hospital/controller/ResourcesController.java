package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.ResourcesEntity;
import io.renren.modules.hospital.service.ResourcesService;
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
@RequestMapping("hospital/resources")
public class ResourcesController {
    @Autowired
    private ResourcesService resourcesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:resources:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resourcesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hospital:resources:info")
    public R info(@PathVariable("id") Integer id){
		ResourcesEntity resources = resourcesService.getById(id);

        return R.ok().put("resources", resources);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:resources:save")
    public R save(@RequestBody ResourcesEntity resources){
		resourcesService.save(resources);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:resources:update")
    public R update(@RequestBody ResourcesEntity resources){
		resourcesService.updateById(resources);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:resources:delete")
    public R delete(@RequestBody Integer[] ids){
		resourcesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
