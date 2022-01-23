import sys
import math
input = lambda : sys.stdin.readline().strip()

N = int(input())
house = [list(map(int, input().split()) for _ in range(N))]
dp = [[0]*3 for _ in range(N)]
result = math.inf

for k in range(3):
    for i in range(3):
        if k == i:
            dp[0][i] = house[0][i]
        else:
            dp[0][i] = math.inf

    for i in range(1, N):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + house[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + house[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + house[i][2]

    for i in range(3):
        if i != k:
            result = min(result, dp[-1][i])

print(result)
