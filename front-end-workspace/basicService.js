const express = require('express');

const app = express();

app.use((request, response) =>{
    response.send('<h1>Hello Express</h1>');
});

app.listen(3300, () =>{
    console.log('Server running at http://localhost:3300');
});