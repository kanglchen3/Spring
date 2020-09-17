package com.kangle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kangle.domain.User;
import com.kangle.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/tt", method= RequestMethod.GET, params = {"username"})
    public String save(){
        System.out.println("Controller save running...");
//        return "success";   //能用prefix suffix
        return "redirect:/success.jsp";
    }

    @RequestMapping(value="/tt2")
    public ModelAndView save2(){
        System.out.println("Controller save2 running...");
//        model：模型 封装数据
//        view：视图 展示数据
        ModelAndView modelAndView = new ModelAndView();
//        设置模型数据
        modelAndView.addObject("username","itecast");
//        设置视图
        modelAndView.setViewName("success");
        return  modelAndView;
    }

    @RequestMapping("/tt3")
    public ModelAndView save3(ModelAndView modelAndView){ //这里的形参modelAndView，springMVC框架在调用save3的时候自动填入实参
        System.out.println("Controller save3 running...");
        modelAndView.addObject("username", "yoyo");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/tt4")
    public String save4(Model model){ //这里的形参model，springMVC框架在调用save4的时候自动填入实参
        System.out.println("Controller save4 running...");
        model.addAttribute("username", "Model username");
        return "success";
    }

    @RequestMapping("/tt5")
    public String save5(HttpServletRequest req){ //道理同上，框架能自动填req对象，但此方法不常用
        req.setAttribute("username", "Req username");
        return "success";
    }

    @RequestMapping("/tt6")
    public void save6(HttpServletResponse res) throws IOException { //道理同上，框架能自动填req对象，但此方法不常用
        res.getWriter().println("my response");
    }

    @RequestMapping("/tt7")
    @ResponseBody  //告诉框架，返回的不是view的路径，不要进行跳转 而是返回在response body里面的字符串
    public String save7() throws IOException { //道理同上，框架能自动填req对象，但此方法不常用
        return "my response";
    }

    @RequestMapping("/tt8")
    @ResponseBody
    public String save8() throws IOException {
        return "{‘username':'111','age':18}}";  //返回json字符串
    }

    @RequestMapping("/tt9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);
//        使用json转换工具
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return "{‘username':'111','age':18}}";  //返回json字符串
    }

    @RequestMapping("/tt10")
    @ResponseBody
    //期望springMVC自动把User转换成json字符串
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);
        return user;
    }

    @RequestMapping("/tt11")
    @ResponseBody
    //自动匹配请求里的相同名字的参数
    public void save11(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/tt12")
    @ResponseBody
    //自动把请求中的参数和POJO形参中的属性进行匹配，本质是调用了POJO的setter方法
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    @RequestMapping("/tt13")
    @ResponseBody
    //请求为 ...?strs=aaa&strs=bbb&strs=ccc
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/tt14")
    @ResponseBody
    //如果请求的参数的是集合，则要封装到一个POJO中返回
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping("/tt15")
    @ResponseBody
    //如果请求的参数的是集合，也可以通过@RequestBody 直接将集合入参
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping("/tt18")
    @ResponseBody
//    通过自定义的转换器converter转换我们自定义的日期格式 2020-12-01
    public void save18(Date date) throws IOException{
        System.out.println(date);
    }

    @RequestMapping("/tt19")
    @ResponseBody
//    获得servlet相关api。其实就是request和response
    public void save19(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException{
        System.out.println(req);
//        HttpSession session = req.getSession(); //也可以这么拿
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext.getAttributeNames());
        System.out.println(servletContext);
        System.out.println(res);
    }

    @RequestMapping("/tt20")
    @ResponseBody
//    使用requestHeader可以获得请求头信息，相当于web中的req.getHeader(name), 参数有两个，value，required
//    method, content-type, accept-language， user-agent都是请求头的attribute
    public void save20(@RequestHeader(value = "User-Agent", required = false) String headerValue){
        System.out.println(headerValue);
    }

    @RequestMapping("/tt21")
    @ResponseBody
//    @CookieValue 虽然说cookie也是一种请求头，但是因为比较特殊，cookie内部还有不同的value，所以有个注解可以直接拿某个value的cookie，参数也是value，required
    public void save21(@CookieValue(value = "JSESSIONID", required = false) String jsessionId){
        System.out.println(jsessionId);
    }
}
