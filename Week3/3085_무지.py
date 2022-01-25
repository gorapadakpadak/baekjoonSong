import sys
input = sys.stdin.readline

# 행/열에서 사탕 최대 개수 구하는 함수
def check(candies):
    n = len(candies)
    answer = 1

    for i in range(n):
        count = 1
        # 열 순회하면서 연속되는 숫자 세기
        for j in range(1, n):
            if candies[i][j] == candies[i][j-1]:
                count += 1
            else:
                count =1
            if count>answer:
                answer = count

        count = 1
        # 행 순회하면서 연속되는 숫자 세기
        for j in range(1, n):
            if candies[j][i] == candies[j-1][i]:
                count += 1
            else:
                count = 1
            if count>answer:
                answer = count

    return answer


n = int(input())
candies = [list(input()) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(n):
        # 열 바꾸기
        if j+1 < n:
            candies[i][j], candies[i][j+1] = candies[i][j+1], candies[i][j]

            temp = check(candies)
            if temp > answer:
                answer = temp

            candies[i][j], candies[i][j+1] = candies[i][j+1], candies[i][j]

        # 행 바꾸기
        if i+1 < n:
            candies[i][j], candies[i+1][j] = candies[i+1][j], candies[i][j]

            temp = check(candies)
            if temp > answer:
                answer = temp

            candies[i][j], candies[i+1][j] = candies[i+1][j], candies[i][j]

print(answer)
