def solution(participant, completion):
    answer = {}
    for p in participant:
        answer[p] = answer.get(p, 0) + 1
    for c in completion:
        answer[c] -= 1
    for person in answer:
        if answer[person]:
            return person

if __name__ == '__main__':
    # participant                                       completion                                  return
    # ["leo", "kiki", "eden"]                           ["eden", "kiki"]                            "leo"
    # ["marina", "josipa", "nikola", "vinko", "filipa"] ["josipa", "filipa", "marina", "nikola"]    "vinko"
    # ["mislav", "stanko", "mislav", "ana"]             ["stanko", "ana", "mislav"]                 "mislav"
    participant = ["marina", "josipa", "nikola", "vinko", "filipa"]
    completion = ["josipa", "filipa", "marina", "nikola"]

    ans = solution(participant, completion)

    print(ans)

'''
from collections import Counter

def solution(participant, completion):
    answer = Counter(participant) - Counter(completion)
    return list(answer.keys())[0]
'''