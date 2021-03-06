package src.javatest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation {
    private BeanOperation(){

    }
    /*
        1.负责设置类中的属性操作
        @param actionObject 表示当前发出设置请求程序类的当前对象
        @param msg 属性的具体内容 格式 属性名称:|内容|属性名称：|内容
     */
    public static void setBeanValue(Object actionObject,String msg) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        //第一步 对字符串进行拆分
        //1.先按照 | 进行拆分
        String[] result = msg.split("\\|");     //属性名称：内容 属性名称：内容
        //每次执行 拆分后 只剩 属性名称：内容
        for(int i = 0;i<result.length;i++){
            //拆分 拿掉：
            String[] tmp = result[i].split(":");
            //属性名称 emp.ename
            String attribute = tmp[0];
            //属性内容
            String value = tmp[1];
            String[] fields  = attribute.split("\\.");
            //获取当前操作的简单Java对象
            Object currentObject = getObject(actionObject,fields[0]);
            setObjectValue(currentObject,fields[1],tmp[1]);
        }
    }
    /*
        1.将给钉子妇产首字母大写
        @param str给定字符串
        @return 返回字母大写的字符串
     */
    public static String intiCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    /**
     * 负责调用XXXAction类中的getter方法取得简单Java类对象
     * @param obj 表示调用方法的所在类对象
     * @param attribute 表示属性名称
     * @return 调用对象结果
     */
    public static Object getObject(Object obj,String attribute) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "get"+intiCap(attribute);
        // 调用指定属性的Field对象，目的是取得对象类型，如果没有此属性意味着操作无法继续进行
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field==null){
            field = obj.getClass().getField(attribute);
        }
        if(field==null){
            return null;
        }
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }
    /**
     * 根据指定的类对象设置指定类中的属性，调用setter方法
     * @param obj 属性所在类的实例化对象
     * @param attribute 属性名称
     * @param value 属性内容
     */
    public static void setObjectValue(Object obj,String attribute,String value) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field==null){
            field = obj.getClass().getField(attribute);
        }
        if(field==null){
            return ;
        }
        String methodName = "set"+intiCap(attribute);
        Method setMethod  =obj.getClass().getMethod(methodName,field.getType());
        setMethod.invoke(obj,value);
    }
}
