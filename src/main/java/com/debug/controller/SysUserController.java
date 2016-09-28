package com.debug.controller;

import com.debug.model.SysUser;
import com.debug.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenhao on 2016/9/21 0021.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/editSysUser.do")
    public String editSysUser(String id, ModelMap map) {
        if (StringUtils.isNotEmpty(id)) {
            SysUser sysUser = sysUserService.findByPrimaryKey(id);
            map.put("sysUser", sysUser);
        }
        return "/editSysUser";
    }

    @RequestMapping("/saveOrUpdate.do")
    @ResponseBody
    public String saveOrUpdate(SysUser sysUser) {
        String result = sysUserService.saveOrUpdate(sysUser);
        return result;
    }
    @RequestMapping("/deleteSysUser.do")
    @ResponseBody
    public String deleteSysUser(SysUser sysUser) {
        String result = sysUserService.deleteSysUser(sysUser);
        return result;
    }
}
