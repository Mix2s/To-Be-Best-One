package day_2_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/*
 * 利用了哈希存储，
 * 将给定字符串以键值对形式存储在哈希Map中，
 * key就是每一个字符，value就是每个字符出现的次数。
 * 存好后再按顺序遍历Map，
 * 找出第一次出现次数不为1的即可。返回。

 */
public class test4 {
	private static void findFirstRepeat(String A,int n) {
		/*
		 * 新插入的key-value给value赋值为1
		 * 用LinkedMap用来存储键值对
		 * HashMap插入输出顺序不一样
		 * LinkHasnMap插入输出顺序相同 
		 * 先存先显示
		 * HashSet不能有重复元素HshMap和LikedHashMap存储重复元素
		 */
		int sum=1;
		Map<String,Integer> hashMap=new LinkedHashMap<String, Integer>();
		for(int i=0;i<n;i++){
			char item=A.charAt(i);
			String item2=String.valueOf(item);
			String key=item2;
			boolean contains=hashMap.containsKey(key);
			if(contains) {
				sum++;
				hashMap.put(item2, sum);
			}else {
				sum=1;
				hashMap.put(item2, sum);
			}
		}
		System.out.println(hashMap);
		
		List<String> keylist=new ArrayList<String>();
		for(Entry<String,Integer> e:hashMap.entrySet()) {
			if(e.getValue().equals(2)) {
				keylist.add(e.getKey());
			}
		}
		for(String i:keylist) {
			System.out.println(i);
			break;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A="jasdijhu";
		int n=A.length();
//		findFirstRepeat(A, n);
		
		
//		String str="ab";
//		char str1=str.charAt(0);
//		char str2=str.charAt(1);
//		
//		char [] str3=str.toCharArray();
//		System.out.println(Arrays.toString(str3));
//		System.out.println(str1);
//		System.out.println(str2);
		
		
//		char m='a';
//		String str=String.valueOf(m);
//		String str2=m+"";
//		System.out.println(str);
//		System.out.println(str2);
		
		char[] m= {'a','b'};
		String str3=String.copyValueOf(m);
		String str4=new String(m);
		System.out.println(str3);
		System.out.println(str4);
		
		int i=1;
		String s=String.valueOf(i);
		String s1=Integer.toString(i);
		String s3=""+i;
		System.out.println(s+","+s1+","+s3);

	}

}
