# import sys

# input = sys.stdin.readline

# def sol1717():
#     n, m = map(int, input().split())
#     u = [-1] * (n+1)
#     answer = []
#     for _ in range(m):
#         cmd, a, b = map(int, input().split())
#         if cmd:
#             answer.append('YES' if find(u, a) == find(u, b) else 'NO')
#         else:
#             union(u, a, b)
#     return '\n'.join(answer)

# def union(u, a, b):
#     a = find(u, a)
#     b = find(u, b)
#     if a != b:
#         if u[a] < u[b]:
#             u[a] += u[b]
#             u[b] = a
#         else:
#             u[b] += u[a]
#             u[a] = b


# def find(u, x):
#     if u[x] < 0:
#         return x
#     u[x] = find(u, u[x])
#     return u[x]

# if __name__ == '__main__':
#     print(sol1717())

import sys

read = sys.stdin.readline

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if (a != b):
        parent[b] = a

def find(parent, x):
    if x == parent[x]:
        return x
    else:
        parent[x] = find(parent, parent[x])
        return parent[x]
    
def sol_1717():
    n, m = map(int, read().split())
    parent = list(range(n+1))
    answer = []
    
    for _ in range(m):
        cmd, a, b = map(int, read().split())
        if cmd == 0:
            union(parent, a, b)
        else:    # cmd == 1
            answer.append('YES' if find(parent, a) == find(parent, b) else 'NO')
    return '\n'.join(answer)

print(sol_1717())
