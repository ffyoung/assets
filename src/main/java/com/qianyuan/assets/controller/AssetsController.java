package com.qianyuan.assets.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }

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
     * 添加资产页面跳转
     *
     * @return
     */
    @RequestMapping("addAssetsIndex")
    public String addAssetsIndex() {
        return "asset/insertAssets";
    }

    /**
     * 资产添加执行
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

    /**
     * 入库时间查询
     * @param model
     * @param starttime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "findByStore",method = RequestMethod.POST)
    public String findByStore(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){

        List<Assets> list = assetsService.selectBystorageDate(starttime,endtime);
        model.addAttribute("assetslist",list);
        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }

    /**
     * 购置时间查询
     * @param model
     * @param starttime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "findByBuy",method = RequestMethod.POST)
    public String findByBuy(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){
        List<Assets> list = assetsService.selectBybuyDate(starttime,endtime);
        model.addAttribute("assetslist",list);
        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }

    /**
     * 出库时间查询
     * @param model
     * @param starttime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "findByOut",method = RequestMethod.POST)
    public String findByOut(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){
        List<Assets> list = assetsService.selectByoutDate(starttime,endtime);
        model.addAttribute("assetslist",list);
        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }


}
