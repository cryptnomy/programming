import sys
from itertools import permutations
read = sys.stdin.readline

n = int(read())
command, *args = map(int, read().split())
p = list(permutations(range(1, n+1), n))
if command == '1':
    print(' '.join(map(str, p[args[0] - 1])))
else:   # command == '2'
    print(p.index(tuple(args)) + 1)
