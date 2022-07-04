def solution(priorities, location):
    q_priority = [(i, p) for i, p in enumerate(priorities)]
    answer = 0
    while True:
        cur = q_priority.pop(0)
        # if cur[1] is not maximum
        if any(cur[1] < q[1] for q in q_priority):
            q_priority.append(cur)
        else:
            answer += 1
            if cur[0] == location:
                return answer

if __name__ == '__main__':
    # priorities            location    return
    # [1, 1, 9, 1, 1, 1]    0           5
    # [2, 1, 3, 2]          2           1
    priorities = [1, 1, 9, 1, 1, 1]
    location = 0
    
    ans = solution(priorities, location)

    print(ans)