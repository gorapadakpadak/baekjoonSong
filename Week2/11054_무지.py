import sys 
input = lambda : sys.stdin.readline().strip()

n = int(input())
lst = list(map(int, input().split()))
dp_left = [1] * n
dp_right = [1] * n


for i in range(n):
    for j in range(i):
        if lst[j] < lst[i]:
            if dp_left[i] < dp_left[j] + 1:
                dp_left[i] = dp_left[j] + 1

for i in range(n - 1, -1, -1):
    for j in range(n - 1, i, -1):
        if lst[j] < lst[i]:
            if dp_right[i] < dp_right[j] + 1:
                dp_right[i] = dp_right[j] + 1

dp = [dp_left[i] + dp_right[i] for i in range(n)]

print(max(dp) - 1)
