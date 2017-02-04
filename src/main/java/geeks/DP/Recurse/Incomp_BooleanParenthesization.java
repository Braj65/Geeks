package geeks.DP.Recurse;

public class Incomp_BooleanParenthesization {
	
	public static void main(String[] args) {
		boolean symbols[] = {true, true, false, true};
	    String operators[] = {"|","&","^"};
	    System.out.println(countParenth(symbols, operators, 0, symbols.length-1));
	}
	
	public static boolean  countParenth(boolean[] symbols, String[] operators, int start, int end){
		if(start==end)
			return symbols[start];			
		
		boolean result=false;
		int count=0;
		for(int k=start;k<end;k++){
			if(operators[k]=="|")
				result=countParenth(symbols, operators, start, k) | countParenth(symbols, operators, k+1, end);
			else if(operators[k]=="&")
				result=countParenth(symbols, operators, start, k) & countParenth(symbols, operators, k+1, end);
			else
				result=countParenth(symbols, operators, start, k) ^ countParenth(symbols, operators, k+1, end);
			if(result==true)
				++count;
		}
		
		return result;
	}
	

}
