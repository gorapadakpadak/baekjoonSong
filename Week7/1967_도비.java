package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
  //노드번호, 가중치 정보 클래스
	static class Node{
		int num, len;
		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
  //양방향 인접리스트
	static List<Node> list[];
	static boolean visit[];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N-1; i++) {
      //입력
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, len));
			list[to].add(new Node(from, len));
		}
		ans = 0;
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			visit[i] = true;
			dfs(i, 0);
		}
		System.out.println(ans);
	}
  
	private static void dfs(int num, int dim) {
		for (Node node : list[num]) {
      //방문하지 않은 노드일때 방문, dfs 호출
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, dim + node.len);
			}
		}
    //더한 가중치 값중 가장 큰 max값이 ans
		ans = (ans < dim)? dim : ans;
	}
}
