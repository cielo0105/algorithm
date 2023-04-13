n = int(input())
number = ['0','1','2','3','4','5','6','7','8','9']
num = ''
n_list = []
for _ in range(n):
	word = input()
	for i in word:
		if i in number:
			num += i
		else:
			if num != '':
				n_list.append(int(num))
				num = ''
	if num != '': 
		n_list.append(int(num))
		num = ''
n_list.sort()
for i in n_list:
	print(i)

