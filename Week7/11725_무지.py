from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs():
    queue = deque()
    queue.append(1)
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if parent[i] == 0:
                parent[i] = node
                queue.append(i)


N = int(input())
graph = [[] for _ in range(N+1)]
parent = [0 for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# [print(line) for line in graph]

bfs()
for item in parent[2:]:
    print(item)
