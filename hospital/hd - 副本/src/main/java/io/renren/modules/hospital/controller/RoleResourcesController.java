package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.RoleResourcesEntity;
import io.renren.modules.hospital.service.RoleResourcesService;
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
@RequestMapping("hospital/roleresources")
public class RoleResourcesController {
    @Autowired
    private RoleResourcesService roleResourcesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:roleresources:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleResourcesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    //@RequiresPermissions("hospital:roleresources:info")
    public R info(@PathVariable("roleId") Integer roleId){
		RoleResourcesEntity roleResources = roleResourcesService.getById(roleId);

        return R.ok().put("roleResources", roleResources);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:roleresources:save")
    public R save(@RequestBody RoleResourcesEntity roleResources){
		roleResourcesService.save(roleResources);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:roleresources:update")
    public R update(@RequestBody RoleResourcesEntity roleResources){
		roleResourcesService.updateById(roleResources);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:roleresources:delete")
    public R delete(@RequestBody Integer[] roleIds){
		roleResourcesService.removeByIds(Arrays.asList(roleIds));

        return R.ok();
    }

}
