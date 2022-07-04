'''import sys
from collections import deque
read = sys.stdin.readline

col, row = map(int, read().split())
tomato_map = [list(map(int, read().split())) for _ in range(row)]

dr = (1, -1, 0, 0)
dc = (0, 0, 1, -1)

def is_surrounded(tomato_map, row, col):
    for r in range(row):
        for c in range(col):
            if tomato_map[r][c] != -1:
                surrounded = True
                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if -1 < nr < row and -1 < nc < col:
                        if tomato_map[nr][nc] != -1:
                            surrounded = False
                if surrounded:
                    return True
    return False

def bfs_visit(G, start):
    q = deque([start])
    while q:
        u = q.popleft(q)
굳이 surrounded 여부 체크할 필요없는 문제..
'''

import sys
from collections import deque
read = sys.stdin.readline

col, row = map(int, read().split())
G = []
q = deque([])
for i in range(row):
    G.append(list(map(int, read().split())))
    for j in range(col):
        if G[i][j] == 1:
            q.append((i, j))
dx, dy = ((1, -1, 0, 0), (0, 0, 1, -1))

def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if -1 < nx < row and -1 < ny < col and G[nx][ny] == 0:
                q.append((nx, ny))
                G[nx][ny] = G[x][y] + 1
bfs()
ans = 0
for row in G:
    for elem in row:
        if elem == 0:
            print(-1)
            exit(0)
    ans = max(ans, max(row))
print(ans - 1)