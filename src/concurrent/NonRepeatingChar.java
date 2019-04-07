package concurrent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/26
 * Time:19:18
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流
 * 中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中
 * 读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class NonRepeatingChar {


	Map<Character, Integer> map = new LinkedHashMap<>();

	//Insert one char from stringstream
	public void Insert(char ch)
	{
		if(map.containsKey(ch)){
			map.put(ch, map.get(ch)+1);}
		else {
				map.put(ch, 1);}
	}
	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce()
	{
		for(Map.Entry<Character, Integer> en : map.entrySet())
		{
			if(en.getValue() == 1){ return en.getKey();}
		}
		return '#';
	}


}
