// Our helper block that reverses a specific section of a list in-place
function reverseSegment(arr, start, end) {
    while (start < end) {
        let temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

// Our starting array and rotation shift amount
let arr = [1, 2, 3, 4, 5];
let K = 2;

console.log("Before Rotation:", arr);

// Make sure K doesn't break if it's larger than the array length
K = K % arr.length; 

// Flip 1: Reverse the first K elements (positions 0 to 1)
reverseSegment(arr, 0, K - 1);

// Flip 2: Reverse the remaining elements (positions 2 to 4)
reverseSegment(arr, K, arr.length - 1);

// Flip 3: Reverse the entire list from head to tail (positions 0 to 4)
reverseSegment(arr, 0, arr.length - 1);

console.log("After Rotation: ", arr);