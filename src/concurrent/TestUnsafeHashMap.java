package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/19
 * Time:22:36
 *
 *
 *  java hashmap的死循环
 *  https://coolshell.cn/articles/9606.html
 *
 */
public class TestUnsafeHashMap {

	public  static void unsafeConcurrentUpdate(){
		final Map<Integer,Integer> map=new HashMap<>();
		for (int i = 0; i <1000; i++) {
//			new Thread(()->{
////				for (int j = 0; j < 100; j++) {
////					map.put(rnd.nextInt(),1);
////				}}).start();
			Thread t=new Thread(){
				Random rnd=new Random();
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						map.put(rnd.nextInt(),1);
					}
				}
			};
			t.start();
		}
	}

	public static void main(String[] args) {
		unsafeConcurrentUpdate();
	}

}
