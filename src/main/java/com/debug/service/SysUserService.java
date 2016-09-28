package com.debug.service;

import com.debug.model.SysUser;

/**
 * Created by chenhao on 2016/9/21 0021.
 */
public interface SysUserService extends BaseService<SysUser> {
    String saveOrUpdate(SysUser sysUser);
    String deleteSysUser(SysUser sysUser);
}
