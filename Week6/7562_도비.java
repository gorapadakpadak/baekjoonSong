import java.util.*;

public class  {
	static int N;
	static int[] dx = { -2, -1, 2, 1, 2, 1, -2, -1 };
	static int[] dy = { 1, 2, 1, 2, -1, -2, -1, -2 };
	static int[][] map;
	static boolean[][] visit;
	static int startX, startY, endX, endY;

	static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(startX, startY));
		visit[startX][startY] = true;
		while (queue.isEmpty() == false) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			if (x == endX && y == endY) {
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && visit[nx][ny] == false) {
					queue.add(new Point(nx, ny));
					visit[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testN = scan.nextInt();

		for (int i = 0; i < testN; i++) {
			N = scan.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			startX = scan.nextInt();
			startY = scan.nextInt();
			endX = scan.nextInt();
			endY = scan.nextInt();
			bfs();
			System.out.println(map[endX][endY]);
		}
	}
}
