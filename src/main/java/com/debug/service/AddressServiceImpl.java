package com.debug.service;

import com.debug.mapper.AddressMapper;
import com.debug.model.Address;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhao on 2016/9/20 0020.
 */
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address>  implements  AddressService{

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public PageInfo<Address> queryAddressForList() {
        return this.queryPageForList();
    }

    @Override
    public List<Address> findAddressByMap() {
        return this.addressMapper.findAddressByMap();
    }
}
