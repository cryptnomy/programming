'''
input consists of 4 lines:
1st line: N
2nd line: N space-separated (+) integers < 1B whose product = A
3rd line: M
4th line: M space-separated (+) integers < 1B whose product = B

output:
the greatest common divisor of A and B
'''

import math
import sys
read = sys.stdin.readline

n = int(read())
a = math.prod(list(map(int, read().split())))
m = int(read())
b = math.prod(list(map(int, read().split())))
gcd = str(math.gcd(a, b))
print(gcd if len(gcd) < 9 else gcd[-9:])

# # This method takes 2072 ms while the shortest record hits 68 ms
# # Bad due to 'factorize' method which does computation for all possible prime divisors
# # -> just determine gcd
# import math
# import sys
# from functools import reduce
# read = sys.stdin.readline

# def factorize(n):
#     '''
#     Factorize n in prime factors sorted in ascending order
#     '''
#     if (n < 4):
#         return [n]
#     ret = []
#     for p in range(2, int(math.sqrt(n)) + 1):
#         while n % p == 0:
#             ret.append(p)
#             n //= p
#     if (n != 1):
#         ret.append(n)
#     return ret

# def intersection(a, b):
#     ret = []
#     for value in a:
#         if value in b:
#             ret.append(value)
#             b.remove(value)
#     return ret
#     # return [elem for elem in a if elem in b]

# N = int(read())
# a = list(map(int, read().split()))
# M = int(read())
# b = list(map(int, read().split()))

# A = []
# for i in a:
#     A.extend(factorize(i))
# B = []
# for i in b:
#     B.extend(factorize(i))
# # print(A, B)
# gcd_pf = intersection(A, B)
# # print(gcd_pf)
# try:
#     gcd = reduce(lambda x, y: x * y, gcd_pf)
# except:
#     gcd = 1
# print(gcd if gcd < 1_000_000_000 else str(gcd)[-9:])
