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
