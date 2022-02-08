import java.util.*;

public class Main {
	static int[][] graph;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();
		graph = new int[N + 1][N + 1];
		visit= new boolean[N + 1];
		int n1, n2;
		
		for (int i = 0; i < M; i++) {
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
		
		dfs(V);
		System.out.println();
		visit = new boolean[N + 1];
		bfs(V);
	}
	
	public static void dfs(int start) {
		//start 방문했음(true) 저장 
		visit[start] = true;
		System.out.print(start+" ");
		if (start == graph.length) {
			return;
		}
		for (int i = 0; i < graph.length; i++) {
			//그래프 길이만큼 탐색해서 연결돼있고 방문 안했으면 dfs 호출
			if (graph[start][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		//연결리스트 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		//큐에 start 추가하고 방문했음(true) 저장
		queue.add(start);
		visit[start] = true;
		System.out.print(start + " ");
		while(!queue.isEmpty()) {
			//peek 노드부터 탐색
			int peeknode = queue.peek();
			queue.poll();
			for (int i = 1; i < graph.length; i++) {
				if (graph[peeknode][i] == 1 && visit[i] == false) {
					queue.add(i);
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
