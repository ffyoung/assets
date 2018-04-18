package com.qianyuan.product.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.domain.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-18
 */
@Controller
@RequestMapping("product")
public class ProductController {


    @Autowired
    private AssetsService assetsService;
    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping(value = "all")
    public String findAll(Model model, @RequestParam(value = "pageNow",required = false) Integer pageNow,
                          @RequestParam(value = "findContent",required = false) String findContent){
        model.addAttribute("results",false);
        PageInfo<Assets> list = assetsService.findWithPage(pageNow,10,findContent);
        if(list.getList().size() >= 1){
            model.addAttribute("results",true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("assetslist",list.getList());
        model.addAttribute("totalPage",totalPage);
        pageNow = pageNow == null?1:pageNow;
        model.addAttribute("currentPage",pageNow);
        model.addAttribute("findContent",findContent);
        return "product/productList";
    }

}
