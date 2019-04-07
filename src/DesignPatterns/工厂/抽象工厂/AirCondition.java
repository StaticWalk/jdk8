package DesignPatterns.工厂.抽象工厂;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:32
 */
abstract class AirCondition {
}

class AirConditionA extends AirCondition{
	public AirConditionA() {
		System.out.println("制造-->AirconditionA");
	}
}

class AirConditionB extends AirCondition{
	public AirConditionB() {
		System.out.println("制造-->AirconditionB");
	}
}
