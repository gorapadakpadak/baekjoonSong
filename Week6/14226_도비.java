import java.util.*;

public class Main {
	static int S;
	static boolean[][] visited = new boolean[2001][2001];

	static class Emoticon {
		int screen;
		int clipboard;
		int second;

		public Emoticon(int screen, int clipboard, int second) {
			this.screen = screen;
			this.clipboard = clipboard;
			this.second = second;
		}
	}

	public static void bfs() {
		Queue<Emoticon> queue = new LinkedList<>();
		queue.offer(new Emoticon(1, 0, 0));
		visited[1][0] = true;
		while (!queue.isEmpty()) {
			Emoticon emoticon = queue.poll();
			if (emoticon.screen == S) {
				int ans = emoticon.second;
				System.out.println(ans);
				return;
			}
			if (emoticon.clipboard != 0 && !visited[emoticon.screen + emoticon.clipboard][emoticon.clipboard] && emoticon.screen + emoticon.clipboard <= 1000) {
				queue.offer(new Emoticon(emoticon.screen + emoticon.clipboard, emoticon.clipboard, emoticon.second + 1));
				visited[emoticon.screen + emoticon.clipboard][emoticon.clipboard] = true;
			}

			if (emoticon.screen != emoticon.clipboard && !visited[emoticon.screen][emoticon.screen]) {
				queue.offer(new Emoticon(emoticon.screen, emoticon.screen, emoticon.second + 1));
				visited[emoticon.screen][emoticon.screen] = true;
			}

			if (emoticon.screen > 0 && !visited[emoticon.screen - 1][emoticon.clipboard]) {
				queue.offer(new Emoticon(emoticon.screen - 1, emoticon.clipboard, emoticon.second + 1));
				visited[emoticon.screen - 1][emoticon.clipboard] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		S = scan.nextInt();
		bfs();
	}
}
