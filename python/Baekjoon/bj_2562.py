import sys

l = [sys.stdin.readline().strip() for _ in range(9)]
print(max(l))
print(l.index(max(l)) + 1)
