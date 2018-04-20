package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/19
 * Time:22:36
 */
public class TestUnsafeHashMap {


	public  void unsafeConcurrentUpdate(){
		final Map<Integer,Integer> map=new HashMap<>();
		Random rnd=new Random();
		for (int i = 0; i < 100; i++) {
//			new Thread(()->{
////				for (int j = 0; j < 100; j++) {
////					map.put(rnd.nextInt(),1);
////				}}).start();

			Thread t=new Thread(){
				Random rnd=new Random();
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						map.put(rnd.nextInt(),1);
					}
				}
			};
			t.start();
		}
	}

	public static void main(String[] args) {
		TestUnsafeHashMap a=new TestUnsafeHashMap();
		a.unsafeConcurrentUpdate();
	}

}
