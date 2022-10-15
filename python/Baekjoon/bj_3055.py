import sys

read = sys.stdin.readline

R, C = map(int, read().split())
fields = [list(read()) for _ in range(R)]
dp = [[0] * C for _ in range(R)]
q, dist = [], 0

for r in range(R):
    for c in range(C):
        if fields[r][c] == 'S':     # source
            dp[r][c] = 1
            s = (r, c)
        if fields[r][c] == '*':     # flooded field
            dp[r][c] = 1
            q.append((r, c, True))  # True if flooded
q.append((s[0], s[1], False))       # False if source

while q and not dist:
    y, x, flooded = q.pop(0)
    for dy, dx in (-1, 0), (1, 0), (0, -1), (0, 1):
        ny, nx = y+dy, x+dx
        if -1 < ny < R and -1 < nx < C and not dp[ny][nx] and fields[ny][nx] != 'X':
            if fields[ny][nx] == 'D':
                if flooded:
                    continue
                dist = dp[y][x]
                break
            dp[ny][nx] = dp[y][x] + 1
            q.append((ny, nx, flooded))
print(dist if dist else "KAKTUS")
