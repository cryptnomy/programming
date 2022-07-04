import sys
import heapq
read = sys.stdin.readline

res = []
for case in range(int(read())):
    k = int(read())
    min_heap, max_heap = [], []
    visited = [False] * k
    for i in range(k):
        cmd, num = read().split()
        num = int(num)
        if cmd == 'I':
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))
            visited[i] = True
        else:
            if num == 1:
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heapq.heappop(max_heap)
            else:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    res.append(f'{-max_heap[0][0]} {min_heap[0][0]}' if max_heap and min_heap else 'EMPTY')
print('\n'.join(res))