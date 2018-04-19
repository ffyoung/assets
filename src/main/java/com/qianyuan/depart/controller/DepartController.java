package com.qianyuan.depart.controller;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.Department;
import com.qianyuan.depart.bo.DepartBo;
import com.qianyuan.depart.bo.UserDepartAssign;
import com.qianyuan.depart.service.DepartService;
import com.qianyuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("depart")
public class DepartController extends CommonController {
    @Autowired
    private DepartService departService;
    @Autowired
    private UserService userService;

    /**
     * 查询所有
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "all")
    public String findAll(Model model, @RequestParam(value = "pageNow", required = false) Integer pageNow,
                          @RequestParam(value = "content", required = false) String content) {
        model.addAttribute("results", false);
        PageInfo<Department> list = departService.findWithPage(pageNow, 10, content);
        if (list.getList().size() >= 1) {
            model.addAttribute("results", true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("departlist", list.getList());
        model.addAttribute("totalPage", totalPage);
        pageNow = pageNow == null ? 1 : pageNow;
        model.addAttribute("currentPage", pageNow);
        model.addAttribute("content", content);
        return "depart/departList";
    }

    /**
     * 添加部门页面跳转
     *
     * @return
     */
    @RequestMapping("addDepartIndex")
    public String addDepartIndex() {
        return "depart/addDepart";
    }

    /**
     * 部门添加执行
     *
     * @param department
     * @return
     */
    @RequestMapping("addDepart")
    @ResponseBody
    public Map<String, Object> addDepartDo(Department department) {
        resultMap.put("status", 400);
        int temp = departService.addDepart(department);
        if (temp > 0) {
            resultMap.put("status", 200);
            resultMap.put("message", "添加成功");
        } else {
            resultMap.put("message", "添加失败");
        }
        return resultMap;
    }


    /**
     * 修改部门信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "updateDo/{id}", method = RequestMethod.GET)
    public String updateMsg(@PathVariable Long id, Model model) {
        Department department = departService.findById(id);
        model.addAttribute("department", department);
        return "depart/updateDepart";
    }

    /**
     * 修改部门信息
     *
     * @return
     */
    @RequestMapping(value = "updateDepart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePermission(Department department) {
        resultMap.put("status", 400);
        int result = departService.updateByDepartInfo(department);
        if (result <= 0) {
            resultMap.put("message", "信息修改失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }

    /**
     * 部门信息删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteId(@PathVariable Long id) {
        resultMap.put("status", 400);
        int result = departService.deleteById(id);
        if (result <= 0) {
            resultMap.put("message", "删除操作失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }

    /**
     * 部门分配页面跳转
     *
     * @return
     */
    @RequestMapping(value = "assign")
    public String assJump(Model model, @RequestParam(value = "pageNow", required = false) Integer pageNow,
                          @RequestParam(value = "content", required = false) String content) {
        model.addAttribute("results", false);
        PageInfo<UserDepartAssign> list = userService.findUserAndDepart(pageNow, 10, content);
        if (list.getList().size() >= 1) {
            model.addAttribute("results", true);
        }
        Long totalPage = list.getTotal();
        model.addAttribute("udlist", list.getList());
        model.addAttribute("totalPage", totalPage);
        pageNow = pageNow == null ? 1 : pageNow;
        model.addAttribute("currentPage", pageNow);
        model.addAttribute("content", content);
        return "depart/departAssign";
    }

    /**
     * 根据用户ID查询权限
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectDepartByUserId")
    @ResponseBody
    public List<DepartBo> selectRoleByUserId(Long id) {
        List<DepartBo> departBos = userService.selectDepartByUserId(id);
        return departBos;
    }

    @RequestMapping(value = "addDepartToUser")
    @ResponseBody
    public Map<String, Object> addDepartToUser(Long userId, String ids) {
        return userService.addDepartToUser(userId, ids);
    }

}
