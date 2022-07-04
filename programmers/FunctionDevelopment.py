def solution(progresses, speeds):
    answer = []
    time = 0
    cnt = 0
    
    while progresses:
        if (progresses[0] + time * speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            cnt += 1
        else:
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
            time += 1
    answer.append(cnt)
    
    return answer

if __name__ == '__main__':
    # progresses                speeds              return
    # [93, 30, 55]              [1, 30, 5]          [2, 1]
    # [95, 90, 99, 99, 80, 99]  [1, 1, 1, 1, 1, 1]  [1, 3, 2]
    progresses = [93, 30, 55]
    speeds = [1, 30, 5]
    
    ans = solution(progresses, speeds)

    print(ans)