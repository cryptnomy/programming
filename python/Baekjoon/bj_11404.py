import sys

MAX = sys.maxsize
read = sys.stdin.readline

n = int(read())
m = int(read())
graph = [[MAX] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    u, v, w = map(int, read().split())
    if graph[u][v] > w:
        graph[u][v] = w
        
def floyd():
    for th in range(1, n+1): # through
        for fr in range(1, n+1): # from
            for to in range(1, n+1): # to
                if fr != to:
                    graph[fr][to] = min(graph[fr][to], graph[fr][th] + graph[th][to])

floyd()
for u in range(1, n+1):
    for v in range(1, n+1):
        if graph[u][v] == MAX:
            print(0, end=' ')
        else:
            print(graph[u][v], end=' ')
    print()