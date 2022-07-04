'''def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_set = set(report)
    report_cnt = {user: 0 for user in id_list}
    for rep in report_set:
        report_cnt[rep.split()[1]] += 1
    for rep in report_set:
        if report_cnt[rep.split()[1]] >= k:
            answer[id_list.index(rep.split()[0])] += 1   
    return answer
'''
def solution(id_list, report, k):
    ans = [0] * len(id_list)
    report = set(report)    # Remove duplication
    report_cnt = {user: 0 for user in id_list}
    for rep in report:
        _, reported = rep.split()
        report_cnt[reported] += 1
    for rep in report:
        reporter, reported = rep.split()
        if report_cnt[reported] >= k:
            ans[id_list.index(reporter)] += 1
    return ans

if __name__ == '__main__':
    # id_list                               report                                                              k   result
    # ["muzi", "frodo", "apeach", "neo"]    ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]  2   [2, 1, 1, 0]
    # ["con", "ryan"]                       ["ryan con", "ryan con", "ryan con", "ryan con"]                    3   [0, 0]
    id_list = ["muzi", "frodo", "apeach", "neo"]
    report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
    k = 2

    ans = solution(id_list, report, k)

    print(ans)

'''def solution(id_list, report, k):
    n = len(id_list)
    ans = [0] * n
    report_dict = {user: set([]) for user in id_list}
    user_idx = {user: i for i, user in enumerate(id_list)}
    for r in report:
        reporter, reportee = r.split(' ')
        report_dict[reportee].add(reporter)
    for j in range(n):
        indiv_report = report_dict[id_list[j]]
        if len(indiv_report) >= k:
            for user in indiv_report:
                ans[user_idx[user]] += 1
    return ans'''