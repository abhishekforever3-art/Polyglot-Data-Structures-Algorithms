let n= 5
let num =0;
for (let i=1; i<=n; i++){
    let row = " "
    for (let j = 1;j<=i; j++ ){
        num++;
        row = row +num+ " "
    }
    console.log(row)
}