package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/21
 * Time:19:13
 */
public class TestConcurrentHashMapIterator {

	public static void test(){
		final ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
		map.put("a","abstract");
		map.put("b","basic");
		new Thread(()->{
			for (Map.Entry<String,String> entry:map.entrySet()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
					System.out.println(entry.getKey()+","+entry.getValue());
			}
		}).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
			map.put("c","call");
	}

	public static void main(String[] args) {
		test();
	}

}
