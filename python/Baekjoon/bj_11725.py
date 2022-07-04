'''import sys
read = sys.stdin.readline
sys.setrecursionlimit(1_000_000)

n = int(read())
tree = [[] for _ in range(n+1)]
parents = [0 for _ in range(n+1)]

for _ in range(n-1):
    u, v = map(int, read().split())
    tree[u].append(v)
    tree[v].append(u)

def dfs(start, tree, parents):
    for node in tree[start]:
        if parents[node] == 0:
            parents[node] = start
            dfs(node, tree, parents)
            
dfs(1, tree, parents)

for i in range(2, n+1):
    print(parents[i])'''

import sys
from collections import deque
read = sys.stdin.readline

n = int(read())
G = [[] for _ in range(n+1)]
parent = [0]*(n+1)
q = deque()
q.append(1)

for _ in range(n-1):
    u, v = map(int, read().split())
    G[u].append(v)
    G[v].append(u)

def bfs(G, q, parent):
    while q:
        u = q.popleft()
        for v in G[u]:
            if parent[v] == 0:
                parent[v] = u
                q.append(v)
            
bfs(G, q, parent)

for i in range(2, n+1):
    print(parent[i])