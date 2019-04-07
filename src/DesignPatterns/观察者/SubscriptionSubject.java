package DesignPatterns.观察者;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:41
 */
public class SubscriptionSubject implements Subject{

	private List<Observer> weixinUserlist = new ArrayList<Observer>();


	@Override
	public void attach(Observer observer) {
		weixinUserlist.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		weixinUserlist.remove(observer);
	}

	@Override
	public void notify(String message) {
		for (Observer observer : weixinUserlist) {
			observer.update(message);
		}
	}
}
