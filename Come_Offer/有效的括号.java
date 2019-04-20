class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();   //创建一个栈
        char[] chars = s.toCharArray();         //将字符串中的所有内容换成数组
        for(char achar:chars){          //将数组元素按照顺序压入栈
            if(stack.size()==0){            //栈为空 直接压
                stack.push(achar);      
            }else if(isSym(stack.peek(),achar)){        //栈不为空比较 栈顶元素和传入的参数
                stack.pop();                    //相同 弹出栈元素
            }else{
                stack.push(achar);          //不同 压入 比较下一个
            }
        }
        return stack.size()==0;            //比较完成 清空栈内容
    }
    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
