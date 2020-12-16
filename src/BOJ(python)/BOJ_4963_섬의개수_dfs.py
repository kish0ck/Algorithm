import sys
sys.stdin = open("input.txt","rt")
sys.setrecursionlimit(10**5)

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]

def dfs(x,y):
    visit[x][y] = 1

    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < h and 0 <= ny < w and visit[nx][ny] == 0 and graph[nx][ny] == 1:
            graph[nx][ny] = 0
            dfs(nx,ny)


while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break

    visit = [[0] * w for _ in range(h)]
    graph = []
    for _ in range(h):
        graph.append(list(map(int, sys.stdin.readline().split())))

    cnt = 0
    for i in range(h):
        for j in range(w):
            if visit[i][j] == 0 and graph[i][j] == 1:
                dfs(i, j)
                cnt += 1

    print(cnt)