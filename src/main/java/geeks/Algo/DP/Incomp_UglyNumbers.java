package geeks.Algo.DP;

public class Incomp_UglyNumbers {
	public static void main(String[] args) {
//		method 1 maths
		int x=getNthUglyNo(150);
		System.out.println(x);
//		method 2 DP
		int[] ugly=new int[150];
		dpUgly(ugly);
	}
	
	public static void dpUgly(int[] uglyOut){
		uglyOut[0]=1;
		int i2=0, i3=0, i5=0;
		int nextUglyno_2=uglyOut[i2]*2;
		int nextUglyno_3=uglyOut[i3]*3;
		int nextUglyno_5=uglyOut[i5]*5;
		int count=1;
		int min=0;
		while(count<uglyOut.length){
			min=min(nextUglyno_2, nextUglyno_3, nextUglyno_5);
			
			if(min==nextUglyno_2){
				i2=i2+1;
				nextUglyno_2=uglyOut[i2]*2;
			}else if(min==nextUglyno_3){
				i3=i3+1;
				nextUglyno_3=uglyOut[i3]*3;
			}else{
				i5=i5+1;
				nextUglyno_5=uglyOut[i5]*5;
			}
			uglyOut[count++]=min;;
		}
	}
	
	public static int min(int a, int b, int c){
		if(a<b && a<c)
			return a;
		else if(b<a && b<c)
			return b;
		else
			return c;
	}
	
	public static int getNthUglyNo(int n){
		
		int count=1;
		int i=1;
		
		while(count<=n){
			++i;
			int a2=gcd(i, 2);
			int a3=gcd(a2, 3);
			int a5=gcd(a3, 5);
			
			if(a5==1){
				++count;
				System.out.println(i);
			}
		}
		return i;
	}
	
	public static int gcd(int a, int b){
		while(a%b==0)
			a=a/b;
		
		return a;
	}


}


