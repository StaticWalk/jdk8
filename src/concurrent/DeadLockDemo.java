package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/23
 * Time:21:43
 *
 * 死锁
 */
public class DeadLockDemo {
	private static Object lockA=new Object();
	private static Object lockB=new Object();

	public static void main(String[] args) {
		set(lockA,lockB);
		set(lockB,lockA);
	}
	static void set(Object a,Object b){
		new Thread(()->{synchronized (a){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (b){}
		}}).start();
	}
}
