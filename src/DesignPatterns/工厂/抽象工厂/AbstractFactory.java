package DesignPatterns.工厂.抽象工厂;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:34
 */

public interface AbstractFactory {

	 Engine createEngine();

	 AirCondition createAircondition();
}


 class FactoryBMW523 implements AbstractFactory {
	@Override
	public Engine createEngine() {
		return new EngineA();
	}

	@Override
	public AirCondition createAircondition() {
		return new AirConditionA();
	}
}

class FactoryBMW320 implements AbstractFactory {
	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public AirCondition createAircondition() {
		return new AirConditionB();
	}
}
