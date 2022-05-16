document.addEventListener('DOMContentLoaded', () => {
    let password = document.querySelector("#password"),
        confirmPassword = document.querySelector("#passwordRepeat");

    confirmPassword.addEventListener('input', () => {
        checkConfirmPassword(password, confirmPassword);
    });

    password.addEventListener('input', () => {
        checkConfirmPassword(password, confirmPassword);
    });

    function checkConfirmPassword(password, confirmPassword) {
        if (password.value !== confirmPassword.value) {
            confirmPassword.style.borderColor = 'red';
        } else {
            confirmPassword.style.borderColor = password.style.borderColor;
        }
    }
})
