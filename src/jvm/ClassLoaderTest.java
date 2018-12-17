package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xiongxiaoyu
 * Data:2018/12/15
 * Time:14:32
 *
 * 不同类加载器对instanceof关键字运算的结果的影响
 * 虚拟机中存在两个jvm.ClassLoaderTest类
 * 但是一个是由系统应用程序类加载器加载的，一个是自定义的类加载器加载的
 *  来自相同的Class文件，但依然是两个独立的类
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";

					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null){
						return super.loadClass(name);
					}

					byte[] b = new byte[is.available()];

					is.read(b);

					return defineClass(name,b,0,b.length);
				}catch (IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};

		Object obj = myLoader.loadClass("jvm.ClassLoaderTest").newInstance();

		System.out.println(obj.getClass());

		System.out.println(obj instanceof jvm.ClassLoaderTest);
	}
}
