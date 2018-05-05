package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/5
 * Time:14:47
 *
 * 创建线程导致内存溢出异常
 *
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {

	public void dontStop(){
		while (true){
		}
	}

	public void stackLeakByThread(){
		while (true){
			new Thread(()->{dontStop();}).start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom=new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
