'''
n-th Fibonacci
n \in [1, 1_000_000_000_000_000_000]
input: n
output: n-th Fibonacci number divided by 1_000_000_007
'''

import sys
read = sys.stdin.readline
div = 1_000_000_007

def mat_mul(a, b):
    c = [[(a[0][0]*b[0][0] + a[0][1]*b[1][0]) % div,
          (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % div],
         [(a[1][0]*b[0][0] + a[1][1]*b[1][0]) % div,
          (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % div]]
    return c

n = int(read())
A = [[1, 1], [1, 0]]
B = [[1, 1], [1, 0]]
n -= 2

while n > 0:
    if n % 2 == 1:
        B = mat_mul(B, A)
    A = mat_mul(A, A)
    n //= 2

print(B[0][0] % div)

# First trial; success; but source from the Internet
# import sys
# read = sys.stdin.readline
# div = 1_000_000_007

# def mat_mul(a, b):
#     '''
#     matrix multiplicaiton
#     '''
#     p, q, r = len(a), len(b[0]), len(b)
#     c = [[0] * q for _ in range(p)]
#     for i in range(p):
#         for j in range(q):
#             c_ij = 0
#             for k in range(r):
#                 c_ij += a[i][k] * b[k][j]
#             c[i][j] = c_ij % div
#     return c

# def mat_power(A, n):
#     if n == 1:
#         return A
#     elif n % 2 == 1: # n ~ odd
#         return mat_mul(mat_power(A, n - 1), A)
#     else:   # n ~ even
#         return mat_power(mat_mul(A, A), n // 2)

# A = [[1, 1], [1, 0]]
# b = [[1], [1]]

# n = int(read())

# if n < 3:
#     print(1)
# else:
#     print(mat_mul(mat_power(A, n - 2), b)[0][0])
