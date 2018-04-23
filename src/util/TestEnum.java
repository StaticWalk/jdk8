package util;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/6
 * Time:21:05
 *
 * 抽象类Enum，Enum自带的compareTo()返回的序列号差值self.ordinal - other.ordinal,
 *
 * EnumMap是专门和枚举类结合形成Map的key-value键值对结构，内存实现是数组结构的Map实现。
 * 		（同一类型枚举类型键值实例到值的映射，由于枚举类型相对固定数量少，通过枚举类型
 * 		的ordinal()获得当前实例的声明次序，来维持实例字数组中的位置，EnumMap更加高效）
 *		key不能null，value可以null（实际maskNull后,以Null存在数据库中）
 *可用工具类Collections包装成线程安全的：
 * 		Map<EnumKey, V> m = Collections.synchronizedMap(new EnumMap<EnumKey, V>();
 *
 */
public class TestEnum {

	enum Operate {
		ADD,UPDATE,DELETE;
	}
	public static void main(String[] args) {

		Map<Operate,String> map=new EnumMap<>(Operate.class);
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
