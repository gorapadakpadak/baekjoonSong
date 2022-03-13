def solution(arr1, arr2):
    len1 = len(arr1)
    len2 = len(arr1[0])
    for i in range(len1):
        for j in range(len2):
            arr1[i][j] += arr2[i][j]
    return arr1