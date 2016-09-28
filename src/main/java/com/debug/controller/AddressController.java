package com.debug.controller;

import com.debug.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenhao on 2016/9/20 0020.
 */
@Controller
@RequestMapping("/address")
public class AddressController  extends BaseController{

    @Autowired
    private AddressService addressService;
    @RequestMapping("/list.do")
    public String list(Model model)
    {
//        model.addAttribute("list", addressService.queryAddressForList());
        model.addAttribute("list", addressService.queryAddressForList());
       return  "/index";
    }
}
