let a = [];
for (let i =0; i<10; i++){
    let value = (i+1)*5;
    a.push(value);

}
//console.log(a);
let reverse =[];
for (let i= a.length-1; i>=0; i--){
    reverse.push(a[i]);
}
console.log(reverse.join(" "))