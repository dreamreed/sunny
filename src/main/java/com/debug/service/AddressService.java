package com.debug.service;

import com.debug.model.Address;
import com.debug.service.BaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhao on 2016/9/20 0020.
 */
public interface AddressService extends BaseService<Address> {
    PageInfo<Address> queryAddressForList();

    List<Address> findAddressByMap();
}
