document.addEventListener('DOMContentLoaded', function(event) {
    const loginForm = document.getElementById('login');
    const registerForm = document.getElementById('register');
    const termsConditions = document.getElementById('TnC');
    const loginBtn = document.getElementById('loginBtn');
    const registerBtn = document.getElementById('registerBtn');
    const openTnCLink = document.getElementById('openTnC');

    // Toggle between forms
    loginBtn.addEventListener('click', function() {
        loginForm.style.left = "50px";
        registerForm.style.left = "450px";
    });

    registerBtn.addEventListener('click', function() {
        loginForm.style.left = "-400px";
        registerForm.style.left = "50px";
    });

    // Terms and conditions
    openTnCLink.addEventListener('click', function(event) {
        event.preventDefault();
        termsConditions.style.display = "block";
    });

    window.addEventListener('mouseup', function(event) {
        if (!termsConditions.contains(event.target)) {
            termsConditions.style.display = 'none';
        }
    });

    // Handle registration
    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();
        submitRegisterForm();
    });

    // Handle login
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission
        console.log("Login form submitted");

        const formData = new FormData(loginForm);
        const email = formData.get('email');
        const password = formData.get('password');

        fetch('/api/users/login', {  // Make sure to adjust the URL based on your API
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                console.log('Login successful');
                // Redirect to another page or update the UI as needed
            } else {
                console.error('Login failed: ' + data.message);
                // Show error message to the user
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    // Ensure the body is visible after everything is loaded
    document.body.style.opacity = 1;

    // Register new user
    function submitRegisterForm() {
        const formData = new FormData(registerForm);
        const userData = {
            enrollmentNumber: formData.get('enrollmentNumber'),
            email: formData.get('email'),
            password: formData.get('password')
        };

        fetch('/api/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            window.location.href = "login.html";  
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }
});
