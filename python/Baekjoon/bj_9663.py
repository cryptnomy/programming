import sys
read = sys.stdin.readline

def is_q_safe(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:
            return False
    return True

def dfs(x):
    global cnt
    if x == n:
        cnt += 1
    else:
        for i in range(n):
            row[x] = i
            if is_q_safe(x):
                dfs(x+1)

n = int(read())
row = [0] * n
cnt = 0
dfs(0)
print(cnt)

'''
answer = [0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596]
print(answer[int(input())])
'''