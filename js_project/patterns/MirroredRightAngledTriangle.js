let n = 5;
for (let j =1; j<=n; j++ ){
    let row = "";
    for (let i = 1; i<=n-j; i++){
        row = row+" ";
    }
    for (let i = 1; i<=j; i++){
        row = row+"*";
    }
    console.log(row)
}