function type1(){
    let data = 10;
    setTimeout(()=>{
        data =100;
    }, 3000); // 3초간 hold 후 출력
    console.log(data);
}
type1();

function type2(callback){
    let data = 10;
    setTimeout(()=>{
        data = 100;
        callback(data);
    },3000);
}

const cb = function myCallback(data){
    console.log(data);
}

type2(cb);

//지연 상황
//3초 뒤에(네트워크 연결, 파일 연결, 시간 지연) 데이터를 업데이트하고 해당 데이터를 출력한다.

function type3(callback){
    let data = 10;
    setTimeout(()=>{
        data = 100;
        callback(data);
    }, 3000); 
    // 지연된 내용을 기다린 후 업데이트하는 방식 - callback을 등록해준다.
   // console.log(data);
}

let cb2 = function (data){
    console.log(data);
}

function type3(){
    return new Promise(function(resolve, reject){
        let data =10;
        setTimeout(()=>{
            data =100;
            resolve(data);
        },3000);
    });
}

type3.then(function(result){
    console.log(result);
})

async function type4(){
    let result = await type3();
    console.log(result);
}

type4();