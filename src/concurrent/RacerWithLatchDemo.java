package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/18
 * Time:12:51
 */
public class RacerWithLatchDemo {


	public static void main(String[] args) throws InterruptedException {
		int workerNum=100;
		MyLatch myLatch=new MyLatch(workerNum);
		Worker[] workers=new Worker[workerNum];
		for (int i = 0; i < workerNum; i++) {
			workers[i]=new Worker(myLatch);
			workers[i].start();
		}
		myLatch.await();
		System.out.println("collect worker results");

	}




//	static class Racer extends Thread{
//		MyLatch myLatch;
//		public Racer(MyLatch myLatch) {
//			this.myLatch = myLatch;
//		}
//		@Override
//		public void run() {
//			try{
//				this.myLatch.await();
//				System.out.println("start run"+Thread.currentThread().getName());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	public static void main(String[] args) throws InterruptedException {
//		int num=10;
//		MyLatch myLatch=new MyLatch(1);
//		Thread[] racers=new Thread[num];
//		for (int i = 0; i < num; i++) {
//			racers[i]=new Racer(myLatch);
//			racers[i].start();
//		}
//		Thread.sleep(1000);
//		myLatch.countDown();
//
//	}


}
class MyLatch{
	private int count;

	public MyLatch(int count) {
		this.count = count;
	}
	public synchronized void await() throws InterruptedException {
		while (count>0){
			wait();
		}
	}
	public synchronized void countDown(){
		count--;
		if (count<=0){
			notifyAll();
		}
	}
}

class Worker extends Thread{
	MyLatch myLatch;

	public Worker(MyLatch myLatch) {
		this.myLatch = myLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random()*1000));
			this.myLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}