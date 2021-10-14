package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.DeptEntity;
import io.renren.modules.hospital.service.DeptService;
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
@RequestMapping("hospital/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:dept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{deptid}")
    //@RequiresPermissions("hospital:dept:info")
    public R info(@PathVariable("deptid") Integer deptid){
		DeptEntity dept = deptService.getById(deptid);

        return R.ok().put("dept", dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:dept:save")
    public R save(@RequestBody DeptEntity dept){
		deptService.save(dept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:dept:update")
    public R update(@RequestBody DeptEntity dept){
		deptService.updateById(dept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:dept:delete")
    public R delete(@RequestBody Integer[] deptids){
		deptService.removeByIds(Arrays.asList(deptids));

        return R.ok();
    }

}
