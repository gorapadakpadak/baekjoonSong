"""
문제 요약
n마리 중 n/2마리 데려갈 수 있음.
종류에 따른 번호 지님. ->같은 종류의 폰켓몬은 같은 번호 지님
가질 수 있는 폰켓몬 종류 수의 최댓값을 구해라

문제 접근
max(nums)+1의 크기 배열을 만들고, 인덱스에 해당 종류 폰켓몬 개수 저장.
arr.remove(0) 후
    arr len이 n/2보다 크면 n/2 리턴.
    아닌 경우 arr len 리턴
"""

def solution(nums):

    n = len(nums)
    
    arr = [0]*(max(nums)+1)
    for i in nums:
        arr[i] += 1
        
    arr.sort()
    idx = 0
    while arr[idx] == 0:
        idx += 1
    arr = arr[idx:]
        
    length = len(arr)
    
    if length >= n/2:
        return n/2
    else:
        return length
    