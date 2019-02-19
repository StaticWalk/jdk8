package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/18
 * Time:22:03
 */
public class ConcurrentHashMapTest {

	public static ConcurrentHashMap<Integer, String> pushMessage = new ConcurrentHashMap<Integer, String>();


	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			pushMessage.put(i, "该消息是id为" + i + "的消息");
		}

		Thread sendThread = new SendThread();
		Thread receiveThread = new ReceiveThread();
		sendThread.start();
		receiveThread.start();
		for (int i = 5; i < 10; i++) {
			pushMessage.put(i, "该消息是id为" + i + "的消息");
		}

	}

	static class SendThread extends Thread {
		@Override
		public void run() {
			try {
				sleep(6000);
				while (ConcurrentHashMapTest.pushMessage.size() > 0) {
					for (Map.Entry<Integer, String> hashMap : ConcurrentHashMapTest.pushMessage.entrySet()) {
						System.out.println("消息id:" + hashMap.getKey()+ "未发送成功，在此重发:" + hashMap.getValue());
					}

					sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class ReceiveThread extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 100000; i++) {
					sleep(2000);
					for (Map.Entry<Integer, String> map : ConcurrentHashMapTest.pushMessage.entrySet()) {
						if (map.getKey() == i) {
							System.out.println("成功收到id为：" + map.getKey() + "返回的信息，删除该元素");
							ConcurrentHashMapTest.pushMessage.remove(map.getKey());
						}
					}
					System.out.println("内存对象中的元素数量为：" + ConcurrentHashMapTest.pushMessage.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
