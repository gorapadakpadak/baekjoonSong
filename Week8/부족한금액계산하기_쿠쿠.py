"""
문제 요약
(1p + 2p + 3p + ... + count*p) - money 를 리턴
"""

def solution(price, money, count):
    
    sum = 0
    
    for i in range(1, count+1):
        sum += i*price
    answer = sum-money
    answer = 0 if answer <= 0 else answer
    return answer