package DesignPatterns.工厂.抽象工厂;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:28
 */
abstract class Engine {
}

 class EngineA extends Engine{
	public EngineA(){
		System.out.println("制造-->EngineA");
	}
}
 class EngineB extends Engine {
	public EngineB() {
		System.out.println("制造-->EngineB");
	}
}

