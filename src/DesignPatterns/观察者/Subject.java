package DesignPatterns.观察者;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:40
 */
public interface Subject {

	/**
	 * 增加订阅者
	 * @param observer
	 */
	public void attach(Observer observer);

	/**
	 * 删除订阅者
	 * @param observer
	 */
	public void detach(Observer observer);

	/**
	 * 通知订阅者更新消息
	 */
	public void notify(String message);

}
