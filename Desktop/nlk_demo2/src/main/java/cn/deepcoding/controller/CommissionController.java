package cn.deepcoding.controller;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.deepcoding.model.Commission;
import cn.deepcoding.service.CommissionService;

@Controller

public class CommissionController {
	
	@Resource(name="cservice")
	private CommissionService cservice;

	@RequestMapping("/commission")
	public String comm(){
		return "jsp/commission/comlist";
	}
	
	@RequestMapping("/listcomm")
	@ResponseBody
	public List<Commission> commissions(){
		
		return cservice.findCommissions();
	}
	
	@RequestMapping("/addcomm")
	@ResponseBody
	public void add(){
		
		 cservice.addComm();
		
	}
	
	@RequestMapping("/deletecomm")
	public String dele(Integer id){
		cservice.delCommission(id);
		return "redirect:/listcomm";
	
	}
	

}
