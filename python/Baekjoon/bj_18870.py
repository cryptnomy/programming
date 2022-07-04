import sys

read = sys.stdin.readline

n = int(read())
li_in = list(map(int, read().split()))
li_sorted = sorted(li_in)
cnt = 0
res = {li_sorted[0]: 0}
for i in range(1, n):
    if li_sorted[i] != li_sorted[i-1]:
        cnt += 1
    res.update({li_sorted[i]: cnt})
print(' '.join([str(res[li_in[i]]) for i in range(n)]))