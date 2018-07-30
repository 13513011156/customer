package tk.mybatis.springboot.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 系统日志
 *
 */
public class SysLog implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;

	/** 内容 */
	private String msg;

	/** 创建时间 */
	private Date createTime;

	private String method;
	private String location;


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
