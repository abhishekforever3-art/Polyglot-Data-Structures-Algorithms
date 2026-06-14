let n= 4;


for (let i =n; i>=0; i--){
    let row = " "
    for(let j = 1; j<=n-i; j++){
        row = row+"*";
    }
    console.log(row)
}
for (let i =0; i<=n; i++){
    let row = " "
    for(let j = 0; j<=n-i; j++){
        row = row+"*";
    }
    console.log(row)
}