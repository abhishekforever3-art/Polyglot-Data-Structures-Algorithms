
let arr = [16, 17, 4, 3, 5, 2];

console.log("Original Array:", arr);


let leaders = [];

let maxFromRight = arr[arr.length - 1];
leaders.push(maxFromRight);

for (let i = arr.length - 2; i >= 0; i--) {

    if (arr[i] > maxFromRight) {
        
        maxFromRight = arr[i];
        
        leaders.push(maxFromRight);
    }
}


leaders.reverse();

console.log("Leaders Found:", leaders);