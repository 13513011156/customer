package tk.mybatis.springboot.model;

import java.io.Serializable;

/**
 *
 * 用户开发管理
 *
 */
public class Customer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String region;
	private String managerId;
	private String level;
	private String satify;
	private String credit;
	private String state;
	private String tel;
	private String fax;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSatify() {
		return satify;
	}

	public void setSatify(String satify) {
		this.satify = satify;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
}
