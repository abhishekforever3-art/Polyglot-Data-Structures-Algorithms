
a = [16, 17, 4, 3, 5, 2]


leaders = []


max_from_right = a[-1]
leaders.append(max_from_right)


for i in range(len(a) - 2, -1, -1):
    
    
    if a[i] > max_from_right:
        
        max_from_right = a[i]
       
        leaders.append(a[i])


leaders.reverse()


print(leaders)