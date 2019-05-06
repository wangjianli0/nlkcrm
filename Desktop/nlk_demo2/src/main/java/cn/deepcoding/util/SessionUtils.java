package cn.deepcoding.util;

import javax.servlet.http.HttpSession;

import cn.deepcoding.model.User;

public class SessionUtils {
	public static final String RANDOMCODEKEY = "ASDABSEHADSFGSADFwefrasdfasdfasfdasdfaef";
	public static final String USER = "UserSession";//用户的session对象前缀
	
	//设置(保存)用户到session
	public static void saveUserSession(HttpSession session,User user){
		session.setAttribute(USER, user);
	}
	//从session获取当前用户信息
	public static User getUserFromSessitnon(HttpSession session){
		Object attribute = session.getAttribute(USER);
		return attribute == null?null:(User)attribute;
	}
	//比较验证码
	public static boolean checkValidateCode(
			String inputCode,
			HttpSession session){
		String validateCode = (String)session.getAttribute(
				SessionUtils.RANDOMCODEKEY);
		if(inputCode!=null&&!inputCode.equals("")&&
				inputCode.toUpperCase().equals(validateCode)){
			return true;
		}
		return false;
//		return true;
	}
	//根据用户销毁对应session
	public static void logout(HttpSession session){
		session.removeAttribute(USER);
	}
	
}
