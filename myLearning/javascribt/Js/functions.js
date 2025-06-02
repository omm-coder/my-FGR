// function in js
//1 function declaration
greet(); //function declaration is hoisted one you can call before it's come

function greet(name) {
  console.log("Hello " + name);
}

greet("omar");

//printInfo() we can't acces here because it is not hoisted one
//2. function Expression
let printInfo = function (today) {
  console.log("today is: " + today);
};

printInfo("thursday");

// a function declaration returning value
console.log(
  "function declaration returnin a value and calling as hoisted, " + add(4, 9)
);
function add(a, b) {
  return a + b;
}
console.log(add(3, 4));

// a function Expression returning a value
let person = {
  name: "omm",
  age: 29,
};
const getName = function (obj) {
  return obj.name;
};

console.log(getName(person));

//3 arow function
//  console.log(subtract(99 - 34)) can;t call here
let subtract = (x, y) => {
  return x - y;
};
console.log(subtract(78, 65));

//make function logic which returns true if a passed number is an even or odd
let isEvenOrOdd = function (number) {
  if (number % 2 === 0) return "Even";
  if (number % 2 !== 0) return "Odd";
};

console.log("num 9 is even: " + isEvenOrOdd(98));

// arrow function make this logic geting the max number of 2 number

let getMax = (num1, num2) => {
  return num1 > num2 ? num1 : num2;
};
console.log(getMax(8, 9) + "  is max one");

//function capitalizing the first letter
function capitalize(letter) {
  return letter.charAt(0).toUpperCase() + letter.slice(1);
}
console.log(capitalize("omm"));

//Closure
let createGreeter = function (name) {
  return function () {
    console.log("Hello " + name);
  };
};
const greeter = createGreeter("ali");
greeter();

function secretHolder(secret) {
  let mySecret = secret;
  return {
    setSecret: function (secret) {
      mySecret = secret;
    },
    getSecret: function () {
      return mySecret;
    },
  };
}

let mySecret = secretHolder("pizza");
console.log(mySecret.getSecret());
mySecret.setSecret("tacos");
console.log(mySecret.getSecret());

// calling  function limited time
function sayHello() {
  console.log("Hello!!");
}
function limitFunctionCalls(fn, numberToCall) {
  let number = 0;
  return function() {
        if (number < numberToCall) {
            number++;
            return fn();
        } else {
            return 'limit reached';
        }
    };
}

let printSayHello = limitFunctionCalls(sayHello, 4);
printSayHello()
printSayHello()
printSayHello()
printSayHello()
console.log(printSayHello())



//once(fn)
function onlyOnTime(fn) {
    let count = 0
    return () => {
        if(count == 0) {
            count++;
            return fn()
        }else {
            return 'already called...'
        }
    }
}

function printGreeting () {
    console.log('HI!!!');
    return '&#128540;';
}

let printIT = onlyOnTime(printGreeting)
console.log(printIT())
console.log(printIT())

