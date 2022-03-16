"""
문제 요약
Kim의 위치를 찾아 '김서방은 x에 있다'를 반환
"""
def solution(seoul):
    length = len(seoul)
    idx = 0
    for i in range(length):
        if seoul[i] == 'Kim':
            idx = i
            break
    answer = '김서방은 ' + str(idx) + "에 있다" 
    return answer