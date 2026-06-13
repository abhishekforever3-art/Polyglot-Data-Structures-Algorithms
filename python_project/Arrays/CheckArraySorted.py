a = [2, 5, 5, 8, 12]
is_sorted = True
for i in range(1, len(a)):
    if a[i] < a[i - 1]:
        is_sorted = False
        break  
print("Is the array sorted? " + str(is_sorted))