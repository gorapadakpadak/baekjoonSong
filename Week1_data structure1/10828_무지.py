import sys

stack = []
n = int(input())

for _ in range(n):
    str = sys.stdin.readline().strip()
    if str.startswith("push"):
        str_list = str.split()
        num = str_list[1]
        stack.append(num)
    elif str == "top":
        if len(stack) == 0:
            print(-1)
        else :
            print(stack[len(stack)-1])
    elif str == "pop":
        if len(stack) == 0:
            print(-1)
        else :
            print(stack.pop())
    elif str == "size":
        print(len(stack))
    elif str == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
