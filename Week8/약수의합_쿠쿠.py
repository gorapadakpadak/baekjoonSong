def solution(n):
    answer = []
    
    for i in range(1,n//2+1):
        if n%i==0:
            answer.append(i)
    answer.append(n)
    return sum(answer)