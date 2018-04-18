package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/18
 * Time:12:19
 *
 * 同时开始
 * 一个主线程，n个子线程，子线程模拟运动员，主线程模拟裁判
 *  协作的共享变量是一个开始信号 FireFlag
 *
 */
public class TestFireFlag {

	public static void main(String[] args) throws InterruptedException {
		int num=10;
		FireFlag fireFlag=new FireFlag();
		Thread[] racers=new Thread[num];
		for (int i = 0; i < num; i++) {
			new Racer(fireFlag).start();
		}
		Thread.sleep(1000);
		fireFlag.fire();
	}
}

class Racer extends Thread{
	FireFlag fireFlag;
	public Racer(FireFlag fireFlag){
		this.fireFlag=fireFlag;
	}
	@Override
	public void run() {
		try {
			this.fireFlag.waitForFire();
			System.out.println("start run"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class FireFlag{
	private volatile boolean fired=false;
	public synchronized void waitForFire() throws InterruptedException {
		while (!fired){
			wait();
		}
	}
	public synchronized void  fire(){
		this.fired=true;
		notifyAll();
	}
}