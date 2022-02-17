import sys
input = lambda: sys.stdin.readline().strip()


def dfs(v, depth):
    global ans
    visited[v] = 1
    if depth == 4:
        ans = True
        return
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i, depth + 1)
            visited[i] = 0


N, M = map(int, input().split())
graph = [[] for _ in range(N)]
visited = [0 for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

ans = False
for i in range(N):
    dfs(i, 0)
    visited[i] = 0
    if ans:
        break

print(1 if ans else 0)
