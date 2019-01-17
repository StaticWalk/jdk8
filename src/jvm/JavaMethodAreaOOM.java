package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/12/22
 * Time:12:53
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		while (true){}
	}
}
