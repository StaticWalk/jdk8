package DesignPatterns.观察者;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:39
 */
public class WeixinUser implements Observer {

	// 微信用户名
	private String name;

	public WeixinUser(String name) {
		this.name = name;
	}
	@Override
	public void update(String message) {
		System.out.println(name + "-" + message);
	}


}

