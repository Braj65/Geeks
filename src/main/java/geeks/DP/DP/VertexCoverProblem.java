package geeks.DP.DP;

public class VertexCoverProblem {
	
	public static void main(String[] args) {
		node root=newNode(20);
		root.left=newNode(8);
		root.left.left=newNode(4);
		root.left.right=newNode(12);
		root.left.right.left=newNode(10);
		root.left.right.right=newNode(14);
		root.right=newNode(22);
		root.right.right=newNode(25);
		
		System.out.println(vCover(root));
	}
	
	public static int vCover(node root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 0;
		
		if(root.vc!=0)
			return root.vc;
		
		int size_incl=1+vCover(root.left)+vCover(root.right);
		int size_excl=0;
		if(root.left!=null)
			size_excl=size_excl+1+vCover(root.left.left)+vCover(root.left.right);
		if(root.right!=null)
			size_excl=size_excl+1+vCover(root.right.left)+vCover(root.right.right);
		
		root.vc=Math.min(size_excl, size_incl);
		return root.vc;
	}	
	
	
	public static node newNode(int data){
		node x=new VertexCoverProblem().new node();
		x.data=data;
		x.left=null;
		x.right=null;
		return x;
	}
	
	class node{
		public int data, vc;		
		public node left, right;
	}

}
