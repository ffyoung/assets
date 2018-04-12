package com.qianyuan.role.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Role;
import com.qianyuan.role.bo.RoleBo;
import com.qianyuan.role.bo.UserRoleAssignBo;
import com.qianyuan.role.service.RoleService;
import com.qianyuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-02
 */
@Controller
@RequestMapping("role")
public class RoleController extends CommonController{



    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping(value = "all")
    public String findAll(Model model, @RequestParam(value = "pageNow", required = false) Integer pageNow,
                          @RequestParam(value = "content", required = false) String content) {
        model.addAttribute("results", false);
        PageInfo<Role> list = roleService.findWithPage(pageNow, 10, content);
        if (list.getList().size() >= 1) {
            model.addAttribute("results", true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("rolelist", list.getList());
        model.addAttribute("totalPage", totalPage);
        pageNow = pageNow == null ? 1 : pageNow;
        model.addAttribute("currentPage", pageNow);
        model.addAttribute("content", content);
        return "role/roleList";
    }



    /**
     * 角色添加页面跳转
     * @return
     */
    @RequestMapping("addRoleIndex")
    public String addRoleIndex(){
        return "role/addRole";
    }

    /**
     * 角色添加执行
     * @param role
     * @return
     */
    @RequestMapping("addRole")
    @ResponseBody
    public Map<String,Object> addRoleDo(Role role){
        resultMap.put("status",400);
        int temp = roleService.addRole(role);
        if(temp > 0){
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
        }else {
            resultMap.put("message","添加失败");
        }
        return resultMap;
    }


    /**
     * 修改角色信息页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "updateDo/{id}",method = RequestMethod.GET)
    public String updateMsg(@PathVariable Long id, Model model){
        Role roles = roleService.findById(id);
        model.addAttribute("roles",roles);
        return "role/updateRole";
    }

    /**
     * 修改角色信息
     * @return
     */
    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateRole(Role role){
        resultMap.put("status", 400);
        int result = roleService.updateByRoleInfo(role);
        if(result <= 0){
            resultMap.put("message","信息修改失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }


    /**
     * 角色信息删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteId(@PathVariable Long id){
        resultMap.put("status", 400);
        int result = roleService.deleteById(id);
        if(result <= 0){
            resultMap.put("message","删除操作失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }



    /**
     * 角色分配页面跳转
     * @return
     */
    @RequestMapping(value = "assign")
    public String assJump(Model model, @RequestParam(value = "pageNow", required = false) Integer pageNow,
                          @RequestParam(value = "content", required = false) String content) {
        model.addAttribute("results", false);
        PageInfo<UserRoleAssignBo> list = userService.findUserAndRole(pageNow, 10, content);
        if (list.getList().size() >= 1) {
            model.addAttribute("results", true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("urlist", list.getList());
        model.addAttribute("totalPage", totalPage);
        pageNow = pageNow == null ? 1 : pageNow;
        model.addAttribute("currentPage", pageNow);
        model.addAttribute("content", content);
        return "role/rolesAssign";
    }

    /**
     * 根据用户ID查询权限
     * @param id
     * @return
     */
    @RequestMapping(value="selectRoleByUserId")
    @ResponseBody
    public List<RoleBo> selectRoleByUserId(Long id){
        List<RoleBo> roleBos = userService.selectRoleByUserId(id);
        return roleBos;
    }


    @RequestMapping(value="addRole2User")
    @ResponseBody
    public Map<String,Object> addRole2User(Long userId,String ids){
        return userService.addRole2User(userId,ids);
    }


}
