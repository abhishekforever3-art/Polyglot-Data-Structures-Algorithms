a = [0, 1, 0, 3, 12]
Zeros = 0
for i in range(len(a)):
    if a[i] != 0:
        temp = a[i]
        a[i] = a[Zeros]
        a[Zeros] = temp

        Zeros = Zeros + 1
print(a)