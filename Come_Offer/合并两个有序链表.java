public ListNode Merge(ListNode list1,ListNode list2) {
       ListNode head = new ListNode(0);
       ListNode cur = head;
       while(list1!=null&&list2!=null){
           if(list1.val<list2.val){
               head.next = list1;
               head = list1;
               list1 = list1.next;
           }else{
               head.next = list2;
               head = list2;
               list2 = list2.next;
           }
          
       }
           if(list1!=null){
               head.next = list1;
           }
           if(list2!=null){
               head.next = list2;
           }
          
        return cur.next;
    }
    总结
      1.正常思维 创建一个新的链表 然后当传入的链表不为空时 进行比较当符合情况 head.next = list 移动head
   public ListNode Merge(ListNode list1,ListNode list2) {
      if(list1==null){
          return list2;
      }
       if(list2==null){
           return list1;
       }
        if(list1.val<=list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
             return list2;
        }
    }   
总结
       1.采用递归 if(kust1.val<list2.val){
                     list1.next = 后面连接递归
