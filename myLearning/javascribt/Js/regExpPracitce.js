// taking RegularExpresion

// The string:
let text = "Hello world!";

// Look for "Hello"
let pattern1 = /Hello/g;
let result1 = pattern1.test(text);
console.log(result1)


//Making some Exercise.
//1. making username criteria.
let userNamePattern = /([a-z]{1}\.)([a-z]|[0-9]){3}/;
let name = "g.9087"
console.log("patern of name: "+ userNamePattern.test(name))

//2. making email criteria.
let emailPattern = /([A-Z]|[a-z]|[0-9])+\b@bigcorp.eu/;
let email = "1@bigcorp.eu";
console.log(emailPattern.test(email))




