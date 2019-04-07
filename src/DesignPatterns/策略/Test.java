package DesignPatterns.策略;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:16:41
 *
 * 做一件事多个完成的方式
 */
public class Test {

	public static void main(String[] args) {
		Person chinese=new Chinese();
		Person america=new America();
		Person african=new African();
		chinese.repast();
		america.repast();
		african.repast();
	}
}
