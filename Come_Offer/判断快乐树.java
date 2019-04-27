class ishappy{
public boolean isHappy2(int num){
        Set<Integer> numbers = new HashSet<>();
        int n = num;
        while(n!=1){
            int sum = 0;
            char[] chars = String.valueOf(n).toCharArray();
            for(int i = 0;i<chars.length;i++){
                int bitDig = Integer.parseInt(new String(chars,i,1));
                sum+=(bitDig*bitDig);
            }
            n=sum;
            if(numbers.contains(n)){
                return false;
            }else{
                numbers.add(n);
            }
        }
        return true;
    }
    public int getNext(int num){
        int result = 0;
        result = (num%10)*(num%10);
        num = num/10;
        if(num==0){
            return result;
        }else{
            return result+getNext(num);
        }
    }
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            int flag = getNext(n);
            if(set.contains(flag)){
                return false;
            }else{
                set.add(flag);
                n=flag;
            }
        }
        return true;
    }
}
总结
  1.这里写了两个可以判断的方法 
      方法一
        1.将一串数字转换成一个字符数组 然后 将这个数组每一个字符拆开拿出 并转换成数字  char[] chars = String.valueOf(n).toCharArray();
                                                                              int bitDig = Integer.parseInt(new String(chars,i,1));
        2.对拿出的每一个数字进行平方求和
        3、判处条件当不断重复一个数字的平方会陷入循环 所以 利用集合框架 将这个数字进行重复性比较 
      方法二
        1.利用%进行 去末尾
