from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


MAX = 100001
N, K = map(int, input().split())
visit_time = [-1] * MAX
visit_time[N] = 0

queue = deque()
queue.append(N)
while queue:
    x = queue.popleft()
    if x == K:  # 해당 수에 도착
        print(visit_time[x])
        break
    if 0 <= x - 1 < MAX and visit_time[x - 1] == -1:
        visit_time[x - 1] = visit_time[x] + 1
        queue.append(x - 1)
    if 0 <= x * 2 < MAX and visit_time[x * 2] == -1:
        visit_time[x * 2] = visit_time[x]
        queue.appendleft(x * 2)      # 비용이 0인 경우를 가장 우선시하기 위해서 큐의 맨 앞으로 보냄
    if 0 <= x + 1 < MAX and visit_time[x + 1] == -1:
        visit_time[x + 1] = visit_time[x] + 1
        queue.append(x + 1)
