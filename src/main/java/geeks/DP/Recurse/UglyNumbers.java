package geeks.DP.Recurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UglyNumbers {
	public static void main(String[] args) {
		
		int[] prime=new int[901];
		Integer[] out=new Integer[901];
		out[1]=1;
		out[2]=2;
		out[3]=3;
		out[5]=5;
		int x=6;
		for(int i=2;i<6;i++){
			if(prime[i]==0){
				
				int k=0;
				int j=i*i;
				
				while(j<901){
					out[x++]=j;					
					prime[j]=i;
					j=i*i+k*i;
					++k;
				}
			}
		}
		
		int count=1;
		for(Integer y:out){
			if(y!=null)
				System.out.println(y);
			else
				continue;
			if(count<151)
				++count;
			else
				break;
			
		}
		
	}

}

