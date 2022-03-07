"""
문제 요약
한 번에 한 명의 유저 신고
신고 횟수 제한 없음.
한 유저 여러 번 신고 가능, but 동일 유저에 대한 신고 횟수 1회로 처리

k명 이상에게 신고된 유저는 게시판 이용 정지됨, 해당 유저 신고한 유저에게 정지 사실 메일로 발송
a가 신고한 유저 중, 게시판 이용 정지된 멤버 수가 result에 들어 감.

문제 접근

"""
def solution(id_list, report, k):
    answer = [0]*len(id_list)
    id_dict = dict()
    id_cnt = dict()
    for i in id_list:
        id_dict[i] = [] # i가 신고한 사람 저장
        id_cnt[i] = 0 # 신고된 횟수 저장
        
    for i in report:
        a, b = i.split()[0], i.split()[1]
        if b not in id_dict[a]:
            id_dict[a].append(b)
            id_cnt[b] += 1
    
    for i in id_list:
        if id_cnt[i] >= k:
            idx = 0
            for j in id_list:
                if i in id_dict[j]:
                    answer[idx] += 1
                idx += 1
    return answer