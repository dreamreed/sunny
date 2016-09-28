package com.debug.mapper;

import com.debug.model.Address;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by chenhao on 2016/9/20 0020.
 */
public interface AddressMapper extends Mapper<Address> {
    List<Address> findAddressByMap();
}
