const users = [];
const user1 = {
    id: 1,
    name: 'kim',
    region: 'seoul'
}
const user2 = {
    id: 2,
    name: 'lee',
    region: 'gyeong-gi'
}

//create(생성)
users.push(user1);
users.push(user2);

console.log(users.length);
console.log(users);
// 배열에서의 기본적인 조회
for (let i = 0; i < users.length; i++) {
    if (users[i].id == 1) {
        // 이름 변경
        users[i].name = 'park'
        console.log(users[i]);
    }
}
users.splice(0,1); // splice : 지우는 메서드 (지우고자하는 인덱스, 인덱스 갯수 )