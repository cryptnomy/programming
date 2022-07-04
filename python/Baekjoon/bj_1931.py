import sys
read = sys.stdin.readline

n = int(read())
schedule = tuple(tuple(map(int, read().split())) for _ in range(n))
schedule = sorted(schedule, key=lambda arr: arr[0])
schedule = sorted(schedule, key=lambda arr: arr[1])
end_time, cnt = 0, 0
for i, j in schedule:
    if i >= end_time:
        cnt += 1
        end_time = j
print(cnt)

'''import sys
read = sys.stdin.readline

n = int(read())
schedule = {}
for _ in range(n):
    start, end = map(int, read().split())
    if schedule.get(start):
        schedule[start].append(end)
    else:
        schedule[start] = [end]
for k in schedule.keys():
    schedule[k].sort()
keys = sorted(schedule.keys())
end, cnt = 0, 0
for key in keys:
    for e in schedule[key]:
        if e < end:
            end = e
        elif key >= end:
            cnt += 1
            end = e
print(cnt)'''