package mianshi.xvliehua;

import java.io.Serializable;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/22
 * Time:17:16
 *
 * 要序列化的对象data1
 */
public class data1 implements Serializable {

	private int id;
	private String name;
	private String pwd;
	private String pwd2;

	public data1(int id, String name, String pwd, String pwd2) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.pwd2 = pwd2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
}
