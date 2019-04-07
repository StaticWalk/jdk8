package mianshi.Decorator;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/23
 * Time:16:14
 */

//将人抽象成基类
public abstract class Person {
	String description = "Unkonwn";

	public String getDescription()
	{
		return description;
	}

	public abstract double cost(); //子类应该实现的方法
}

