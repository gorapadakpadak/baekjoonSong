import sys
input = lambda : sys.stdin.readline().strip()
sys.setrecursionlimit(10000)

def dfs(v):
    visited[v] = 1
    for i in range(1, N+1):
        # 연결되어 있고 visited 아니면 다시 탐색
        if s[v][i] == 1 and visited[i] == 0:
            dfs(i)

N, M = map(int, input().split())
s = [[0] * (N+1) for i in range(N+1)]
visited = [0 for i in range(N+1)]
count = 0

for i in range(M):
    a, b = map(int, input().split())
    # a와 b 연결됨
    s[a][b] = 1
    s[b][a] = 1

for i in range(1, N+1):
    if visited[i] == 0:
        dfs(i)
        # 연결되어 있지 않고 visited 이면 하나의 connected component 생긴 것
        count += 1

print(count)
