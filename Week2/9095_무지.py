import sys
input = lambda : sys.stdin.readline().strip()

def sol(num):
    for i in range(4, num+1):
        a, b, c = i-3, i-2, i-1
        list.append(list[a] + list[b] + list[c])
    return list[num]

n = int(input())
for _ in range(n):
    num = int(input())
    list = [0, 1, 2, 4]
    print(sol(num))
