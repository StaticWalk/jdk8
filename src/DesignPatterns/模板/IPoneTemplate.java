package DesignPatterns.模板;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:16:56
 */
public abstract class IPoneTemplate {

	public void createIPhone(){
		setupCpu();
		setupAll();
		check();
		box();
	}
	protected abstract void box();
	protected abstract boolean check();
	protected abstract void setupAll();
	protected abstract void setupCpu();
}
