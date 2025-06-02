// form Validation

//selecting all input elements
const form = document.getElementById("form");
let inputName = document.getElementById("name");
let inputEmail = document.getElementById("email");
let inputPassword = document.getElementById("password");
let inputConfirmPassword = document.getElementById("confirm");


form.addEventListener("submit", (e) => {

  let userName = inputName.value.trim();
  let email = inputEmail.value.trim();
  let password = inputPassword.value.trim();
  // let confirm = inputConfirmPassword.value.trim();

  e.preventDefault();
  validateInputs();
  alert(isValidated)
  if(isValidated) {
    let users = JSON.parse(localStorage.getItem('users')) || [];

    users.push({
      username: userName,
      email: email,
      password: password
    });

    localStorage.setItem('users', JSON.stringify(users));
  }
});




const setError = (element, message) => {
  const form_control = element.parentElement;
  let errorDisplay = form_control.querySelector(".error");

  errorDisplay.innerText = message;
  form_control.classList.add("error");
  form_control.classList.remove("success");
};

const setSuccess = (element) => {
  const form_control = element.parentElement;
  let errorDisplay = form_control.querySelector(".error");

  errorDisplay.innerText = "";
  form_control.classList.add("success");
  form_control.classList.remove("error");
};

let isValidated = false;
const validateInputs = function () {

  let userName = inputName.value.trim();
  let email = inputEmail.value.trim();
  let password = inputPassword.value.trim();
  let confirm = inputConfirmPassword.value.trim();

  if (userName === "") {
    setError(inputName, "userName is required");
    console.log("evertime i am here ");
  } else if (!(userName.length > 2 && userName.length < 15)) {
    setError(inputName, "Name must be 3-15 characters");
    alert(userName.length);
  } else {
    setSuccess(inputName);
    isValidated = true
  }

  if (email === "") {
    setError(inputEmail, "Please enter an email");
  } else if (!email.endsWith("@gmail.com")) {
    setError(inputEmail, "Email must end with @gmail.com");
  } else {
    setSuccess(inputEmail);
    isValidated = true;
  }

  if (password === "") {
    setError(inputPassword, "Please enter a password");
  } else if (!(password.length >= 8)) {
    setError(inputPassword, "Password must be at least 8 characters");
  } else {
    setSuccess(inputPassword);
    isValidated = true;
  }

  if (confirm === "") {
    setError(inputConfirmPassword, "Please confirm password");
  } else if (confirm != password) {
    setError(inputConfirmPassword, "Password must match");
  } else {
    setSuccess(inputConfirmPassword);
  }
};

localStorage.clear();
