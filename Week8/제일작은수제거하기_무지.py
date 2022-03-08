# 내 풀이
def solution(arr):
    temp = sorted(arr)
    tempnum = temp.pop(0)
    arr.remove(tempnum)
    if not arr:
        arr.append(-1)
    return arr
