import sys
read = sys.stdin.readline

n, m = map(int, read().split())
s = []
def dfs(i):
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    for j in range(i, n+1):
        s.append(j)
        dfs(j)
        s.pop()
dfs(1)
