from collections import deque
n = int(input())

#x1 = [0]*n
#y1 = [0]*n
#x2 = [0]*n
#y2 = [0]*n

move = [(-2,1),(-2,-1),(2,1),(2,-1),(-1,2),(-1,-2),(1,2),(1,-2)]
for i in range(n):
    l = int(input())
    x1,y1 = map(int, input().split())
    x2,y2 = map(int, input().split())
    graph = [[0]*l for _ in range(l)]
    q = deque()

        
    #cnt = -1
    q.append((x1, y1))
    while True:
        x1, y1 = q.popleft()
        #print("tmpx:",x1," tmpy:",y1)
        if x1 == x2 and y1 == y2:
            break

        for j in move:
            if (0<=x1+j[0]<l) and (0<=y1+j[1]<l) and graph[y1+j[1]][x1+j[0]]==0:
                graph[y1+j[1]][x1+j[0]] = graph[y1][x1]+1
                q.append((x1+j[0], y1+j[1]))

    print(graph[y2][x2])