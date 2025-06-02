const z =  7
function kiiko() {
    let x = 9;
    var y = 8;
    console.log(z)

}
kiiko()
//console.log(x)
// console.log(y)

// variable Hoisting 
// you cant use let, const before initialization, 
// but you can use var and you will get undefined
console.log(beforeInitwithVar)
var beforeInitwithVar = 0;

//but in let and const you will get error cannot access before initialization.

// console.log(beforeInitwithLet)
let beforeInitwithLet = 1000;



//Equality
// ==, ===, object.is 
let m = 9;
console.log(m == '9');

// contorl flow
// 1.if else condition 
let age = 19;
if (age < 18) console.log("too young to vote")
else console.log("fill the form to vote!!!.")

// 2. switch 
let day = "monday"
switch (day) {
    case "sunday":
        console.log("today is off the work")
        break;
    case "monday":
        console.log("Today is starting the work")
        break;
    default:
        console.log("come early")
}

// loops for-loop, while-loop, do-while-loop, for in loop and for off loop
for (let i = 0; i < 5; i++) {
    console.log(++i)
}



//arrays 
let myNumbers = [12, 39, 45,99]
console.log(myNumbers)



