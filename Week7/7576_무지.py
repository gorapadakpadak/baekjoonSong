from collections import deque
import sys
input = lambda: sys.stdin.readline().strip()


def bfs():
    day = 0
    while queue:
        day += 1
        for _ in range(len(queue)):
            x, y = queue.popleft()
            for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                    graph[nx][ny] = 1
                    queue.append((nx, ny))

    for i in graph:
        for tomato in i:
            if tomato == 0:
                return -1

    return day - 1


m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
queue = deque([])
answer = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i, j])

print(bfs())
