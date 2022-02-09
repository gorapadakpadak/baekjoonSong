from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = 1
    while queue:
        cx, cy = queue.popleft()
        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, 1), (1, -1), (1, 1), (-1, -1)]:
            nx, ny = cx + dx, cy + dy
            if nx < 0 or nx > h-1 or ny < 0 or ny > w-1 :
                continue
            if visited[nx][ny] == 0 and graph[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = 1


while True :
    w, h = map(int, input().split())

    # 종료 조건
    if w == 0 and h == 0:
        break

    graph = [[0] * w for _ in range(h)]
    visited = [[0] * w for _ in range(h)]
    count = 0

    for i in range(h):
        graph[i] = list(map(int, input().split()))

    for i in range(h):
        for j in range(w):
            if visited[i][j] == 0 and graph[i][j] == 1:
                bfs(i, j)
                count += 1

    print(count)
