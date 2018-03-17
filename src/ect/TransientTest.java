package ect;

import java.io.*;


/**
 * 使用transient关键字不序列化某个变量
 *   读取的时候，读取数据的顺序一定和存放的顺序保持一致
 * 1.一旦变量被transient修饰，改变量不是对象持久化的一部分，在序列化后无法再次访问
 * 2.transient只能修饰变量，不能修饰方法和类且应实现Serializable接口，本地变量也不能被其修饰。
 * 3.被改关键字修饰的变量和静态变量均不能被序列化。
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

	private String username;
//	private transient String passwd;
	private  String passwd;

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
