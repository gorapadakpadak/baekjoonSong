import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		graph = new int[N + 1][N + 1];
		visit= new boolean[N + 1];
		int u, v;
		int connectedComp = 0;
		
		for (int i = 0; i < M; i++) {
			u = scan.nextInt();
			v = scan.nextInt();
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		for (int i = 1; i <= N; i++) {
			if (visit[i] == false) {
				dfs(i);
				connectedComp++;
			}
		}
		System.out.print(connectedComp);
	}
	
	public static void dfs(int start) {
		if (visit[start] == true) {
			return;
		}
		visit[start] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[start][i] == 1) {
				dfs(i);
			}
		}
	}
}
