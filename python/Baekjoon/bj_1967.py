import sys

read = sys.stdin.readline
sys.setrecursionlimit(1_000_000_000)

n = int(read())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u, v, w = map(int, read().split())
    graph[u].append([v, w])
    graph[v].append([u, w])

def traverse(graph, dist, u, w_u):
    for v_info in graph[u]:
        v, w_v = v_info
        if dist[v] == -1:
            dist[v] = w_u + w_v
            traverse(graph, dist, v, w_u + w_v)

dist = [-1] * (n+1)
dist[1] = 0
traverse(graph, dist, 1, 0) # arbitrary node 1

start = dist.index(max(dist))
dist = [-1] * (n+1)
dist[start] = 0
traverse(graph, dist, start, 0)

print(max(dist))