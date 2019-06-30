package bite.note4;

import java.util.*;


public class ListIteratortest {
    public static void main(String[] args) {
       Map<Integer,String> map = new HashMap<>();
       map.put(1,"java");
       map.put(1,"wudi");
       map.put(2,"java");
       map.put(null,"java");
        //System.out.println(map.get(null));
        Set<Integer> keySet = map.keySet();
        for(Integer i:keySet){
            System.out.println(i);
        }

        Set<Map.Entry<Integer,String >> set = map.entrySet(); //map集合转成set集合
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        //List<String> values = (List<String>)map.values();
        Iterator<Integer> iterator1 = keySet.iterator();
        while(iterator.hasNext()){
            Integer i = iterator1.next();
            System.out.println(i+" = "+map.get(i));
        }
    }

    private static void code1() {
        List<String> list = new ArrayList<>();
        //Vector<String> list  = new Vector<>();
        list.add("java");
        list.add("wudi");
        list.add("c++");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
           // list.add("hui");
            String str = iterator.next();
            if(str.equals("java")){
                //list.remove(str); //ConcurrentModificationException
                iterator.remove();
            }
            System.out.println(str);
        }
        //Enumeration<String> enumeration = list.elements();
      /*  while(enumeration.hasMoreElements()){
            String str = enumeration.nextElement();
            System.out.println(str);
        }*/

     /*   ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        while(iterator.hasPrevious()){
            String str = iterator.previous();
            System.out.println(str);
        }*/
    }
}
