import sys
read = sys.stdin.readline

n = int(read())
tri = []
for _ in range(n):
    tri.append(list(map(int, read().split())))
    
for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            tri[i][j] += tri[i-1][j]
        elif j == i:
            tri[i][j] += tri[i-1][j-1]
        else:
            tri[i][j] += max(tri[i-1][j-1], tri[i-1][j])

print(max(tri[n-1]))