import sys
input = sys.stdin.readline

def preorder(v,ans):
    ans += v
    for i in tree[v]:
        if i == ".":
            continue
        ans = preorder(i,ans)
    return ans

def inorder(v,ans):
    if v == ".":
        return ans
    l,r = tree[v]
    ans = inorder(l,ans)
    ans += v
    ans = inorder(r,ans)
    return ans

def postorder(v,ans):
    if tree[v] == (".","."):
        return ans + v
    
    for i in tree[v]:
        if i == ".":
            continue
        ans = postorder(i,ans)
    return ans + v

n = int(input())
tree = dict()
for _ in range(n):
    v,l,r = input().rstrip().split()
    tree[v] = (l,r)
print(preorder("A",""))
print(inorder("A",""))
print(postorder("A",""))
