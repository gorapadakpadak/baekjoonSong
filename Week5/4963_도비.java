import java.util.Scanner;
public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static int w, h;
	
	private static int dfs(int x, int y) {
		//네가지 대각선 방향 이동경로 저장
    int[] dx = {0, 0, 1, -1, -1, 1, -1, 1}, dy = {1, -1, 0, 0, -1, 1, 1, -1};
		
		visit[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int xx = dx[i] + x, yy = dy[i] + y;
			if(xx > 0 && yy > 0 && xx <= h && yy <= w) {
        //방문하지 않았을 경우 dfs
				if(arr[xx][yy] == 1 && !visit[xx][yy]) dfs(xx, yy);
			}
		}		
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int cnt = 0;
			w = scan.nextInt(); h = scan.nextInt();
			if(w == 0 && h == 0) break;
			
			arr = new int[h+1][w+1]; visit = new boolean[h+1][w+1];
      //입력
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) arr[i][j] = scan.nextInt(); 
			}
			
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
          //dfs 사용하여 깊이탐색, 방문하지 않은 곳만 방문
					if(arr[i][j] == 1 && !visit[i][j]) cnt += dfs(i, j);
				}
			}
			System.out.println(cnt);
		}
	}
}
