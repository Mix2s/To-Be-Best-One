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
 public void reOrderArray(int [] a) {
      if(a.length==0){
          return ;
      }
        int pre=0;
        int cur=0;
        int[] array = new int[a.length];
        for(int i=0;i<a.length;i++){
            if((a[i]&1)==1){
                pre++;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]%2==1){
                array[cur++]=a[i];
            }else{
                array[pre++]=a[i];
            }
        }
        for(int i=0;i<a.length;i++){
            a[i]=array[i];
        }
    }
