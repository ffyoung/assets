package com.qianyuan.assets.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Assets;
import com.qianyuan.common.domain.Role;
import com.qianyuan.core.shiro.token.ShiroToken;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
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
    public String addAssetsIndex(Model model) {
        Date dateNow = new Date();
        model.addAttribute("dateNow",dateNow);
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
        resultMap.put("message", "添加失败");
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        //录入人信息
        String person = assets.getInputMessage();
        if(person != null && person.trim().length()>0){
            if(username.equals(person)){
                int temp = assetsService.addAssets(assets);
                if (temp > 0) {
                    resultMap.put("status", 200);
                    resultMap.put("message", "添加成功");
                }
            }
        }
        return resultMap;
    }

    /**
     * 入库时间查询
     * @param model
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping(value = "findByStore",method = RequestMethod.POST)
    public String findByStore(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){

        if(starttime != null && endtime != null){
            List<Assets> list = assetsService.selectBystorageDate(starttime,endtime);
            model.addAttribute("assetslist",list);
        }else {
            return "config/error";
        }

        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }

    /**
     * 购置时间查询
     * @param model
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping(value = "findByBuy",method = RequestMethod.POST)
    public String findByBuy(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){
        if(starttime != null && endtime != null){
            List<Assets> list = assetsService.selectBybuyDate(starttime,endtime);
            model.addAttribute("assetslist",list);
        }else {
            return "config/error";
        }
        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }

    /**
     * 出库时间查询
     * @param model
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping(value = "findByOut",method = RequestMethod.POST)
    public String findByOut(Model model, @RequestParam("starttime")java.sql.Date starttime,
                              @RequestParam("endtime")java.sql.Date endtime){
        if(starttime != null && endtime != null){
            List<Assets> list = assetsService.selectByoutDate(starttime,endtime);
            model.addAttribute("assetslist",list);
        }else {
            return "config/error";
        }
        model.addAttribute("totalPage",1);
        model.addAttribute("currentPage",1);
        return "asset/assetList";
    }

    @RequestMapping(value = "depart")
    public String selectAssetByDepartName(Model model, @RequestParam(value = "pageNow", required = false) Integer pageNow,
                                          @RequestParam(value = "findContent", required = false) String findContent,
                                          @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("results", false);
        PageInfo<Assets> list = assetsService.selectAssetByDepartName(pageNow, 10, findContent, name);
        if (list.getList().size() >= 1) {
            model.addAttribute("results", true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("departassetlist", list.getList());
        model.addAttribute("totalPage", totalPage);
        pageNow = pageNow == null ? 1 : pageNow;
        model.addAttribute("currentPage", pageNow);
        model.addAttribute("name", name);
        model.addAttribute("findContent", findContent);
        return "asset/asset";
    }

    /**
     * 审核页面跳转
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "updateShenheIndex/{id}",method = RequestMethod.POST)
    public String shenhe(Model model,@PathVariable("id") Long id){
        Assets assets = assetsService.findAssetById(id);
        model.addAttribute("assets",assets);
        return "asset/shenhe_page";
    }


    /**
     * 修改信息页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "updateDo/{id}",method = RequestMethod.GET)
    public String updateDo(@PathVariable Long id, Model model){
        Assets assets = assetsService.findAssetById(id);
        Date dateNow = new Date();
        model.addAttribute("assets",assets);
        model.addAttribute("dateNow",dateNow);
        return "asset/shenhe_page";
    }


    @RequestMapping(value = "pizhunDo/{id}", method = RequestMethod.GET)
    public String pizhunDo(@PathVariable Long id, Model model) {
        Assets assets = assetsService.findAssetById(id);
        Date dateNow = new Date();
        model.addAttribute("assets", assets);
        model.addAttribute("dateNow", dateNow);
        return "asset/assignList";
    }






    /**
     * 修改执行
     * @param assets
     * @return
     */
    @RequestMapping("updateMsg")
    @ResponseBody
    public Map<String, Object> updateMsg(Assets assets) {

        resultMap.put("status", 400);
        resultMap.put("message", "添加失败");
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        String auditor = assets.getAuditor();
        if( auditor != null && auditor.trim().length() > 0){
            if(username.equals(auditor) ){
                int temp = assetsService.updateAssets(assets);
                if (temp > 0) {
                    resultMap.put("status", 200);
                    resultMap.put("message", "添加成功");
                }
            }

        }
        return resultMap;
    }


    /**
     * 分配产品到部门
     *
     * @param assets
     * @return
     */
    @RequestMapping("assignAssetToDepart")
    @ResponseBody
    public Map<String, Object> assignAssetToDepart(Assets assets,
                                                   @RequestParam("departId") Long departId) {

        resultMap.put("status", 400);
        resultMap.put("message", "分配失败");
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        String authorizer = assets.getAuthorizer();
        if (authorizer != null && authorizer.trim().length() > 0) {
            if (username.equals(authorizer)) {
                int temp = assetsService.updateAssets(assets);
                if (temp > 0) {
                    return assetsService.addAsset2Depart(assets.getId(), departId);
                }
            }
        }
        return resultMap;
    }




}
