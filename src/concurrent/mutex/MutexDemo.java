package concurrent.mutex;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/4
 * Time:22:41
 */
public class MutexDemo  {

	public static void main(String[] args) {

		Map<String,Integer> map = new HashMap();
		map.put("123",12);
		map.put("23",12);

		//1.
//		for (Map.Entry<String,Integer> entry : map.entrySet()){
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}

		//2.
		for (String key : map.keySet()){
			System.out.println(key);
		}






//		String a ="a";
//		System.out.println(a.hashCode());
	}



//	private static Mutex mutex = new Mutex();
//
//
//	public static void main(String[] args) {
//
//		for (int i = 0; i < 10; i++) {
//			Thread thread = new Thread(()->
//			{
//				mutex.lock();
//				try {
//					Thread.sleep(3000);
//					System.out.println(System.currentTimeMillis());
//
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}finally {
//					mutex.unlock();
//				}
//			});
//
//			thread.start();
//		}
//
//	}

}
