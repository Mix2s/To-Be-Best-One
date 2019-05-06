 public void reOrderArray(int [] a) {
       for(int i =0;i<a.length;i++){
           for(int j=a.length-1;j>i;j--){
               if((a[j]%2==1)&&(a[j-1]%2==0)){
                   int tmp = a[j];
                   a[j]=a[j-1];
                   a[j-1]=tmp;
               }
           }
       }
    }
    总结
      1.采用冒泡思想 每一次交换奇数和偶数顺序 第一次循环将 最大奇数 放前 第二次 第二奇数。。。。
