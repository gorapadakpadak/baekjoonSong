import sys
input = lambda : sys.stdin.readline().strip()

def dfs(x,y):
    global count
    visited[x][y] = 1

    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx > N - 1 or ny < 0 or ny > N - 1:
            continue
        if visited[nx][ny] == 0 and graph[nx][ny] == 1:
            count += 1
            dfs(nx, ny)

N = int(input())
graph = [[0] * N for _ in range(N)]
visited = [[0] * N for _ in range(N)]
houses, count, groups = [], 1, 0

for i in range(N):
    graph[i] = list(map(int, input()))

for i in range(N):
    for j in range(N):
        if visited[i][j] == 0 and graph[i][j] == 1:
            count = 1
            dfs(i, j)
            houses.append(count)
            groups += 1

print(groups)
houses.sort()
for item in houses:
    print(item)
