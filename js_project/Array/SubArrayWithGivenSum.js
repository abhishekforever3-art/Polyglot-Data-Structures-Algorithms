let n = [1,2,3,4,5,6,7,8,9];
let target = 15;
let sum = 0;
let start = 0;
let found = false;
for (let i=0; i<n.length; i++){
    sum = sum +n[i];
    while (sum > target && start <= i){
        sum = sum-n[start++];
    }
    if (sum==target){
        console.log("Sum found between indexes: " , start , " and " , i);
        found =true;
        return;
    }
}
console.log("No subarray found");
