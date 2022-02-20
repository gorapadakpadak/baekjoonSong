import sys
input = sys.stdin.readline

n, m = map(int, input().split())

lst = [[] for i in range(n)]

for i in range(m):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

visited = [0 for i in range(n)]

def dfs(v, depth):
    global ans
    visited[v] = 1
    if depth >= 4:
        ans = True
        return
    for nxt in lst[v]:
        if not visited[nxt]:
            dfs(nxt, depth + 1)
            visited[nxt] = 0

ans = 0
for i in range(n):
    dfs(i, 0)
    visited[i] = 1
    if ans:
        break
print(1 if ans else 0)
