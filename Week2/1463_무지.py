import sys
input = lambda : sys.stdin.readline().strip()

num = int(input())
dp = [0] * 1000001

for i in range(2, num+1):
    # 1을 뺏을 때 - 그냥 처음부터 1 뺏다고 가정
    dp[i] = dp[i - 1] + 1
    if i % 3 == 0:
        dp[i] = min(dp[i // 3] + 1, dp[i])   # 3으로 나눈게 더 작으면 바꾸기
    if i % 2 == 0:
        dp[i] = min(dp[i // 2] + 1, dp[i])   
    if i % 6 == 0:
        dp[i] = min(dp[i // 2]+1, dp[i // 3] + 1, dp[i])

print(dp[num])
