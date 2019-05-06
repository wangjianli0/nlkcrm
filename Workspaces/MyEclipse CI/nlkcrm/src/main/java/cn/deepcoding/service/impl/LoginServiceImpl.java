package cn.deepcoding.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.deepcoding.dao.LoginDao;
import cn.deepcoding.model.Menu;
import cn.deepcoding.model.User;
import cn.deepcoding.service.LoginService;
import cn.deepcoding.util.MD5Util;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginDao loginDao;
	//根据账号、密码获取用户相关信息
	public User getUser(String loginName, String upwd) {
		if(loginName!=null&&upwd!=null){
			String passwordMd5 = MD5Util.getStringMD5(upwd);
			User user = loginDao.getUser(loginName, passwordMd5);
			if(user!=null){
				return user;
			}else{
				return null;
			}
		}
		return null;
	}
	public List<Menu> getMenu(User user) {
		List<Menu> menus =
			loginDao.findParentMenuByRoleId(user.getRoleId());
		for(int i=0;i<menus.size();i++){
			Menu menu = menus.get(i);
			List<Menu> childMenus =
				loginDao.findChildMenuRoleIdAndMenuId(user.getRoleId(),
					menu.getId());
			menu.setChildMenus(childMenus);
		}
		return menus;
	}

}
