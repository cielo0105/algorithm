import sys
while 1:
    inp = sys.stdin.readline().rstrip()
    stack = []
    error = 0
    if inp == ".":
        break
    else:
        for i in inp:
            if i == "(":
                stack.append(i)
                
            elif i == ")":
                if len(stack) == 0:
                   
                    error = 1
                    break
                else:
                    if stack[-1] == "(":
                        stack.pop()
                    else:
                       
                        error = 1
                        break
            elif i == "[":
                stack.append(i)
            elif i == "]":
                if len(stack) == 0:
                  
                    error = 1
                    break
                else:
                    if stack[-1] == "[":
                        stack.pop()
                    else:
                     
                        error = 1
                        break
        if (error == 0) and (len(stack)==0):
            print("yes")            
        else:
            print("no")