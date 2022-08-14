
package com.fcc.springbootweb01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class Login {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/sql")
    @ResponseBody
    public String sql(Model model){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
        System.out.println(integer);
//        model.addAttribute("num",integer);
        return integer+"";
    }

    @RequestMapping("dropSql")
    @ResponseBody
    public String sql2(){
        jdbcTemplate.execute("drop table users");
        return "drop ok";
    }

    @RequestMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String main(@RequestParam("username")String username , @RequestParam("password")String password, HttpSession httpSession){
        httpSession.setAttribute("username",username);
        httpSession.setAttribute("password",password);
//        System.out.println("username:"+username);
        return "redirect:/main3";
    }

    @RequestMapping(value = "/main3")
    public String main3(HttpSession session){
//        if(session.getAttribute("username")==null || "".equals(session.getAttribute("username"))
//            || "".equals(session.getAttribute("password"))
//        ){
//            return "/login";
//        }else{
//            return "main";
//        }
        return "main";
    }

    @RequestMapping(value = "/testGit")
    @ResponseBody
    public String testGit(){
        System.out.println("testGit");
        System.out.println("master添加了一行！");
        System.out.println("branch2 添加一行！");
        System.out.println("这里又进行了修改要重新push");
        return "testGit";
    }

}
