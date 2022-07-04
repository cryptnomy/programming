def solution(genres, plays):
    answer = []
    hash_map1 = {}
    hash_map2 = {}
    
    for i, (g, p) in enumerate(zip(genres, plays)):
        if g not in hash_map1:
            hash_map1[g] = [(i, p)]
        else:
            hash_map1[g].append((i, p))
        if g not in hash_map2:
            hash_map2[g] = p
        else:
            hash_map2[g] += p
    
    for (k, v) in sorted(hash_map2.items(), key=lambda x: x[1], reverse=True):
        for (i, p) in sorted(hash_map1[k], key=lambda x: x[1], reverse=True)[:2]:
            answer.append(i)
            
    return answer

if __name__ == '__main__':
    # genres                                            plays                       return
    # ["classic", "pop", "classic", "classic", "pop"]   [500, 600, 150, 800, 2500]  [4, 1, 3, 0]
    genres = ["classic", "pop", "classic", "classic", "pop"]
    plays = [500, 600, 150, 800, 2500]
    
    ans = solution(genres, plays)

    print(ans)