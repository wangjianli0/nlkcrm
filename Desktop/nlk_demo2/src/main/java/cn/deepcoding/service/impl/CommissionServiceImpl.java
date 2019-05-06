package cn.deepcoding.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.deepcoding.dao.CommissionDao;
import cn.deepcoding.model.Commission;
import cn.deepcoding.service.CommissionService;
@Service("cservice")
public class CommissionServiceImpl implements CommissionService{
	@Resource
	private CommissionDao dao;
	@Override
	public List<Commission> findCommissions() {
		
		return dao.findCommissions();
	}
	@Override
	public void addComm() {
		dao.addComm();
		
	}
	@Override
	public boolean delCommission(Integer id) {

		return dao.delCommission(id);
	}

}
