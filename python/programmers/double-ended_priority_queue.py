import heapq

def solution(operations):
    pq = []
    for op in operations:
        c, num = op.split()
        if c == "I":
            heapq.heappush(pq, int(num))
        else:
            if pq:
                if num == '1':  # remove max
                    pq.pop(pq.index(heapq.nlargest(1, pq)[0]))
                else:   # remove min
                    heapq.heappop(pq)
    if not pq:
        return [0, 0]
    return [heapq.nlargest(1, pq)[0], pq[0]]

if __name__ == "__main__":
    # operations = ["I 16", "I -5643", "D -1", "D 1",
    #                 "D 1", "I 123", "D -1"] # return [0, 0]
    operations = ["I -45", "I 653", "D 1", "I -642",
                    "I 45", "I 97", "D 1", "D -1", "I 333"] # return [333, -45]
    answer = solution(operations)
    print(answer)