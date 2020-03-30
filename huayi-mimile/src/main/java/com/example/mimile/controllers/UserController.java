package com.example.mimile.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mimile.beans.User;
import com.example.mimile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/listusers")
    public String list(String kw, Model model, Pageable pageable) {
        model.addAttribute("kw",kw);
        if(kw!=null)kw="%"+kw+"%";
        if(kw==null)kw="%%";
        Page<User> ppu = userService.findAll(kw, pageable);
        model.addAttribute("pages", ppu);
        return "listusers";
    }

    @GetMapping({"/edituser","/edituser/{uid}"})
    public String edit(@PathVariable(name = "uid", required = false) Integer uid, Model model) {
        User u = new User();
        if (uid != null && uid > 0) {
            u = userService.findById(uid);
        }
        model.addAttribute("user",u);
        return "edituser";
    }
     @PostMapping("/saveuser")
    public String save(@Valid User user, BindingResult result, RedirectAttributes attr) {
       try{ if(result.hasErrors()){
           System.out.println(result.getFieldError().toString());
            return "redirect:/edituser";
        }
        if(user.getUid()!=null &&user.getUid()>0){
            User u=userService.findById(user.getUid());
            user.setPassword(u.getPassword());
        }
             userService.save(user);
           attr.addFlashAttribute("ok","保存成功");
             return "redirect:/listusers";
         } catch (Exception ex) {
           return "redirect:/edituser";
         }
     }
     @GetMapping("/deleteuser/{uid}")
     public String delete(@PathVariable("uid") Integer uid){
        userService.deleteById(uid);
        return "redirect:/listusers";
     }
     @PostMapping("/deleteusers")
    public String deletes(String uids){
        List<User> users=new ArrayList<>();
        JSONObject json = JSONObject.parseObject(uids);
         JSONArray arr=json.getJSONArray("uids");
         int ilen = arr.size();
         for(int i=0;i<ilen;i++){
             users.add(userService.findById(arr.getInteger(i)));
         }
         userService.deletes(users);
         return "redirect:listusers";
     }

     @GetMapping("/validuser/(uid)")
    public String validuser(@PathVariable("uid") Integer uid){
        User user=userService.findById(uid);
        user.setValidstate(1-user.getValidstate());
        return "redirect:/listusers";
     }

}