let a= new Array(10).fill(0);
let b= new Array(10).fill(0);
for (let i=0; i<a.length; i++){
    a[i]= i+1;
    if(i%2==0){
        console.log(i);
    }
}
console.log("even sequence");
for (let i=0; i<b.length; i++){
    b[i]=i+1;
    if(i%2!=0){
        console.log(i);
    }
}
console.log("odd sequence")
