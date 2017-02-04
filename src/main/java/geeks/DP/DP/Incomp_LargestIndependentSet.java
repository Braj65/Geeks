package geeks.DP.DP;

//Exercises at the end of the problem

public class Incomp_LargestIndependentSet {
	public static void main(String[] args) {
		node in=new node(20);
		in.aleft=new node(8);
		in.sright=new node(22);
		in.sright.sright=new node(25);
		in.aleft.aleft=new node(4);
		in.aleft.sright=new node(12);
		in.aleft.sright.aleft=new node(10);
		in.aleft.sright.sright=new node(14);
		
		System.out.println(LISS(in));
	}
	
	public static int LISS(node root){
		if(root==null)
			return 0;
		
		if(root.aleft==null && root.sright==null)
			return 1;
		
		if(root.LISS!=null)
			return root.LISS;
		
		int size_excl=LISS(root.aleft)+LISS(root.sright);
		
		int size_incl=1;
		if(root.aleft!=null)
			size_incl=size_incl+LISS(root.aleft.aleft)+LISS(root.aleft.sright);
		if(root.sright!=null)
			size_incl=size_incl+LISS(root.sright.aleft)+LISS(root.sright.sright);
		
		return root.LISS=Math.max(size_excl, size_incl);
	}

	
	static class node{
		public node aleft=null;
		public node sright=null;
		public Integer LISS=null;
		public int data;
		
		public node(int x){
			this.data=x;
		}
	}
}
