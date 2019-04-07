package mianshi.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/17
 * Time:14:28
 */
public class main {


	public static void main(String[] args) {

		CarImpl carImpl = new CarImpl();
		CarHandler handler = new CarHandler(carImpl);

		Car proxy = (Car) Proxy.newProxyInstance(
				main.class.getClassLoader(),
				carImpl.getClass().getInterfaces(),
				handler
		);

		proxy.run();
	}
}
