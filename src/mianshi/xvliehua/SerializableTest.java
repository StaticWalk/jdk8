package mianshi.xvliehua;

import java.io.*;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/22
 * Time:17:19
 */
public class SerializableTest {

	public void serialize() throws IOException {

 		data1 d = new data1(11,"data1","pwd1","pwd2");

		FileOutputStream fos = new FileOutputStream("data1");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(d);

		fos.close();
		oos.close();

		System.out.println("序列化完成");
	}

	public data1 deSerializable() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("data1");
		ObjectInputStream ois = new ObjectInputStream(fis);

 		data1 d = (data1) ois.readObject();


 		fis.close();
		ois.close();

		return d;
	}


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializableTest t = new SerializableTest();
		t.serialize();
		data1 d = t.deSerializable();
		System.out.println(d.getName());
	}

}


