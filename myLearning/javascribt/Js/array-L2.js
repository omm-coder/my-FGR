//
let colors = ['Red', 'Yellow', 'Blue'];
colors[5] = 'Purple';

const iterator = colors.keys();
for(const key of iterator) {
    console.log(`${key}: ${colors[key]}`)
}



let array = [10, 20, 30, 10, 40, 50, 20, 80]

console.log(array.includes(90));

let ARRAY_FROM_OF = Array.of(12, 'IT', 'HIM', 100, false);
console.log(Array.isArray(ARRAY_FROM_OF));

let anAray = [67,78,90];

anAray.fill(14, 0, 2)
console.log(anAray)

console.log('Array_from_has value IT: '+ ARRAY_FROM_OF.includes('IT'));