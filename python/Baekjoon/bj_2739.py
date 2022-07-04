import sys

n = int(sys.stdin.readline())
[print(n, '*', i, '=', n * i) for i in range(1, 10)]