package mianshi.Decorator;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/23
 * Time:16:28
 */
public class Shirt extends ClothingDecorator {

	Person person;

	public Shirt(Person person) {
		this.person = person;
	}

	@Override
	public String getDescription() {
		return person.getDescription() + "a shirt  ";
	}

	@Override
	public double cost() {
		return 100 + person.cost(); //实现了cost()方法，并调用了person的cost()方法，目的是获得所有累加值

	}
}
