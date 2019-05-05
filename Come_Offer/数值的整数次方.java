public double Power(double base, int exponent) {
        double result = 1;
        for(int i = 0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result = 1/result;
        }
        return result;
  }
  总结
    1.直接写 double类型的结果利用 绝对值直接求出结果 如果为- 则取到数
 public double Power(double base, int exponent) {
        if(exponent==0&&base!=0){
            return 1;
        }
        if(exponent==1){
            return base;
        }
        if(base==0&&exponent<=0){
            throw new RuntimeException();
        }
        if(base==0&&exponent>0){
            return 0;
        }
        double result = Power(base,Math.abs(exponent)>>1);
        result*=result;
        if((exponent&1)==1){
            result*=base;
        }
        if(exponent<0){
            result = 1/result;
        }
        return result;
  }
  总结
        1.考虑多种情况
        base exponent 的组合  10 01 11 00 1大于0 0小于0
