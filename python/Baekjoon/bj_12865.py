import sys
read = sys.stdin.readline

n, k = map(int, read().split())
cache = [0] * (k+1)
for _ in range(n):
    w, v = map(int, read().split())
    for i in range(k, w-1, -1):
        # reason for reversed order?
        # to refer to unupdated data
        cache[i] = max(cache[i-w] + v, cache[i])
#    print(cache)
print(cache[-1])