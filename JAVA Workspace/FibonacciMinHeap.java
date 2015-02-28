import java.util.*;

public final class FibonacciMinHeap{
	static HeapEntry Min;
	static int NodeCount;
	static int MaxDegree;
	public static final class HeapEntry{
		int Degree=0;
		HeapEntry Child=null;
		int Weight;
		HeapEntry Left=this;
		HeapEntry Right=this;
		HeapEntry Parent=null;
		boolean ChildCut=false;
		
		HeapEntry(int Weight){
			this.Weight=Weight;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while(testcases!=0){
			int E = sc.nextInt();
			Min = new HeapEntry(sc.nextInt());
			NodeCount=1;
			int x=1;
			while(x<E){
				int Weight = sc.nextInt();
				HeapEntry node = new HeapEntry(Weight);
				insert(node);
				NodeCount++;
				x++;
			}	
			MaxDegree = (int)Math.floor((Math.log(E))/(Math.log((1+Math.sqrt(5))/2)));
			while(NodeCount!=0){
			//	printRootNodes();
				extractMin();
			}
			testcases--;
		}
	}
	static void insert(HeapEntry node){
		Min.Left.Right=node;
		node.Left=Min.Left;
		node.Right=Min;
		Min.Left=node;
		if(Min.Weight>node.Weight)
			Min=node;
	}
	static void printRootNodes(){
		HeapEntry TempNode = Min.Right;
		while(!TempNode.equals(Min)){
			System.out.print(TempNode.Weight+" ");
			TempNode=TempNode.Right;
		}
		System.out.println(Min.Weight+" ");
	}
	static void extractMin(){
		System.out.print(Min.Weight+" ");
		HeapEntry TempNode = Min.Right;
		if(Min.Right==Min){
			if(Min.Child!=null){
				Min = Min.Child;
				Min.Parent=null;
			}
		}
		else
		{
			if(Min.Child!=null){
				Min.Left.Right=Min.Child;
				Min.Right.Left=Min.Child.Left;
				Min.Child.Left.Right=Min.Right;
				Min.Child.Left=Min.Left;
				Min = Min.Child;
				Min.Parent=null;
			}
			else
			{
				Min.Left.Right=Min.Right;
				Min.Right.Left=Min.Left;
				Min=TempNode;
			}
		}
		consolidateHeap();
		NodeCount--;
	}
	static void consolidateHeap(){
		boolean flag=true;
		while(flag){
			HeapEntry min = Min;
			HeapEntry[] RootSet = new HeapEntry[MaxDegree];
			RootSet[min.Degree]=Min;
			HeapEntry RankChecker = Min;
			flag=false;
			min=min.Right;
			while(min!=RankChecker){
				flag=false;
				if(Min.Weight>min.Weight)
					Min=min;
				if(RootSet[min.Degree]!=null){
					flag=true;
					HeapEntry SmallNode=null;
					HeapEntry BigNode=null;
					if(min.Weight<RootSet[min.Degree].Weight){
						SmallNode=min;
						BigNode=RootSet[min.Degree];
					}
					else
					{
						BigNode=min;
						SmallNode=RootSet[min.Degree];
					}
					BigNode.Left.Right=BigNode.Right;
					BigNode.Right.Left=BigNode.Left;
					if(SmallNode.Child!=null){
						SmallNode.Child.Left.Right=BigNode;
						BigNode.Left=SmallNode.Child.Left;
						SmallNode.Child.Left=BigNode;
						BigNode.Right=SmallNode.Child;
					}
					else
						BigNode.Left=BigNode.Right=BigNode;
					SmallNode.Child=BigNode;
					BigNode.Parent=SmallNode;
					RootSet[min.Degree]=null;
					min=SmallNode;
					RankChecker=SmallNode;
					SmallNode.Degree++;
				}
				else
					RootSet[min.Degree]=min;
				if(flag==false)
					min=min.Right;
			}
		}
	}
}
/*
Sample Input:
2
5
5 1 4 3 2
8
5 6 8 4 3 7 1 8
*/

