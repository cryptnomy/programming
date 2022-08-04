# import sys
# from itertools import accumulate
# read = sys.stdin.readline

# read()
# li = sorted(list(map(int, read().split())))
# print(sum(list(accumulate(li))))

import sys
read = sys.stdin.readline

N = int(read())
arr = sorted(map(int, read().split()))
print(sum([(N - i) * v for i, v in enumerate(arr)]))
