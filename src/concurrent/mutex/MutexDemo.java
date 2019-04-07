package concurrent.mutex;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/4
 * Time:22:41
 */
public class MutexDemo  {


	private static Mutex mutex = new Mutex();


	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(()->
			{
				mutex.lock();
				try {
					Thread.sleep(3000);
					System.out.println(System.currentTimeMillis());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					mutex.unlock();
				}
			});

			thread.start();
		}

	}

}
