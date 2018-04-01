package com.qianyuan.assets.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.domain.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *   前后端交互入口
 *   - - - - - - - - - - -
 *   |    By   R o c k   |
 *   - - - - - - - - - - -
 * Created by rock on 2018-04-01
 */
@Controller
@RequestMapping("asset")
public class AssetsController {

    @Autowired
    private AssetsService assetsService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String findAll(Model model, @RequestParam("pageNow") Integer pageNow){
        PageInfo<Assets> list = assetsService.findWithPage(pageNow,10);
        int totalPage = (int)Math.ceil((float)list.getTotal()/10);
        model.addAttribute("assetslist",list.getList());
        model.addAttribute("totalPage",totalPage>0?totalPage:1);
        model.addAttribute("results",true);
        return "asset/assetList";
    }

    /**
     * 根据输入内容查询
     * @param model
     * @param findContent
     * @param pageNow
     * @return
     */
    @RequestMapping("findByCont")
    public String findbyCont( Model model,
                               @RequestParam(value = "findContent",required = false)  String findContent,
                               @RequestParam(value = "pageNow",required = false) Integer pageNow){
        model.addAttribute("results",false);
        PageInfo<Assets> assetsPageInfo = assetsService.findByContent(findContent,pageNow);
        if(null != assetsPageInfo) {
            model.addAttribute("assetslist", assetsPageInfo.getList());
            int totalPage = (int) Math.ceil((float) assetsPageInfo.getTotal() / 10);
            model.addAttribute("totalPage", totalPage > 0 ? totalPage : 1);
            model.addAttribute("results", true);
        }
        return "asset/assetList";
    }

}
