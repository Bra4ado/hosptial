package io.renren.modules.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hospital.entity.UsersEntity;
import io.renren.modules.hospital.service.UsersService;
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
@RequestMapping("hospital/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hospital:users:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.queryPage(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/listWithName")
    //@RequiresPermissions("hospital:users:list")
    public R listWithName(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.listWithName(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userid}")
    //@RequiresPermissions("hospital:users:info")
    public R info(@PathVariable("userid") Integer userid){
		UsersEntity users = usersService.getById(userid);

        return R.ok().put("users", users);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hospital:users:save")
    public R save(@RequestBody UsersEntity users){
		usersService.save(users);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hospital:users:update")
    public R update(@RequestBody UsersEntity users){
		usersService.updateById(users);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hospital:users:delete")
    public R delete(@RequestBody Integer[] userids){
		usersService.removeByIds(Arrays.asList(userids));

        return R.ok();
    }



}
