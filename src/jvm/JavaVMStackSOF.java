package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/5
 * Time:14:04
 *
 *
 * 虚拟机栈和本地方法栈OOM测试
 * 		VM Args: -Xss128k
 *
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak(){
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
		oom.stackLeak();
	}catch (Throwable e){
			System.out.println("stack length:"+oom.stackLength);
			throw e;}
	}

}
