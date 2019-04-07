package mianshi.Reflection;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/21
 * Time:19:18
 */
public class Reflection {

	public static void main(String[] args) {
		try {
			Class c = Sub.class;

			Base b = (Base)c.newInstance();

			b.f();

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

}




