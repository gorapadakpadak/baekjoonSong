import sys
sys.setrecursionlimit(10**4)

def dfs(i, j, visited, graph, w, h):
    if visited[i][j] == 1 or graph[i][j] == 0:
        return 0
    
    if visited[i][j] == 0 and graph[i][j] == 1:
        visited[i][j] = 1
    move = [(-1,0),(0,-1),(0,1),(1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
    for mv in move:
        y = i + mv[0]
        x = j + mv[1]
        if x >= 0 and x < w and y >= 0 and y < h and visited[y][x] == 0 and graph[y][x] == 1:
            dfs(y,x,visited, graph,w, h)
    return 1

w, h = map(int, input().split())

while w!=0 and h != 0:
    graph = [[] for _ in range(h)]
    for i in range(h):
        graph[i] = list(map(int, input().split()))
    cnt = 0
    maxcnt = 0
    visited = [[0]*w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            cnt += dfs(i,j, visited, graph, w, h)
    #        print(cnt, visited)
            if maxcnt < cnt:
                maxcnt = cnt
    print(maxcnt)

    w, h = map(int, input().split())