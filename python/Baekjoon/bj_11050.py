# from sys import stdin

# def factorial(n):
#     if n == 0:
#         return 1
#     return n*factorial(n-1)

# n, k = map(int, stdin.readline().strip().split())
# print(factorial(n)//factorial(k)//factorial(n-k))

import sys

N, K = map(int, sys.stdin.readline().split())
pascal_triangle = [[-1] * (K+1)] * (N+1)

def choose(n, k):
    if k == 0 or k == n:
        return 1
    if pascal_triangle[n][k] != -1:
        return pascal_triangle[n][k]
    return choose(n-1, k-1) + choose(n-1, k)

print(choose(N, K))