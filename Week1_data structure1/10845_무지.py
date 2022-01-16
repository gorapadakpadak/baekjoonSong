import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
queue = []
for _ in range(n):
    op = input()
    if op == "size":
        print(len(queue))
    elif op == "pop":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue.pop(0))   # 큐의 맨 앞 원소 추출
    elif op == "empty":
        if len(queue) == 0:
            print(1)
        else :
            print(0)
    elif op == "front":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue[0])
    elif op == "back":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue[-1])
    elif op.startswith("push"):
        push = op.split()
        queue.append(push[1])
