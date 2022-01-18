import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
dp = [0] * 1001

dp[1], dp[2] = 1, 2
for i in range(3, 1001):
    dp[i] = dp[i-1] % 10007 + dp[i-2] % 10007

print(dp[n] % 10007)
