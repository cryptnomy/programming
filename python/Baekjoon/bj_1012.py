'''import sys
read = sys.stdin.readline

cases = int(read())
m, n, k = map(int, read().split())
cabbage_map = [[0 for _ in range(n)] for _ in range(m)]
visited = []
worm = 0

def dfs(G, x, y):
    if (x < 0 or x > m-1) or (y < 0 or y > n-1) or (G[x][y] == 0):
        return
    if (x, y) in visited:
        return
    else:
        visited.append((x, y))
    dfs(G, x-1, y)
    dfs(G, x+1, y)
    dfs(G, x, y-1)
    dfs(G, x, y+1)
    worm += 1

for _ in range(k):
    x, y = map(int, read().split())
    cabbage_map[x][y] = 1
for i in range(m):
    for j in range(n):
        dfs(cabbage_map, i, j)
print(worm)'''

import sys
read = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (-1 < nx < n) and (-1 < ny < m):
            if cabbage_map[nx][ny] == 1:
                cabbage_map[nx][ny] = -1
                dfs(nx, ny)

cases = int(read())
for _ in range(cases):
    m, n, k = map(int, read().split())
    cabbage_map = [[0 for _ in range(m)] for _ in range(n)]
    num_worms = 0
    for _ in range(k):
        q, p = map(int, read().split())
        cabbage_map[p][q] = 1
    for i in range(n):
        for j in range(m):
            if cabbage_map[i][j] > 0:
                dfs(i, j)
                num_worms += 1
    print(num_worms)