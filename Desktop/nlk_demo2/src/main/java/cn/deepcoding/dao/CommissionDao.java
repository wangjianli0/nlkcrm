package cn.deepcoding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.deepcoding.model.Commission;

public interface CommissionDao {
	public List<Commission> findCommissions ();
	public void addComm();
	public boolean delCommission(@Param("id")Integer id);
}
