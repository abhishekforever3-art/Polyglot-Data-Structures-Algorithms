let a= [3,4,5,6,7,5,4,3];
let target = 5;
let firstIndex = -1;
let lastIndex = -1;
for (let i=0; i<a.length; i++){
    if (a[i]==target){
        if (firstIndex==-1){
            firstIndex= i;
        }
        lastIndex=i;
    }
}
console.log(target+" is the target number");
console.log (firstIndex);
console.log(lastIndex);