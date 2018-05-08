package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/7
 * Time:9:20
 *
 * 一次对象自我拯救的演示
 * 演示内容：
 * 1.对想可以在被GC时自我拯救
 * 2.这种拯救机会只有一次，因为一个对象的finalize()最多被系统自动调用一次。
 *
 */
public class FinalizeEscapeGC {

	public static FinalizeEscapeGC SAVE_HOOK = null;

	public void isAlive(){
		System.out.println("yes, i am still alive!");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();

		//对象第一次自救
		SAVE_HOOK = null;
		System.gc();
		//由于finalize的优先级低，暂停0.5s等待
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("no, i am dead:");
		}

		//对象第二次自救，代码同上面，结果是自救失败
		SAVE_HOOK = null;
		System.gc();
		//由于finalize的优先级低，暂停0.5s等待
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("no, i am dead:");
		}

	}
}
