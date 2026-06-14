let a = [1,0,3,0,12,14,0];
let track = 0;
for (let i=0; i<a.length; i++){
    if (a[i]!==0){
        let temp = a[i];
        a[i]=a[track];
        a[track]= temp;
        track++

    }
    
}
console.log("After Shifting: ", a);
