
let a = [10, 20, 30, 40, 50];

console.log("Before Reverse:", a);


let left = 0;


let right = a.length - 1;


while (left < right) {

    let temp = a[left];
    
   
    a[left] = a[right];
    
    
    a[right] = temp;
    
    
    left++;
    
    
    right--;
}


console.log("After Reverse: ", a);