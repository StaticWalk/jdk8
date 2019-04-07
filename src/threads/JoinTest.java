package threads;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/25
 * Time:15:25
 */
public class JoinTest {

	public static void main(String[] args) {



		Thread t = new Thread(new ThreadImpl());
		t.start();

		try {
			t.join(1000);
			if (t.isAlive())
				System.out.println("alive");
			else
				System.out.println("die");

			System.out.println("join Finish");


		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	static class ThreadImpl implements Runnable{

		@Override
		public void run() {
			System.out.println("Begin threadimpl");
			try {
				Thread.sleep(5000);
				System.out.println("end threadimpl");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
