# 내 풀이
def solution(n):
    sqrt = n**(1/2)
    if sqrt.is_integer() :
        return (sqrt+1)**2
    else:
        return -1
