from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = 1
    while queue:
        cx, cy = queue.popleft()
        for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            nx, ny = cx + dx, cy + dy
            if 0 > nx or nx > N-1 or ny < 0 or ny > M-1:
                continue
            if visited[nx][ny] == 0 and graph[nx][ny] == 1:
                graph[nx][ny] = graph[cx][cy] + 1
                visited[nx][ny] = 1
                queue.append((nx, ny))
    return graph[N-1][M-1]


N, M = map(int, input().split())
graph = [[0] * M for _ in range(N)]
visited = [[0] * M for _ in range(N)]
for i in range(N):
    graph[i] = list(map(int, input()))

print(bfs(0, 0))
