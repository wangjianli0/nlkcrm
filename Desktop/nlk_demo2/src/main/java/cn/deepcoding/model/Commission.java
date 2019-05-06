package cn.deepcoding.model;


import java.io.Serializable;
import java.util.Date;

import cn.deepcoding.util.DateUtil;



public class Commission
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String rule;
  private Integer minNum;
  private Integer maxNum;
  private Double ratioCompany;
  private Double ratioCustom;
  private Date createdDatetime;
  private Date updatedDatetime;
  private Integer areaId;
  private String areaName;
  private String type;
  private String category;
  private Integer bussnessId;
  private String bussnessName;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public String getRule()
  {
    return this.rule;
  }
  
  public void setRule(String rule)
  {
    this.rule = rule;
  }
  
  public Integer getMinNum()
  {
    return this.minNum;
  }
  
  public void setMinNum(Integer minNum)
  {
    this.minNum = minNum;
  }
  
  public Integer getMaxNum()
  {
    return this.maxNum;
  }
  
  public void setMaxNum(Integer maxNum)
  {
    this.maxNum = maxNum;
  }
  
  public Double getRatioCompany()
  {
    return this.ratioCompany;
  }
  
  public void setRatioCompany(Double ratioCompany)
  {
    this.ratioCompany = ratioCompany;
  }
  
  public Double getRatioCustom()
  {
    return this.ratioCustom;
  }
  
  public void setRatioCustom(Double ratioCustom)
  {
    this.ratioCustom = ratioCustom;
  }
  
  public String getCreatedDatetime()
  {
    if (this.createdDatetime != null) {
      return DateUtil.dateToStr("yyyy-MM-dd hh:mm:ss", this.createdDatetime);
    }
    return "";
  }
  
  public void setCreatedDatetime(Date createdDatetime)
  {
    this.createdDatetime = createdDatetime;
  }
  
  public String getUpdatedDatetime()
  {
    return DateUtil.dateToStr("yyyy-MM-dd hh:mm:ss", this.updatedDatetime);
  }
  
  public void setUpdatedDatetime(Date updatedDatetime)
  {
    this.updatedDatetime = updatedDatetime;
  }
  
  public String getAreaName()
  {
    return this.areaName;
  }
  
  public void setAreaName(String areaName)
  {
    this.areaName = areaName;
  }
  
  public Integer getAreaId()
  {
    return this.areaId;
  }
  
  public void setAreaId(Integer areaId)
  {
    this.areaId = areaId;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public Integer getBussnessId()
  {
    return this.bussnessId;
  }
  
  public void setBussnessId(Integer bussnessId)
  {
    this.bussnessId = bussnessId;
  }
  
  public String getBussnessName()
  {
    return this.bussnessName;
  }
  
  public void setBussnessName(String bussnessName)
  {
    this.bussnessName = bussnessName;
  }
}
