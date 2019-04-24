package src.javatest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

class BeanOperation2 {
    /**
     * 负责设置类中的属性操作
     * @param actionObject 表示当前发出设置请求的程序类的当前对象
     * @param msg 属性的具体内容，格式为:"属性名称:|内容|属性名称:|内容..."
     */
    public static void setBeanValue(Object actionObject,String msg) throws Exception {
        //按照要求切分
        String[] result = msg.split("\\|");
        for(int i =0;i<result.length;i++){
            String[] tmp = result[i].split(":");
            String attribute = tmp[0];
            String[] fields = attribute.split("\\.");
            if(fields.length>2){
                //多级VO操作
                Object currentObject = actionObject;
                for(int x = 0;x<fields.length-1;x++){
                    //对应的返回对象
                    //循环结束拿到最后衣一层当前对象
                    currentObject = getObject(currentObject,fields[x]);  //没有value
                }
                //属性内容
                Object value  = getValue(currentObject,fields[fields.length-1],tmp[1]);
                setObjectValue(currentObject,fields[fields.length-1], (String) value);  //没有人穿入value
            }else{
                /*
                    单级Vo 获取当前操作简单的Java对象 属性内容
                 */
                String value = (String)getValue(actionObject,attribute,tmp[1]);
                Object currentObject = getObject(actionObject,fields[0]);
                setObjectValue(currentObject,fields[1],value);
            }
        }

    }
    public static Object getObject(Object obj,String attribute) throws Exception {
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
    public static Object getValue(Object wrapObject,String attribute,String value) throws Exception {
        Field field = wrapObject.getClass().getDeclaredField(attribute);
        if(field==null){
            field=wrapObject.getClass().getField(attribute);
        }
        if(field==null){
            return null;
        }
        return stringToType(field.getType().getSimpleName(),value);
    }
    public static void setObjectValue(Object obj, String attribute, String value) throws Exception {
        Field field = obj.getClass().getDeclaredField(attribute);
        if (field == null) {
            //第二次尝试从弗雷中取得该属性
            field = obj.getClass().getField(attribute);
        }
        if (field == null) {
            //两次都为取得 对象不存在
            return;
        }
        String methodName = "set" + intiCap(attribute);
        Method setMethod = obj.getClass().getMethod(methodName, field.getType());
        setMethod.invoke(obj, value);
    }
    public static String intiCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    /**
     * 将字符串的内容根据属性类型变为各种数据类型。
     * 支持的类型:int(Integer)、double(Double)、long(Long)、String、Date
     * @param wrapObject 包装类
     * @param attribute 属性
     * @param value 属性值
     * @return 根据属性类型进行转型处理
     */
    public static Object getObject(Object wrapObject, String attribute,String value) throws Exception {
        Field field = wrapObject.getClass().getDeclaredField(attribute);
        if(field==null){
            field = wrapObject.getClass().getField(attribute);
        }
        if(field==null){
            return null;
        }
        return stringToType(field.getType().getSimpleName(),value);
    }
    /**
     * 根据指定类型将字符串做转型处理
     * @param type 数据类型
     * @param value 数据内容
     * @return 转换为具体类型
     */
    private static Object stringToType(String type,String value) throws Exception {
        if("String".equals(type)){
            if(isNotNull(value)){
                return value;
            }else{
                return null;
            }
        }else if("int".equals(type)||"Integer".equals(type)){
            if(isInt(value)){
                //数据内容为整形
                return Integer.parseInt(value);
            }
        }else if("double".equals(type)||"Double".equals(type)){
            if(isDouble(value)) {
                //数据内容为小数
                return Double.parseDouble(value);
            }
         }else if ("long".equals(type)||"Long".equals(type)){
            if (isDouble(value)) {
                // 数据内容为长整型
                return Long.parseLong(value);
            }
        }else if ("Date".equals(type)) {
            // 数据类型为Date
            String pattern = null;
            if (isDate(value)) {
                pattern = "yyyy-MM-dd" ;
            }
            if (pattern!=null){
                return new SimpleDateFormat(pattern).parse(value); //把数据转换成时间格式
            }
        }
        return null ;
        }
    /**
     * 判断给定的字符串是否为小数
     * @param value 给定的字符串
     * @return 由小数组成，返回true；否则返回false
     */
    private static boolean isDouble(String value) {
        if(isNotNull((value))){
            return value.matches("\\d+(\\.\\d+)?");
        }
        return false;
    }

    /**
     * 判断给定字符串是否为日期类型(yyyy-MM-dd)
     * @param value 给定字符串
     * @return 是日期类型返回true；否则返回false
     */
    private static boolean isDate(String value) {
        if(isNotNull(value)){
            return value.matches("\\d{4}-\\d{2}-\\d{2}");
        }
        return false;
    }

    /**
     * 判断给定字符串是否是一个整数
     * @param value 给定字符串
     * @return 由整数组成，返回true；否则返回false
     */
    private static boolean isInt(String value) {
        if(isNotNull(value)){
            return value.matches("\\d+");
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     * @param value 要判断的字符串
     * @return 如果字符串为空，返回false；否则返回true
     */
    private static boolean isNotNull(String value) {
        return !(value==null||value.isEmpty()||"".equals(value)); //判空
    }
    /*
        自动化关联
     */
    public static Object getObject_auto(Object obj,String attribute) throws Exception {
        String mentohodName = "get"+intiCap(attribute);
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field==null){
            field = obj.getClass().getField(attribute);
        }
        if(field==null){
            return null;
        }
        Method method = obj.getClass().getMethod(mentohodName);
        Object objectInstance = method.invoke(obj);
        if(objectInstance==null){
            objectInstance = field.getType().newInstance();
            setObjectValue(obj,attribute, (String) objectInstance);
        }
        return objectInstance;
    }
}
