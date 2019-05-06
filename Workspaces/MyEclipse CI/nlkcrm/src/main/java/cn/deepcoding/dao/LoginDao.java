package cn.deepcoding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.deepcoding.model.Menu;
import cn.deepcoding.model.User;


public interface LoginDao {
	//根据账号、密码获取用于信息
	public User getUser(@Param("loginName")String loginName,
			@Param("upwd")String upwd);
	
	//根据角色权限获得一级菜单
	public List<Menu> findParentMenuByRoleId(
			@Param("roleId")Integer roleId);
	
	//根据角色以及父级菜单编号，获得子菜单
	public List<Menu> findChildMenuRoleIdAndMenuId(
			@Param("roleId")Integer roleId,
			@Param("functionId")Integer functionId);
	
}
