
let arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4];


let currentSum = arr[0];
let maxSum = arr[0];


for (let i = 1; i < arr.length; i++) {
   
    currentSum = Math.max(arr[i], currentSum + arr[i]);
    
    
    maxSum = Math.max(maxSum, currentSum);
}

// Print out the highest sum found
console.log("Maximum Subarray Sum:", maxSum);