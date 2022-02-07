
from collections import deque

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

move = [(-1,0),(1,0),(0,-1),(0,1)]
q = deque([(0,0)])

while q:
    x, y =q.popleft()

    for mv in move:
        dx = x+mv[0]
        dy = y+mv[1]

        if dx<0 or dx>=m or dy<0 or dy>=n:
            continue
        if graph[dy][dx]==0:
            continue
        if graph[dy][dx] == 1 :
            graph[dy][dx] = graph[y][x]+1
            q.append((dx,dy))
    #print(graph)
print(graph[n-1][m-1])