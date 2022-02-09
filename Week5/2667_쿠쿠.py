
n = int(input())
graph = []

for i in range(n):
    graph.append(list(map(int, input())))

visited = [[0]*n for _ in range(n)]



move = [(-1,0),(1,0),(0,-1),(0,1)]

def dfs(y,x, visited, graph, cnt):

    if (x<0 or x>=n) or (y<0 or y>=n) or graph[y][x] == 0 or visited[y][x]>0:
        return cnt
    graph[y][x] = cnt+1
    visited[y][x] = 1
    #for i in range(n):
    #    print(visited[i])
    #print()
    #print(y, x)
    #print("graph")
    #for i in range(n):
    #    print(graph[i])
    #print()
    #print("visited")
    #for i in range(n):
    #    print(visited[i])
    #print()
    for mv in move:
        dx = x+mv[0]
        dy = y+mv[1]
        if dx<0 or dx >= n or dy < 0 or dy >= n or graph[dy][dx]==0 or visited[dy][dx]>0:
            continue
        if graph[dy][dx] == 1 and visited[dy][dx] == 0:
            dfs(dy,dx,visited,graph,cnt)

    return cnt+1

maxval = 0

for i in range(n): #y
    for j in range(n): #x
        maxval=dfs(i,j,visited, graph, maxval)
        #print(maxval)
#for i in range(n):
#    print(graph[i])

#print(maxval)
countarr = [0]*(maxval) #[0,0,0,0]

for i in range(n):
    for j in range(n):
        if graph[i][j]:
            countarr[graph[i][j]-1] += 1
        
        
#print(countarr)
countarr.sort()
print(maxval)

for i in range(maxval):
    print(countarr[i])


