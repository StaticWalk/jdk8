package ect;

import java.io.*;


/**
 * 使用transient关键字不序列化某个变量
 *   读取的时候，读取数据的顺序一定和存放的顺序保持一致
 * 1.一旦变量被transient修饰，改变量不是对象持久化的一部分，在序列化后无法再次访问
 * 2.transient只能修饰变量，不能修饰方法和类且应实现Serializable(所有内容会被自动序列化)
 * ，Externalizable(内容要手工序列化)接口，本地变量也不能被其修饰。
 * 3.被transient关键字修饰的变量和静态变量均不能被序列化。
 *
 * 反序列化类中的static变量username值为JVM中对应的static变量的值
 *
 * 被transient关键字修饰的变量不能序列化？
 * 在实现Externalizable序列化接口中，不手动序列化的话，transient无效。@ExternalizableTest.java
 */

public class TransientTest {

	public static void main(String[] args) {

		User user = new User();
		user.setUsername("ABC");
		user.setPasswd("123456");

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPasswd());

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\xiongxiaoyu\\Desktop/user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {

			//把User类的username设置为static变量，然后在读取文件反序列化前，给username属性赋值
			//反序列化后static类型变量username值其实是JVM对应的static值，不是反序列化得出的
//			user.setUsername("zhangsan");

			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\xiongxiaoyu\\Desktop/user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user.getUsername());
			System.err.println("password: " + user.getPasswd());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class User implements Serializable {
	private static final long serialVersionUID = 8294180014912103005L;

	private  String username;
	private transient String passwd;
//	private  String passwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
