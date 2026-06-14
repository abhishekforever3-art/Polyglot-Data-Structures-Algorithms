let a= new Array (5).fill(0);
for (let i=0; i<a.length; i++){
    a[i]=(i+1)*2.5;

}
console.log (a.join(" "));

let min = a[0];
let max = a[0];
for (let i=0; i<a.length; i++){
    if(a[i]<min){
        min=a[i];
    }
    if (a[i]>max){
        max=a[i];
    }

}
let difference = max- min;  
console.log(min+" is the min value");
console.log(max+" is the Max value");
console.log(difference+" is the difference");