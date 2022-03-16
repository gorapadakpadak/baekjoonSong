"""
문제 요약
민우의 로또 당첨 최고 순위와 최저 순위 알아보기

문제 접근
당첨 번호와 같은 수, 다른 수 확인.
여기서 다른 수만 다른 경우가 최고 순위.
모르는 수가 다 틀리는 경우가 최저 순위.
"""

def solution(lottos, win_nums):
    answer = []
    yes = 0
    no = 0
    zero = 0
    
    for i in range(6):
        if lottos[i] in win_nums:
            yes+=1
        elif lottos[i] != 0 and lottos[i] not in win_nums:
            no+=1
        elif lottos[i] == 0:
            zero += 1
            
    answer.append(7-yes if 7-yes< 7 else 6)
    answer.append(7-(yes+zero) if 7-(yes+zero) < 7 else 6)
    answer.sort()
    return answer