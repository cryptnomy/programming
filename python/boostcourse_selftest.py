def solution(arr):
    from collections import Counter

    ret = [v for v in Counter(arr).values() if v > 1]
    return ret if ret else [-1]

if __name__ == '__main__':
    arr = [3, 2, 4, 4, 2, 5, 2, 5, 5]
    # arr = [3, 5, 7, 9, 1]
    ans = solution(arr)
    print(ans)