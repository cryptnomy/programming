'''from sys import stdin

n = int(stdin.readline().strip())
print(sorted([int(stdin.readline().strip()) for _ in range(n)]))
'''

import sys

read = sys.stdin.readline

n = int(read())
lst = sorted([int(read()) for _ in range(n)])
print('\n'.join(map(str, lst)))