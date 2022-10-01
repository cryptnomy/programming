# import sys
# read = sys.stdin.readline

# n, m = map(int, read().split())
# d = sorted(list(map(int, read().split())))
# arr = []

# def dfs(i):
#     if len(arr) == m:
#         print(' '.join(map(str, arr)))
#         return
#     for j in range(i, n):
#         arr.append(d[j])
#         dfs(j)
#         arr.pop()
# dfs(0)

from itertools import combinations_with_replacement

n, m = map(int, input().split())
arr = sorted(map(int, input().split()))

print("\n".join(map(" ".join, combinations_with_replacement(map(str, arr), m))))