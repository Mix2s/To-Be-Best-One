package day_2_22;

public class test2 {
public static int getPos(int[] A,int n,int val) {
	int low=0,high=n-1,mid = 0;
	if(n==0||A==null) {
		return -1;
	}
	while(low<=high) {
		mid=(low+high)/2;
	}
	//但第一次出现相等位置需要向前查找 最后返回第一次出现的位置
	if(val==A[mid]) {
			for(int j=mid;j>=0;j--) {
				if(A[j]!=A[mid]) {
					mid=j+1;
					break;
				}else if(A[j]==A[mid]) {
					mid=j;
					continue;
				}
			}
			return mid;
		}else if(val<A[mid]) {
			high=mid-1;
		}else {
			low=mid+1;
		}
	  return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int A[]= {4,4,5,5,5,5};
			int val=4;
			int n=A.length;
			int result=getPos(A, n, val);
			System.out.println(result+"aa");
	}

}
