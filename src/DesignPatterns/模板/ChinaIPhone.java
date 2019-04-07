package DesignPatterns.模板;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:16:57
 */
public class ChinaIPhone extends IPoneTemplate {

		@Override
		protected void box() {
			System.out.println("box()");
		}
		@Override
		protected boolean check() {
			System.out.println("check()");
			return true;
		}
		@Override
		protected void setupAll() {
			System.out.println("setupAll()");
		}
		@Override
		protected void setupCpu() {
			System.out.println("setupCpu()");
		}

}
