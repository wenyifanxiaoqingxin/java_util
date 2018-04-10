package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.model.mybatis.UserInfo;
import ssm.service.UserInfoService;
import ssm.service.impl.UserInfoServiceImpl;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fx on 2017/10/20.
 */
@Controller
@RequestMapping("/users")

public class UserController {

    Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public String toIndex(HttpServletRequest httpServletRequest, ModelMap modelMap){
        List<UserInfo> users = this.userInfoService.userList();
        modelMap.put("user", users.get(0));
        modelMap.put("msg", "登录成功");
        httpServletRequest.setAttribute("msg1","成功");
        logger.info("姓名："+users.get(0).getUsername());
        return "showUser";
    }
}
