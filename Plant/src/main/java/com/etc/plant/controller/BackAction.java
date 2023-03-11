package com.etc.plant.controller;

import com.etc.plant.entity.*;
import com.etc.plant.service.BackService;
import com.etc.plant.service.CommentService;
import com.etc.plant.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 后台控制层
 * @author lz
 */
@Controller
public class BackAction {
    @Autowired
    BackService backService;

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserServlet")
    public String getUserServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<User> users = backService.getUser();
        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            int rid = users.get(i).getRole_id();
            Role role = backService.getRoleById(rid);
            roles.add(role);
            session.setAttribute("roles", roles);
        }
        if (users != null) {
            session.setAttribute("userList", users);
            return "book.jsp";
        }
        return "error.jsp";
    }

    /**
     * 获取角色信息
     * @param request
     * @return
     */
    @RequestMapping("/getRoleServlet")
    public String getRoleServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Role> roles = backService.getRole();
        if (roles != null) {
            session.setAttribute("roles", roles);
            return "column.jsp";
        }
        return "error.jsp";
    }

    /**
     * 获取商品信息
     * @param request
     * @return
     */
    @RequestMapping("/getPlantsServlet")
    public String getPlantsServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Plants> plants = backService.getPlants();
        if (plants != null) {
            session.setAttribute("plantM", plants);
            return "list.jsp";
        }
        return "error.jsp";
    }

    /**
     * 获取留言信息
     * @param request
     * @return
     */
    @RequestMapping("/getMessageServlet")
    public String getMessageServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Message> messages = backService.getMessage();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            int uid = messages.get(i).getUser_id();
            User user = backService.getUserById(uid);
            users.add(user);
        }
        if (messages != null) {
            session.setAttribute("message",messages);
            session.setAttribute("u", users);
            return "message.jsp";
        }
        return "error.jsp";
    }

    /**
     * 获取商品评论
     * @param request
     * @return
     */
    @RequestMapping("/getPlantsComment")
    public String getPlantsComment(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Comment> comments = backService.getComment();
        List<User> users = new ArrayList<>();
        List<Plants> plants = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            int uid = comments.get(i).getUser_id();
            int pid = comments.get(i).getPlant_id();
            User user = backService.getUserById(uid);
            Plants plant = backService.getPlantById(pid);
            users.add(user);
            plants.add(plant);
        }
        session.setAttribute("comments", comments);
        session.setAttribute("u1", users);
        session.setAttribute("p1", plants);
        return "comment.jsp";
    }

    /**
     * 删除用户信息
     * @param request
     * @return
     */
    @RequestMapping("/deleteUserServlet")
    public String deleteUserServlet(HttpServletRequest request){
        String uid = request.getParameter("uid");
        int id = 0;
        if (uid != null) {
            id = Integer.parseInt(uid);
        }
        int no = backService.deleteUser(id);
        if (no > 0 ) {
            return "forward:getUserServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 删除留言信息
     * @param request
     * @return
     */
    @RequestMapping("/deleteMessageServlet")
    public String deleteMessageServlet(HttpServletRequest request){
        String id = request.getParameter("mid");
        int mid = 0;
        if (id != null) {
            mid = Integer.parseInt(id);
        }
        int no = backService.deleteMessage(mid);
        if (no > 0) {
            return "forward:getMessageServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 删除角色信息
     * @param request
     * @return
     */
    @RequestMapping("/deleteRoleServlet")
    public String deleteRoleServlet(HttpServletRequest request){
        String id = request.getParameter("rid");
        int rid = 0;
        if (id != null) {
            rid = Integer.parseInt(id);
        }
        int no = backService.deleteRole(rid);
        if (no > 0) {
            return "forward:getRoleServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 删除商品信息
     * @param request
     * @return
     */
    @RequestMapping("/deletePlantServlet")
    public String deletePlantServlet(HttpServletRequest request){
        String id = request.getParameter("pid");
        int pid = 0 ;
        if (id != null) {
            pid = Integer.parseInt(id);
        }
        int no = backService.deletePlant(pid);
        if (no > 0 ) {
            return "forward:getPlantsServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 删除商品评论
     * @param request
     * @return
     */
    @RequestMapping("/deleteCommentServlet")
    public String deleteCommentServlet(HttpServletRequest request){
        String id = request.getParameter("cid");
        int cid = 0 ;
        if (id != null) {
            cid = Integer.parseInt(id);
        }
        int no = backService.deleteComment(cid);
        if (no > 0 ) {
            return "forward:getPlantsComment.do";
        }
        return "error.jsp";
    }

    /**
     * 修改角色信息
     * @param request
     * @param response
     */
    @RequestMapping("/updateRoleServlet")
    public void updateRoleServlet(HttpServletRequest request, HttpServletResponse response){
        String rname = request.getParameter("name");
        String id = request.getParameter("rid");
        int rid = 0;
        if (id != null){
            rid = Integer.parseInt(id);
        }
        int no = backService.updateRole(rid, rname);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (no > 0){
            out.print("1");
        } else {
            out.print("0");
        }
    }

    /**
     * 修改商品信息
     * @param request
     * @param response
     */
    @RequestMapping("/updatePlantStateServlet")
    public void updatePlantStateServlet(HttpServletRequest request, HttpServletResponse response){
        String state = request.getParameter("state");
        String id = request.getParameter("pid");
        int st = 0;
        if (state != null) {
            st = Integer.parseInt(state);
        }
        int pid = 0;
        if (id != null){
            pid = Integer.parseInt(id);
        }
        int no = backService.updatePlantState(pid, st);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (no > 0){
            out.print("1");
        } else {
            out.print("0");
        }
    }


    /**
     * 移动商品分类
     * @param request
     * @return
     */
    @RequestMapping("/romoveServlet")
    public String romoveServlet(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] ids = request.getParameterValues("id[]");
        String remove = request.getParameter("movecid");
        int pid = 0;
        int no = 0;
        for (String id:ids
        ) {
            pid = Integer.parseInt(id);
            no = backService.updatePlants(pid,remove);
        }
        if (no > 0) {
            return "forward:getPlantsServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 商品排序
     * @param request
     * @return
     */
    @RequestMapping("/sortServlet")
    public String sortServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sort = request.getParameter("sort");
        List<Plants> plants = backService.sortPlant(sort);
        if (plants != null) {
            session.setAttribute("sortPl", plants);
            return "sort.jsp";
        }
        return "error.jsp";
    }

    /**
     * 上传角色信息
     * @param request
     * @return
     */
    @RequestMapping("/addRoleServlet")
    public String addRoleServlet(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String rname = request.getParameter("rname");
        int no = backService.addRole(rname);
        if (no > 0) {
            return "forward:getRoleServlet.do";
        }
        return "error.jsp";
    }

    /**
     * 上传商品信息
     * @param request
     * @param response
     * @param pic
     * @return
     * @throws IOException
     */
    @RequestMapping("/addPlantServlet")
    public String addPlantServlet(HttpServletRequest request, HttpServletResponse response, @RequestParam("pic") MultipartFile pic) throws IOException {
        pic.transferTo(new java.io.File("E:\\idea-Code\\icss_etc_project\\Plant\\src\\main\\webapp\\images\\" + pic.getOriginalFilename()));
        String fpic = "";
        if (pic != null) {
            fpic = "images/" + pic.getOriginalFilename();
        }
//        创建request对象进行页面数据获取
        String pname = request.getParameter("pname");
        String sign = request.getParameter("sign");
        String coun = request.getParameter("pcoun");
        String price = request.getParameter("pprice");
        String comment = request.getParameter("content");
        int pcoun = 0;
        if (coun != null) {
            pcoun = Integer.parseInt(coun);
        }
        double pprice = 0;
        if (price != null) {
            pprice = Double.parseDouble(price);
        }
        Plants plant = new Plants();
        plant.setSign(sign);
        plant.setCount(pcoun);
        plant.setPlant_name(pname);
        plant.setPrice(pprice);
        plant.setComment(comment);
        plant.setPic(fpic);
        backService.upload(plant);
        return "add.jsp";
    }

}
