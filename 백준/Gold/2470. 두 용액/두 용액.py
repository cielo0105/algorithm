import sys
n = int(input())
n_list = list(map(int,sys.stdin.readline().split()))
start = 0
end = n-1
min_n = 2000000001
n_list.sort()

while start < end:
	num = n_list[end] + n_list[start]
	if num == 0:
		answer = [n_list[start],n_list[end]]
		break
	if abs(num) < min_n:
		answer = [n_list[start],n_list[end]]
		min_n = abs(num)
		
	if num > 0:
		end -= 1
	else:
		start += 1
	
print(*answer)
   