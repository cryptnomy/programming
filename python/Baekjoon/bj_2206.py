import sys
from collections import deque

read = sys.stdin.readline

n, m = map(int, read().split())
graph = [list(map(int, read().rstrip())) for _ in range(n)]
visited = [[[0, 0] for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(graph, visited, y, x, destroyed):
    q = deque()
    q.append((y, x, destroyed))
    while q:
        y, x, destroyed = q.popleft()
        if y == n-1 and x == m-1:
            return visited[y][x][destroyed]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > m-1 or ny < 0 or ny > n-1:
                continue
            if graph[ny][nx] == 0 and visited[ny][nx][destroyed] == 0:
                visited[ny][nx][destroyed] = visited[y][x][destroyed] + 1
                q.append((ny, nx, destroyed))
            elif graph[ny][nx] == 1 and destroyed == 0:
                visited[ny][nx][1] = visited[y][x][0] + 1
                q.append((ny, nx, 1))
    return -1
print(bfs(graph, visited, 0, 0, 0))