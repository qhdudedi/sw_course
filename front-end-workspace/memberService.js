const express = require('express');

const app = express();
// 서버 준비
app.listen(3300, () => {
    console.log('Server Running at http://localhost:3300');
});
app.use(express.urlencoded({
    extended: false
}));

// 요청 처리 
let userCounter = 0;
const users = [];

// 전체 조회 
app.get('/user', (request, response) => {
    response.send(users);
});
//조건 조회
app.get('/user/:id', (request, response) => {
    // id 추출한 다음 해당 id의 user를 검색해서 클라이언트로 전송(param/query/body 3가지로 보낼 수 있음)
    let id = request.params.id;
    let member = {};
    for (let i = 0; i < users.length; i++) {
        if (users[i].id == id) {
            member = users[i];
        }
    }
    response.send(member);

});
// 삽입
app.post('/user', (request, response) => {
    const body = request.body;
    const member = {
        id: userCounter++,
        name: body.name,
        region: body.region
    }
    users.push(member);
    response.send(member);
});
// 수정 
app.put('/user/:id', (request, response) => {
    let id = request.params.id;
    const body = request.body;
    let member = {};
    for (let i = 0; i < users.length; i++) {
        if (users[i].id == id) {
            users[i].name = body.name;
            users[i].region = body.region;
            member = users[i]; // user정보를 for문 밖에서 출력하기 위해
        }
    }
    response.send(member);
});
// 삭제 
app.delete('/user/:id', (request, response) => {
    let id = request.params.id;
    let index = 0;
    for(let i=0; i<users.length; i++){
        if(users[i].id == id){
            index = i;
        }
    }
    const member = users.splice(0,1);
    response.send(member);
 });