/*
    this block all are functions in js how we can define and how we can run.
    1.function Declaration
    2.function Expression
    3.arrow Function
*/
printName('sahra')
function printName(name) {
    console.log(`my name is ${name}`);
}
printName("omm")


const printInfo = function() {
    console.log(`this is a function expression.`)
}
printInfo()


const printMe = () => {
    console.log(`this is an arrow function.`)
}
printMe()

/*
     this block all are  how we can define objects and how we can run in js.
     1.object literal {}
     2.new Object
*/
const person = {
    name: "Omm Ziid",
    age: 22,
    address: 'cadale'
}

console.log(person)

function Animal(name, type, color) {
    this.name = name;
    this.type = type;
    this.color =  color;
}

const elephant = new Animal("Elephant", "MAMMALS", 'dark-white')
console.log(elephant)

