let a=[11, 12, 15, 18 ];
let min = a[0];
let max = a[a.length-1];
let checklist = [];
for (let i = 0; i < a.length; i++) {
    let presentNumber = a[i];
    checklist[presentNumber] = true; 
}
console.log("The missing numbers are: ");
for (let i=min;i<=max; i++){
    if (checklist[i]){
        console.log(i," ")
    }
}