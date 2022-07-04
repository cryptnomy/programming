from collections import deque

MAX = 100_001

def search(n):
    visited = [0] * MAX
    q = deque()
    q.append(n)
    while q:
        pos = q.popleft()
        if pos == k:
            return visited[pos]
        for next_pos in (pos+1, pos-1, pos*2):
            if -1 < next_pos < MAX:
                if visited[next_pos] == 0:
                    if next_pos == pos*2 and next_pos != 0:
                        visited[next_pos] = visited[pos]
                        q.appendleft(next_pos)
                    else:
                        visited[next_pos] = visited[pos] + 1
                        q.append(next_pos)

n, k = map(int, input().split())
ans = search(n)
print(ans)