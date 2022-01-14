import sys
input = lambda : sys.stdin.readline().strip()

n = int(input())
stack, ans = [], []
count = 1
temp = True
for _ in range(n):
    num = int(input())
    while count <= num:
        stack.append(count)
        ans.append('+')
        count += 1

    if num == stack[-1]:
        stack.pop()
        ans.append('-')
    else:
        temp = False

if not temp:
    print('NO')
else:
    for i in ans:
        print(i)
