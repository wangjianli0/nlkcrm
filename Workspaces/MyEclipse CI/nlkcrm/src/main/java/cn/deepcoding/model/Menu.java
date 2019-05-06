package cn.deepcoding.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键
	private String name;//菜单名称
	private String url;//超链接
	private String img;//图片地址
	private Integer parentId;//父菜单编号
	private String qtip;//菜单解释说明
	private Integer exist;//菜单状态
	//当前菜单下的子菜单
	private List<Menu> childMenus = new ArrayList<Menu>();
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(Integer id, String name, String url, String img,
			Integer parentId, String qtip, Integer exist, List<Menu> childMenus) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.img = img;
		this.parentId = parentId;
		this.qtip = qtip;
		this.exist = exist;
		this.childMenus = childMenus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getQtip() {
		return qtip;
	}
	public void setQtip(String qtip) {
		this.qtip = qtip;
	}
	public Integer getExist() {
		return exist;
	}
	public void setExist(Integer exist) {
		this.exist = exist;
	}
	public List<Menu> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	@Override
	public String toString() {
		return "Menu [childMenus=" + childMenus + ", exist=" + exist + ", id="
				+ id + ", img=" + img + ", name=" + name + ", parentId="
				+ parentId + ", qtip=" + qtip + ", url=" + url + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childMenus == null) ? 0 : childMenus.hashCode());
		result = prime * result + ((exist == null) ? 0 : exist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((qtip == null) ? 0 : qtip.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (childMenus == null) {
			if (other.childMenus != null)
				return false;
		} else if (!childMenus.equals(other.childMenus))
			return false;
		if (exist == null) {
			if (other.exist != null)
				return false;
		} else if (!exist.equals(other.exist))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (qtip == null) {
			if (other.qtip != null)
				return false;
		} else if (!qtip.equals(other.qtip))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
}

