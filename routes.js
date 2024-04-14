const express = require('express');
const app = express();

// Get the css
app.use('/css', express.static(__dirname + '/css'));

// Route for dashboard.html
app.get('/dashboard', (req, res) => {
    res.sendFile(__dirname + '/dashboard.html');
});

// Route for login_signup.html
app.get('/login_signup', (req, res) => {
    res.sendFile(__dirname + '/login_signup.html');
});

// Route for calendar.html
app.get('/calendar', (req, res) => {
    res.sendFile(__dirname + '/calendar.html');
});

// Route for map.html
app.get('/map', (req, res) => {
    res.sendFile(__dirname + '/map.html');
});

// Route for room.html
app.get('/room', (req, res) => {
    res.sendFile(__dirname + '/room.html');
});

// Route for weather.html
app.get('/weather', (req, res) => {
    res.sendFile(__dirname + '/weather.html');
});

// Listen to the specified port
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server started on port ${PORT}`);
});
