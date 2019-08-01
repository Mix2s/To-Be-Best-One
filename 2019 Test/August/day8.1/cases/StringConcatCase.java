package com.cases;

import com.annotations.BenchMark;
import com.annotations.Measurement;

/**
 * String连接测试用例
 */
@Measurement(iterations = 1000,group = 5)
public class StringConcatCase {
    @BenchMark            //标注要测试的方法
    public String testStringAdd(){
        String s = "";
        for(int i=0;i<10;i++){
            s+=i;
        }
        return s;
    }

    @BenchMark
    public String testStringBuilderAdd(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(i);
        }
        return sb.toString();
    }
}
