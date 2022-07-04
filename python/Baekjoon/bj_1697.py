import sys
from collections import deque

def bfs_visit(visited, n, target):
    q = deque([n])
    while q:
        u = q.popleft()
        if u == target:
            return visited[u]
        for v in (u-1, u+1, 2*u):
            if 1 < v < 100001 and not visited[v]: # not visited[v] and -1 < v < 1000001 로 하면 안 됨..
                visited[v] = visited[u] + 1
                q.append(v)
n, target = map(int, sys.stdin.readline().split())
visited = [0] * 100001
print(bfs_visit(visited, n, target))