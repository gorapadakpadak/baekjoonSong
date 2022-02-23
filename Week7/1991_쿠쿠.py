import sys
input = sys.stdin.readline

n = int(input())

left = dict()
right = dict()

for _ in range(n):
    a, b, c = input().split()
    if b != '.':
        left[a]=b
    if c != '.':
        right[a]=c

#print(left)

# A / BC -> AB / D
def pre(s):
    print(s,end='')
    if s in left:
        pre(left[s])
    if s in right:
        pre(right[s])
    
def mid(s):
    
    if s in left:
        mid(left[s])
    print(s,end='')
    if s in right:
        mid(right[s])
def post(s):
    if s in left:
        post(left[s])

    if s in right:
        post(right[s])    
    print(s,end='')
#print('a' if left['A'] else 'b')

pre('A')
print()

mid('A')
print()
post('A')
