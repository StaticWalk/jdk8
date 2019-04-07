package DesignPatterns.策略;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:16:39
 */
interface Person {
	void repast();
}

class African implements Person {
	@Override
	public void repast() {
		System.out.println("非洲人用手吃饭");
	}
}

class America implements Person {
	@Override
	public void repast() {
		System.out.println("美国人用刀叉吃饭");
	}
}
class Chinese implements Person {
	@Override
	public void repast() {
		System.out.println("中国人用筷子吃饭");
	}
}
