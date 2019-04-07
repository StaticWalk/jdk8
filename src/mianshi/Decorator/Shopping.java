package mianshi.Decorator;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/23
 * Time:16:30
 */
public class Shopping {

	public static void main(String[] args) {
		Person person = new Teenager();

		person = new Shirt(person);
		person = new Casquette(person);

		System.out.println(person.getDescription() + " ￥ " +person.cost());
	}

}
