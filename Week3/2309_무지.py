import sys

input = lambda: sys.stdin.readline().strip()

d = [int(input()) for _ in range(9)]

s = 0
for i in range(9):
    s += d[i]

for i in range(9):
    temp = d.pop(0)
    s -= temp
    if (s - 100) in d:
        d.remove(s-100)
        d.sort()
        print(*d, sep='\n')
        break
    else:
        d.append(temp)
        s += temp
