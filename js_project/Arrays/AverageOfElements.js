let a= new Array(10).fill(0);
let highest = a[0];
let lowest = a[0];
let sum = 0;
for (let i=0; i<a.length; i++){
    a[i]=i+1;
    console.log(a[i]);
}
console.log("original Sequence");
for (let i=0; i<a.length; i++){
    sum = sum + a[i];
    if (a[i]>highest){
        highest = a[i];
    }
    if (a[i]<lowest){
        lowest=a[i];
    }

}
let filteredSum = sum- highest- lowest;
let average = filteredSum/a.length - 2;
console.log(sum," sum");
console.log(highest," highest");
console.log(lowest," lowest");
console.log(filteredSum);
console.log(average);