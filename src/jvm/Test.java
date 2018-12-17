package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/12/15
 * Time:13:11
 */

public class Test {

	static {
		i = 0;

		//非法向前引用 illegal forward reference
//		System.out.println(i);
	}

	static int i = 1;
}
