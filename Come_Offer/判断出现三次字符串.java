public static void judgeThree(String str){
        char[] strArr = str.toCharArray();
        int[] count = new int[128];
        for(int i=0;i<strArr.length;i++){
            if(('A'<=strArr[i]&&strArr[i]<='Z')
                    ||(strArr[i]>='a'&&strArr[i]<='z')
                    ||(strArr[i]>='0'&&strArr[i]<='9')){
                ++count[strArr[i]];
                if(count[strArr[i]]==3){
                    System.out.println(strArr[i]);
                    break;
                }
            }
        }
    }
    
总结
    1.将字符串变为字符数组 循环遍历 符合情况将单个字符计算总和
