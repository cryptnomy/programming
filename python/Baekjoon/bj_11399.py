import sys
from itertools import accumulate
read = sys.stdin.readline

read()
li = sorted(list(map(int, read().split())))
print(sum(list(accumulate(li))))