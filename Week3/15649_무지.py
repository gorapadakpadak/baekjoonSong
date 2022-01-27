import sys
import itertools
input = lambda : sys.stdin.readline().strip()

N, M = map(int, input().split())
arr = [int(i)+1 for i in range(N)]
new_l = list(map(' '.join,itertools.permutations(map(str, arr), M)))
for e in new_l:
    print(e)
