package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2019/4/22
 * Time:20:40
 */
public class AlternatePrint {

	public static void main(String[] args) {


	}

 static	class A extends Thread {
	 @Override
	 public void run() {

			 synchronized (this) {
				 while (true){
				 try {
					 System.out.println("A");
					 this.wait();
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
				 this.notify();

			 }
	 }
	}}

	static class B extends Thread{
		@Override
		public void run() {

				synchronized (this) {
					while (true){

						try {
						System.out.println("B");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					this.notify();

				}
				}

		}}

}
