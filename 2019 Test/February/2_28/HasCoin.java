package day_2_27;

import java.util.Random;

//准备状态的实现类
public class HasCoin implements State{
	private CandyMachine mCandyMachine;
	
	public HasCoin(CandyMachine mCandyMachine) {
		this.mCandyMachine=mCandyMachine;
	}
	
	@Override
	public void insertCoin() {
		// TODO Auto-generated method stub
		System.out.println("you can't insert another coin!");
	}
	
	@Override
	public void returnCoin() {
		// TODO Auto-generated method stub
		System.out.println("coin return!");
        mCandyMachine.setState(mCandyMachine.mOnReadyState);
	}
	
	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("crank turn...!");
        Random ranwinner=new Random();
        int winner=ranwinner.nextInt(10);
        if(winner==0)
        {
            mCandyMachine.setState(mCandyMachine.mWinnerState);

        }else
        {
            mCandyMachine.setState(mCandyMachine.mSoldState);

        }
	}
	
	public void dispense() {
		
	}
	
	public void printstate() {
		System.out.println("***HasCoin****");
	}
}
