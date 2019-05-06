package cn.deepcoding.controller;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.deepcoding.model.Menu;
import cn.deepcoding.model.User;
import cn.deepcoding.service.LoginService;
import cn.deepcoding.util.LoginVerification;
import cn.deepcoding.util.SessionUtils;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	@Autowired
	private HttpServletResponse httpServletResponse;
	@Autowired
	private LoginVerification loginVerification;
	
	//required=false:可以不传值
	@RequestMapping(value={"/logon"})
	public String logon(HttpSession session,Model model,@RequestParam(value="loginName",
				required=false)String loginName,
			@RequestParam(value="password",
				required=false)String password,
			@RequestParam(value="validateCode",
				required=false)String validateCode) {
		
		System.out.println(1231232);
		
		System.out.println(loginName+","+password+","+validateCode);
		//声明在登录过程中可能会出现的错误信息
		String errorMsg = "";
		//验证验证码
		if(SessionUtils.checkValidateCode(validateCode,
				session)){
			//验证用户状态
			User user = loginService.getUser(loginName, password);
			if(user!=null){
				if("启用".equals(user.getStatus())){
					//允许登录
					List<Menu> menus = 
						loginService.getMenu(user);
					user.setMenus(menus);
					System.out.println("user:"+user);
					SessionUtils.saveUserSession(session, user);
					return "redirect:/toMain";
				}else{
					errorMsg = "用户已经被停用";	
				}
			}else{
				errorMsg = "用户名或密码错误";
			}
		}
		else{
			errorMsg = "验证码错误";
		}
		model.addAttribute("errorMsg", errorMsg);
		return "jsp/login/login";
	}
	//跳转到主页面
	@RequestMapping("/toMain")
	public String toMain(){
		System.out.println("主页面");
		return "jsp/main/main";
	}
	@RequestMapping("/")
	public String login(){
		System.out.println("登陆界面");
		return "jsp/login/login";
	}
	
	
	//验证码
		@RequestMapping("/validateCode")
		public void ValidateCod(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			System.err.println("validateCode");
			loginVerification.service(request, response);
		}
}










