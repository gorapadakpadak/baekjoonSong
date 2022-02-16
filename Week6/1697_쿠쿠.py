from collections import deque
n, k = map(int, input().split())

arr = [0]*100001
q = deque()
q.append(n)

while q:
    tmp= q.popleft()
    
    if tmp == k:
        print(arr[k])
        break
    for x in (tmp-1, tmp+1, tmp*2):
        if 0<=x<=100000 and arr[x]==0:
            arr[x] = arr[tmp]+1
            q.append(x)


