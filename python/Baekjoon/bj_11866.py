import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
deq = deque([i for i in range(1, n + 1)])
Josephus = []
for _ in range(n):
    for _ in range(k - 1):
        deq.append(deq.popleft())
    Josephus.append(str(deq.popleft()))
print('<' + ', '.join(Josephus) + '>')