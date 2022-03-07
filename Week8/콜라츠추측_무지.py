# 내 풀이
def solution(num):
    count = 0
    while count <= 500:
        if num == 1:
            return count
        if num % 2 == 0:
            num /= 2
            count += 1
        else:
            num = num * 3 + 1
            count += 1
    return -1

# 다른 사람 풀이
def solution(num):
    for i in range(500):
        if num == 1:
            return i
        num = num / 2 if num % 2 == 0 else num * 3 + 1
    return -1
© 2022 GitHub, Inc.
Terms
Privacy
Security
Status
Doc
