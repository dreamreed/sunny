package com.debug.service;

import com.debug.model.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by chenhao on 2016/9/21 0021.
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Override
    public String saveOrUpdate(SysUser sysUser) {
        String result = null;
        try {
            if (StringUtils.isNotEmpty(sysUser.getId())) {
                //修改
                sysUser.setUsername(sysUser.getUsername());
                sysUser.setPassword(sysUser.getPassword());
                sysUser.setIsEnable(sysUser.getIsEnable());
                sysUser.setIsDel(sysUser.getIsDel());
                result = this.update(sysUser);
            } else {
                SysUser s = new SysUser();
                s.setUsername(sysUser.getUsername());
                s.setPassword(sysUser.getPassword());
                sysUser.setIsEnable(sysUser.getIsEnable());
                s.setIsDel(false);
                result = this.save(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    @Override
    public String deleteSysUser(SysUser sysUser) {
        String result = null;
        //修改
        SysUser s=this.findByPrimaryKey(sysUser.getId());
        s.setIsDel(true);
        result = this.update(s);
        return result;
    }
}
