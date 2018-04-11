package com.qianyuan.assets.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *   前后端交互入口
 *   - - - - - - - - - - -
 *   |    By   R o c k   |
 *   - - - - - - - - - - -
 * Created by rock on 2018-04-01
 */
@Controller
@RequestMapping("asset")
public class AssetsController extends CommonController {

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
        return "asset/assetList";
    }

    /**
     * 权限添加执行
     *
     * @param assets
     * @return
     */
    @RequestMapping("addAssets")
    @ResponseBody
    public Map<String, Object> addAssetsDo(Assets assets) {
        resultMap.put("status", 400);
        int temp = assetsService.addAssets(assets);
        if (temp > 0) {
            resultMap.put("status", 200);
            resultMap.put("message", "添加成功");
        } else {
            resultMap.put("message", "添加失败");
        }
        return resultMap;
    }

}
