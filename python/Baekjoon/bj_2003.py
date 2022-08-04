import sys

read = sys.stdin.readline

N, M = map(int, read().split())
nums = list(map(int, read().split()))
# Two pointer method - p1, p2
p1, p2, cnt, psum = 0, 0, 0, nums[0] # partial sum
while True:
    if psum == M:
        cnt += 1
        psum -= nums[p1]
        p1 += 1
    elif psum > M:
        psum -= nums[p1]
        p1 += 1
    else: # psum < M
        if p2 == N - 1:
            break
        p2 += 1
        psum += nums[p2]
print(cnt)
