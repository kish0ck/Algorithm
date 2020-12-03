import sys

T = int(input())

for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    C = A+B
    print('Case #%d: %d + %d = %d' %((i+1),A,B,C))