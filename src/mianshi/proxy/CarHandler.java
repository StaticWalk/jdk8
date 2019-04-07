package mianshi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/17
 * Time:14:26
 */
public class CarHandler implements InvocationHandler {


	private Object car;

	public CarHandler(Object object) {
		this.car = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("before");
		Object res =method.invoke(car,args);
		System.out.println("after");
		return  res;

	}
}
