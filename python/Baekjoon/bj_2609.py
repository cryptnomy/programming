import sys

m, n = map(int, sys.stdin.readline().strip().split())
q, r = m, n
while r != 0:
    q, r = r, q % r
print(q)
print(m * n // q)

"""
import sys

def gcd(m, n): # 최대공약수
    if n == 0:
        return m
    return gcd(n, m%n)

m, n = map(int, sys.stdin.readline().strip().split())
gcd = gcd(m, n)
print(gcd)
print(m * n // gcd)
"""

'''
import sys

a, b = map(int, sys.stdin.readline().strip().split())
mul = a * b
gcd = 1
while a > 0 and b > 0:
    if a < b:
        b -= a
        if b == 0:
            gcd = a
            break
    elif a > b:
        a -= b
        if a == 0:
            gcd = b
            break
    else:
        gcd = a
        break
print(gcd, mul // gcd)
'''