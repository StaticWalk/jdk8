package DesignPatterns.工厂.工厂方法;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:09
 */
public class BMW {
	public BMW() {
	}
}
 class BMW320 extends BMW {
	public BMW320() {
		System.out.println("生产320");
	}
}

 class BMW523 extends BMW {
	public BMW523() {
		System.out.println("生产523");
	}
}
