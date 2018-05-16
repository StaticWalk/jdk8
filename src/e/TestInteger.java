package e;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/16
 * Time:18:38
 *
 *
 *
 * 为了对基本数据类型进行对象操作，对每一种数据类型引入了对应的包装类型(wrapper class)
 *
 * Integer 是int的包装类,int初值0，Integer 初值null
 *
 */
public class TestInteger {
	public static void main(String[] args) {
		int i = 128;
		Integer i2 = 128;
		Integer i3 = new Integer(128);
		System.out.println(i == i2); //Integer会自动拆箱为int，所以为true
		System.out.println(i == i3); //true，理由同上
		Integer i4 = 127;//编译时被翻译成：Integer i4 = Integer.valueOf(127);
		Integer i5 = 127;
		System.out.println(i4 == i5);//true
		Integer i6 = 128;
		Integer i7 = 128;
		//valueOf()函数对于-128到127之间的数，会进行缓存， Integer i5 = 127时，
		//会将127进行缓存，下次再写Integer i6 = 127时，就会直接从缓存中取，就不会new了。所以i4和i5比是true，而i6和i7比是false。
		System.out.println(i6 == i7);//false
		Integer i8 = new Integer(127);
		System.out.println(i5 == i8); //false
		Integer i9 = new Integer(128);
		Integer i10 = new Integer(123);
		System.out.println(i9 == i10);  //false
	}
}
