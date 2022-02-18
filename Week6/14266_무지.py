from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs(s, c):
    queue = deque()
    queue.append((s, c))
    while queue:
        s, c = queue.popleft()
        if dist[s][s] == -1:   # 방문하지 않은 경우
            dist[s][s] = dist[s][c] + 1
            queue.append((s, s))
        if s+c <= n and dist[s+c][c] == -1:
            dist[s+c][c] = dist[s][c] + 1
            queue.append((s+c, c))
        if s-1 >= 0 and dist[s-1][c] == -1:
            dist[s-1][c] = dist[s][c] + 1
            queue.append((s-1, c))


n = int(input())
dist = [[-1] * (n+1) for _ in range(n+1)]
dist[1][0] = 0     # 1차 인덱스는 화면, 2차 인덱스는 클립보드
bfs(1, 0)

answer = -1
for i in range(n+1):
    if dist[n][i] != -1:
        if answer == -1 or answer > dist[n][i]:
            answer = dist[n][i]
print(answer)
