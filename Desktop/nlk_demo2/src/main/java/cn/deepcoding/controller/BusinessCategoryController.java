package cn.deepcoding.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.deepcoding.model.BusinessCategory;
import cn.deepcoding.service.BusinessCategoryService;

@Controller
public class BusinessCategoryController {
	
	@Resource
	private BusinessCategoryService businessCategoryService;
	
	//进入业务类型的页面
	@RequestMapping("/category")
	public String businessCategory(){
		return "jsp/business/businessCategory";
	}
	
	//查看所有的业务类型
	@RequestMapping("/listCategory")
	@ResponseBody
	public List<BusinessCategory> getBusinessCategory(){
		System.out.println(999);
		return businessCategoryService.getBusinessCategorys();
	}

}
