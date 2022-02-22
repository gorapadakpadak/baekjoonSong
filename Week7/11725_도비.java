import java.util.*;

public class Main {
	static int N;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void dfs(int v) {
		visited[v] = true;
		for (int i : list[v]) {
			if (!visited[i]) {
				parent[i] = v;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}
