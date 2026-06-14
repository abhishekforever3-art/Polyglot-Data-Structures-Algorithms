a = [1, 2, 3, 4]
b = []
running_total = 0
for num in a:
    running_total = running_total + num
    b.append(running_total)
print(b)