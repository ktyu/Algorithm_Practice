import sys

s = int(sys.stdin.readline().strip())
queue = []

# 첫 정점은 방문해서 걸린 시간 기록완료, 다음 정점들이 방문가능한지 봐야하므로 큐에 넣어둠
sec = {str((1, 0)) : 0}
queue.append((1, 0))  # screen's cnt, clipboard's cnt

# 반복문에서는 큐에 있는걸 꺼내서
# 다음 정점이 아직 방문안했으면 방문해서 비용 기록하고 방문가능한 다음 정점을 큐에 추가
while len(queue) != 0:

    # 큐에 있는거 꺼내서
    tu = queue.pop(0)

    ### 여기서 정답인지 검사하기보다 큐에 넣기전에 검사하는게 나음
    # # 큐에서 꺼낸게 정답이면 출력하고 끝
    # if tu[0] == s:
        # print(sec[str(tu)])
        # break
    ###
    
    
    # 다음 정점이 이미 방문되어 있지 않으면 비용(좀전에 꺼낸거 +1) 기록하고 큐에 넣음

    # copy to clipboard
    if tu[0] != tu[1] and sec.get(str((tu[0], tu[0]))) == None:
        sec[str((tu[0], tu[0]))] = sec[str(tu)] + 1
        queue.append((tu[0], tu[0]))

    # paste from clipboard
    if tu[1] != 0 and  sec.get(str((tu[0]+tu[1], tu[1]))) == None:
        sec[str((tu[0]+tu[1], tu[1]))] = sec[str(tu)] + 1
        if tu[0]+tu[1] == s:
            print(sec[str(tu)] + 1)
            break
        queue.append((tu[0]+tu[1], tu[1]))


    # delete 1
    if tu[0]-1 > 0 and sec.get(str((tu[0]-1, tu[1]))) == None:
        sec[str((tu[0]-1, tu[1]))] = sec[str(tu)] + 1
        if tu[0]-1 == s:
            print(sec[str(tu)] + 1)
            break
        queue.append((tu[0]-1, tu[1]))
