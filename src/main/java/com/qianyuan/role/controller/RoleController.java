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
     * 角色列表跳转页面
     * @return
     */
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public String index(Model model, @RequestParam("pageNow") int pageNow){
        PageInfo<Role> list = roleService.findWithPage(pageNow,10);
        int totalPage = (int)Math.ceil((float)list.getTotal()/10);
        model.addAttribute("roles",list.getList());
        model.addAttribute("totalPage",totalPage>0?totalPage:1);
        model.addAttribute("results",true);
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
     * 根据角色名称或者类型进行查询
     * @param model
     * @param findContent
     * @return
     */
    @RequestMapping(value = "findbyRoleNOT",method = RequestMethod.POST)
    public String findbyRoleNOT(Model model,
                                @RequestParam(value = "findContent",required = false)
                                        String findContent){
        model.addAttribute("results",false);
        List<Role> roles = new ArrayList<>();
        try {
            Role role = roleService.findbyRoleNOT(findContent);
            if(null != role){
                roles.add(role);
                model.addAttribute("results",true);
            }
        }catch (Exception e){
            model.addAttribute("results",false);
        }
        model.addAttribute("roles",roles);
        model.addAttribute("totalPage",-1);
        return "role/roleList";
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
    @RequestMapping(value = "assign",method = RequestMethod.GET)
    public String assJump(Model model,@RequestParam("pageNow") int pageNow){
        PageInfo<UserRoleAssignBo> list = userService.findUserAndRole(pageNow,10);
        int totalPage = (int)Math.ceil((float)list.getTotal()/10);
        model.addAttribute("ulist",list.getList());
        model.addAttribute("totalPage",totalPage>0?totalPage:1);
        model.addAttribute("results",true);
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
