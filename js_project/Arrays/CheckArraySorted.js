let a= new Array(5).fill(0);
for (let i=0; i<a.length; i++){
    a[i]=(i+2)*5;
    console.log(a[i])
}
console.log("original Sequence");
let isSorted = true;

for (i=0; i<a.length; i++){
    if (a[i]>a[i+1]){
        isSorted = false;
        break;
    }
}
console.log("Is array Sorted", isSorted);
