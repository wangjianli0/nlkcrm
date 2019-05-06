package cn.deepcoding.service;

import java.util.List;

import cn.deepcoding.model.Menu;
import cn.deepcoding.model.User;

public interface  LoginService {
	public User getUser(String loginName,String upwd);
	public List<Menu> getMenu(User user);

}
