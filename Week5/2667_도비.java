import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int total = 0;
	static int count;
	static List<Integer> list = new ArrayList<>();

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 0;
				if (map[i][j] == 1 && visit[i][j] == false) {
					total++;
					count++;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		System.out.println(total);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void dfs(int y, int x) {
		visit[y][x] = true;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (visit[ny][nx] == false && map[ny][nx] == 1) {
					count++;
					dfs(ny, nx);
				}
			}
		}
	}
}
