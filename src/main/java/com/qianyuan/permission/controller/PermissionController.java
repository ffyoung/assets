package com.qianyuan.permission.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Permission;
import com.qianyuan.common.domain.Role;
import com.qianyuan.common.domain.RolePermission;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;
import com.qianyuan.permission.service.PermissionService;
import com.qianyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("permission")
public class PermissionController extends CommonController {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;

    /**
     * 权限列表跳转页面
     *
     * @return
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String index(Model model, @RequestParam("pageNow") int pageNow) {
        PageInfo<Permission> list = permissionService.findWithPage(pageNow, 10);
        int totalPage = (int) Math.ceil((float) list.getTotal() / 10);
        model.addAttribute("permissions", list.getList());
        model.addAttribute("totalPage", totalPage > 0 ? totalPage : 1);
        model.addAttribute("results", true);
        return "permission/permissionList";
    }

    /**
     * 添加权限页面跳转
     *
     * @return
     */
    @RequestMapping("addPermissionIndex")
    public String addRoleIndex() {
        return "permission/addPermission";
    }

    /**
     * 权限添加执行
     *
     * @param permission
     * @return
     */
    @RequestMapping("addPermission")
    @ResponseBody
    public Map<String, Object> addPermissionDo(Permission permission) {
        resultMap.put("status", 400);
        int temp = permissionService.addPermission(permission);
        if (temp > 0) {
            resultMap.put("status", 200);
            resultMap.put("message", "添加成功");
        } else {
            resultMap.put("message", "添加失败");
        }
        return resultMap;
    }

    /**
     * 根据权限名称或者资源进行查询
     *
     * @param model
     * @param findContent
     * @return
     */
    @RequestMapping(value = "findbyPermissionNOT", method = RequestMethod.POST)
    public String findbyPermissionNOT(Model model,
                                      @RequestParam(value = "findContent", required = false)
                                              String findContent) {
        model.addAttribute("results", false);
        List<Permission> permissions = new ArrayList<>();
        try {
            Permission permission = permissionService.findbyPermissionNOT(findContent);
            if (null != permission) {
                permissions.add(permission);
                model.addAttribute("results", true);
            }
        } catch (Exception e) {
            model.addAttribute("results", false);
        }
        model.addAttribute("permissions", permissions);
        model.addAttribute("totalPage", -1);
        return "permission/permissionList";
    }

    /**
     * 修改权限信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "updateDo/{id}", method = RequestMethod.GET)
    public String updateMsg(@PathVariable Long id, Model model) {
        Permission permission = permissionService.findById(id);
        model.addAttribute("permission", permission);
        return "permission/updatePermission";
    }

    /**
     * 修改权限信息
     *
     * @return
     */
    @RequestMapping(value = "updatePermission", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePermission(Permission permission) {
        resultMap.put("status", 400);
        int result = permissionService.updateByPermissionInfo(permission);
        if (result <= 0) {
            resultMap.put("message", "信息修改失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }

    /**
     * 权限信息删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteId(@PathVariable Long id) {
        resultMap.put("status", 400);
        int result = permissionService.deleteById(id);
        if (result <= 0) {
            resultMap.put("message", "删除操作失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }

    /**
     * 权限分配页面跳转
     *
     * @return
     */
    @RequestMapping(value = "assign", method = RequestMethod.GET)
    public String assJump(Model model, @RequestParam("pageNow") int pageNow) {
        PageInfo<RolePermissionAssignBo> list = roleService.findRoleAndPermission(pageNow, 10);
        int totalPage = (int) Math.ceil((float) list.getTotal() / 10);
        model.addAttribute("ulist", list.getList());
        model.addAttribute("totalPage", totalPage > 0 ? totalPage : 1);
        model.addAttribute("results", true);
        return "permission/permissionsAssign";
    }

    /**
     * 根据角色ID查询权限
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectPermissionByRoleId")
    @ResponseBody
    public List<PermissionBo> selectPermissionByRoleId(Long id) {
        List<PermissionBo> permissionBos = roleService.selectPermissionByRoleId(id);
        return permissionBos;
    }

}
