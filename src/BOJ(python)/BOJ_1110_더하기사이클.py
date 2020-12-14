temp = N = int(input())
count = 0
while True:
    A = tmp//10
    B = tmp%10
    result = A + B
    count += 1
    temp = int(str(temp%10)+str(result%10))
 
    if (N==temp):
        break
print(count)