import sys
read = sys.stdin.readline

n, limit = map(int, read().rstrip().split())
li = list(sorted(map(int, read().rstrip().split()), reverse=True))
answer_set = set()
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            tmp = li[i]+li[j]+li[k]
            if tmp == limit:
                print(tmp)
                sys.exit()
            else:
                if tmp < limit:
                    answer_set.add(tmp)
                    break
print(max(answer_set))