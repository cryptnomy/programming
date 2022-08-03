def solution(clothes):
    hash_map = {}
    for _, clothing_type in clothes:
        hash_map[clothing_type] = hash_map.get(clothing_type, 0) + 1
    answer = 1
    for clothing_type in hash_map:
        answer *= hash_map[clothing_type] + 1
    return answer - 1

if __name__ == '__main__':
    # clothes                                                                                   return
    # [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]  5
    # [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]              3
    clothes = [["yellowhat", "headgear"],
               ["bluesunglasses", "eyewear"],
               ["green_turban", "headgear"]]

    ans = solution(clothes)

    print(ans)

'''
def solution(clothes):
    from collections import Counter
    from functools import reduce
    cnt = Counter([clothing_type for _, clothing_type in clothes])
    answer = reduce(lambda x, y: x*(y+1), cnt.values(), 1) - 1
    return answer
'''