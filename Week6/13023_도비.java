import java.util.*;

public class Main {
	static int N, M;
	static boolean[] visit;
	static ArrayList<Integer>[] array;

	public static void dfs(int x, int length) {
		if (length == 4) {
			System.out.println(1);
			System.exit(0);
		}
		visit[x] = true;
		for (int i = 0; i < array[x].size(); i++) {
			int temp = array[x].get(i);
			if (visit[temp] == false) {
				visit[temp] = true;
				dfs(temp, length + 1);
				visit[temp] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		array = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			array[a].add(b);
			array[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			dfs(i, 0);
		}
		System.out.println(0);
	}
}
