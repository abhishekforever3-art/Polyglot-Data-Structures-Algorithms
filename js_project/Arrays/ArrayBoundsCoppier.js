let l=5;
let p = 10;
let q = 2;
let a= new Array(l).fill(0);
let b= new Array(a.length).fill(0);
for (let i=0; i<a.length; i++){
    a[i]=i+1*p;
    console.log(a[i]);
}
console.log("Sequence of A");
for (let i=0;i<b.length; i++){
    b[i]=i+1*10;
    console.log(a[i]);
}
console.log("Sequence of B ");
for (let i=0; i<b.length; i++){
    if (i%2!=0){
        b[i]= b[i]*q;
        console.log(b[i]);
    }
}
console.log("multiples of 2");
for (let i=0; i<b.length; i++){
    console.log(b[i])
}
console.log("replaced odd positions with 2 multiples")