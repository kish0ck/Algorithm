input_data = int(input())
if(input_data%4==0 and (input_data%100!=0 or input_data%400==0)):
  print('1')
else :
  print('0')