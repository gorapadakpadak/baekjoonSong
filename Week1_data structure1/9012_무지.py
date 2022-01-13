import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
for _ in range(n):
    ps = input()
    array= []
    for i in range(len(ps)):
        if ps[i] == '(':
            array.append('(')
        else:
            if len(array) != 0 and array[-1] == '(':
                array.pop()
            else :
                array.append(')')

    if len(array) == 0 :
        print("YES")
    else :
        print("NO")
