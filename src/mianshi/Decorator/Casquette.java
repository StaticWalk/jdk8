package mianshi.Decorator;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/23
 * Time:16:30
 */
public class Casquette extends HatDecorator {

	Person person;

	public Casquette(Person person) {
		this.person = person;
	}
	@Override
	public String getDescription() {
		return person.getDescription() + "a casquette  "; //鸭舌帽
	}

	@Override
	public double cost() {
		return 75 + person.cost();
	}

}

