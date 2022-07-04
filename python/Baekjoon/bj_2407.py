import sys

def fac(n):
    if n < 2:
        return 1
    return n * fac(n-1)

def comb(n, k):
    return fac(n)//fac(k)//fac(n-k)

n, k = map(int, sys.stdin.readline().split())
print(comb(n, k))