import sys

read = sys.stdin.readline

# def bfs(start):
#     visited = [-1] * (V+1)
#     visited[start] = 0
#     q = [start]
#     node, dist = 0, 0
#     while q:
#         u = q.pop(0)
#         for v, w in adj[u]:
#             if visited[v] == -1:
#                 visited[v] = visited[u] + w
#                 q.append(v)
#                 if dist < visited[v]:
#                     node, dist = v, visited[v]
#     return node, dist

def bfs(start):
    q = [(start, 0)]
    visited = [0] * (V+1)
    max_index, max_dist = start, 0
    visited[start] = 1
    while q:
        u, dist = q.pop(0)
        if max_dist < dist:
            max_index, max_dist = u, dist
        for v, w in adj[u]:
            if visited[v] == 0:
                q.append((v, dist + w))
                visited[v] = 1
    return max_index, max_dist

V = int(read()) # V \in [2, 100_000]
adj = [[] for _ in range(V+1)]
for _ in range(V):
    node, *links, _ = [int(i) for i in read().split()]
    for i in range(0, len(links), 2):
        adj[node].append((links[i:i+2]))

node, dist = bfs(1)
_, dist = bfs(node)
print(dist)
