const express = require('express');
const app = express();

// Route for dashboard.html
app.get('/dashboard', (req, res) => {
    res.sendFile(__dirname + '/dashboard.html');
});

// Route for login_signup.html
app.get('/login', (req, res) => {
    res.sendFile(__dirname + '/login_signup.html');
});

app.listen(3000, () => {
    console.log('Server started on port 3000');
});