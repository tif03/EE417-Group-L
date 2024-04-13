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

// Listen to the specified port
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server started on port ${PORT}`);
});
