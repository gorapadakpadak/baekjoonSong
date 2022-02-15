import java.util.*;

public class Main {
	static int N, K;
	static int[] dx = { -1, 1 };
	static int[] visit = new int[100001];
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visit[N] = 1;
		while (queue.isEmpty() == false) {
			int temp = queue.poll();
			for (int i = 0; i < 3; i++) {
				int location;
				if (i == 0) {
					location = temp + 1;
				}
				else if (i == 1) {
					location = temp - 1;
				}
				else {
					location = temp * 2;
				}
				if (location == K) {
					System.out.println(visit[temp]);
					return;
				}
				if (location >= 0 && location < visit.length && visit[location] == 0) {
					queue.add(location);
					visit[location] = visit[temp] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		bfs();
	}
}
