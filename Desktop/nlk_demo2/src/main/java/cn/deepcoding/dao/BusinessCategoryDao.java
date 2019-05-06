package cn.deepcoding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.deepcoding.model.BusinessCategory;

public interface BusinessCategoryDao {
	//查看所有的业务类型
	public List<BusinessCategory> findBusinessCategorys();
	
	//增加业务类别
	public void addBC(@Param("businessCategory") BusinessCategory businessCategory);

}
