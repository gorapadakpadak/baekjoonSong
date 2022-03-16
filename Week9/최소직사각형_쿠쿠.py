"""
문제 요약
명함을 다 넣을 수 있는 가장 작은 사이즈의 지갑 찾기

"""

def solution(sizes):
    
    w = [i[0] for i in sizes]
    h = [i[1] for i in sizes]
    
    maxw = max(w)
    maxh = max(h)
    length = len(w)
    
    size1 = maxw*maxh
    
    for i in range(length):
        if w[i] < h[i]:
            w[i], h[i] = h[i], w[i]
    maxw = max(w)
    maxh = max(h)
    length = len(w)
    
    size2 = maxw*maxh
    
    return size1 if size1<size2 else size2