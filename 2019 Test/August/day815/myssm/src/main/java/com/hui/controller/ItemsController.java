package com.hui.controller;

import com.hui.po.ItemsCustom;
import com.hui.po.ItemsVO;
import com.hui.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = )
    public ModelAndView queryItemList(HttpServletResponse response, ItemsVO itemsVO)throws Exception{
        response.setContentType("text/html;charset=utf-8");

        List<ItemsCustom> itemsCustoms = itemss
    }
}
