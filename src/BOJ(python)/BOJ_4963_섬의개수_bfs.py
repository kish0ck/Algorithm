import sys
from collections import deque

while True:
    # 지도의 너비와 높이
    w, h = map(int, sys.stdin.readline().split(" "))

    # 입력의 마지막 줄에는 0이 두 개 주어진다.
    if w == 0 and h == 0:
        break

    # 인풋 지도 받기
    field = []
    for _ in range(h):
        field.append(list(map(int, sys.stdin.readline().split(" "))))

    # 방문 배열
    visited = [[0 for _ in range(w)] for _ in range(h)]

    dr = [1, 1, 1, 0, 0, -1, -1, -1]
    dc = [-1, 0, 1, -1, 1, -1, 0, 1]

    # bfs
    count = 0
    queue = deque()
    for i in range(h):
        for j in range(w):
            if field[i][j] == 1 and visited[i][j] == 0:
                queue.append([i, j])
                visited[i][j] = 1
                count += 1

                while queue:
                    x, y = queue.popleft()

                    for k in range(8):
                        ndr = x + dr[k]
                        ndc = y + dc[k]

                        # 범위 안에 들어오고, 방문한적 없고, 땅일때
                        if 0 <= ndr < h and 0 <= ndc < w and visited[ndr][ndc] == 0 and field[ndr][ndc] == 1:
                            visited[ndr][ndc] = 1
                            queue.append([ndr, ndc])

    print(count)