let a= [1,2,3,4,5];
let b = [];
console.log(a);
let runningTotal = 0;
for (let num of a){
    runningTotal = runningTotal + num;
    b.push(runningTotal);
}
console.log(b)