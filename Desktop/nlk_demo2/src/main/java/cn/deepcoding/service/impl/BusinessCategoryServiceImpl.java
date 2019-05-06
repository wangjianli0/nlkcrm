package cn.deepcoding.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.deepcoding.dao.BusinessCategoryDao;
import cn.deepcoding.model.BusinessCategory;
import cn.deepcoding.service.BusinessCategoryService;

@Service("businessCategoryService")
public class BusinessCategoryServiceImpl implements BusinessCategoryService{

	//注入
	@Resource
	private BusinessCategoryDao businessCategoryDao;
	
	//查看所有的业务类型
	@Override
	public List<BusinessCategory> getBusinessCategorys() {
		// TODO Auto-generated method stub
//		return businessCategoryDao.findBusinessCategorys();
		List<BusinessCategory> list = businessCategoryDao.findBusinessCategorys();
		return list;
	}

}
