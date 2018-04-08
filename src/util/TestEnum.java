package util;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/6
 * Time:21:05
 *
 * 抽象类Enum，Enum自带的compareTo()返回的序列号差值self.ordinal - other.ordinal,
 * EnumMap是专门和枚举类结合形成Map的key-value键值对结构，内存实现是数组结构
 *
 */
public class TestEnum {

	enum Operate {
		ADD,UPDATE,DELETE;
	}
	public static void main(String[] args) {

		Map<Operate,String> map=new EnumMap<Operate, String>(Operate.class);
		//put方法
		map.put(Operate.ADD, "add operate");
		map.put(Operate.UPDATE, "update operate");
		map.put(Operate.DELETE, "delete operate");

		//重写了toString方法
		System.out.println(map);

		//size方法
		System.out.println(map.size());

		System.out.println(map.containsKey(Operate.UPDATE));
		System.out.println(map.containsValue("update operate"));
		System.out.println(map.get(Operate.DELETE));

		//remove
		map.remove(Operate.UPDATE);
		System.out.println(map);

		//key集合
		for(Operate operate:map.keySet()){
			System.out.print(operate + " ");
		}

		System.out.println();
		//value集合
		for(String obj:map.values()){
			System.out.print(obj + ",");
		}

		System.out.println();
		//key-value集合
		for(Map.Entry<Operate, String> entry:map.entrySet()){
			System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
		}



	}
}
