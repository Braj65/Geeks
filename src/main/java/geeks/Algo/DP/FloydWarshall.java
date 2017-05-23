package geeks.Algo.DP;

public class FloydWarshall {
	public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
		int v=Integer.MAX_VALUE;
        int graph[][] = { {0,   5,  v, 10},
                          {v, 0,   3, v},
                          {v, v, 0,   1},
                          {v, v, v, 0}
                        };
        
        floydWarshall(graph);
        
    }
	
	public static void floydWarshall(int[][] graph){
		int row=graph.length;
		int col=graph[0].length;
		int[][] dist=new int[row][col];
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				dist[i][j]=graph[i][j];
			}
		}
		
		for (int k = 0; k < col; k++)
        {
            // Pick all vertices as source one by one
            for (int i = 0; i < row; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (int j = 0; j < col; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k]!=Integer.MAX_VALUE && 
                    		dist[k][j]!=Integer.MAX_VALUE &&
                    		dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
		printSolution(dist);
		
	}
	
	public static void printSolution(int dist[][])
    {
        System.out.println("Following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<4; ++i)
        {
            for (int j=0; j<4; ++j)
            {
                if (dist[i][j]==Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

}
