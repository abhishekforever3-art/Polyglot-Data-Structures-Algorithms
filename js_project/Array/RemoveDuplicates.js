let a = [1,2,3,3,3,4,4,4,5,6,7,8,9];
let i =0;
for (let j=0; j<a.length; j++){
    if (a[i]!=a[j]){
        i++;
        a[i]=a[j];
    }
}
console.log("Array after removing duplicates:");
for (let k=0; k<=i;k++ ){
    console.log(a[k] , " ");
}