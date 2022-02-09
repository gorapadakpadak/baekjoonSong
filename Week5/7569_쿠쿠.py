from collections import deque
m, n, h = map(int, input().split())

box = [[[] for _ in range(n)] for _ in range(h)]

for i in range(h):
    for j in range(n):
        box[i][j] = list(map(int, input().split()))
move = [(0,0,1),(0,0,-1),
        (0,1,0),(0,-1,0),
        (1,0,0),(-1,0,0)]

q = deque()


for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 1:
                q.append((k,j,i,0))

while q:
    x, y, z, cnt = q.popleft()
    for mv in move:
        dz = z+mv[0]
        dy = y+mv[1]
        dx = x+mv[2]
        if (0<=dx<m) and (0<=dy<n) and (0<=dz<h):
            if box[dz][dy][dx] == 0:
                box[dz][dy][dx] = cnt+1
                q.append((dx,dy,dz,cnt+1))
   
                

impossible = 0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 0:
                impossible=1
                break

if impossible:
    print(-1)
else:
    print(cnt)
