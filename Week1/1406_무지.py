import sys
input = lambda : sys.stdin.readline().strip()

str = list(input())
s = []
n = int(input())
cursor = len(str)

for _ in range(n):
    op = input().split()
    if op[0] == 'L' and len(str) != 0:
        s.append(str.pop())
    elif op[0] == 'D' and len(s) != 0:
        str.append(s.pop())
    elif op[0] == 'B' and len(str) != 0:
        str.pop()
    elif op[0] == 'P':
        str.append(op[1])

print(''.join(str + list(reversed(s))))
