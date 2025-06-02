// array

function doubleNumbers(array) {
  for (let i = 0; i < array.length; i++) {
    array[i] += array[i];
  }
  return array;
}

console.log(doubleNumbers([10, 20, 30, 40]));

function filterEvenNumbers(array) {
  return array.filter((num) => num % 2 == 0);
}
console.log(filterEvenNumbers([1, 2, 3, 4, 5, 6]));

function findTheLargestNumber(array) {
 let largest = array[0]; 
  for (let i = 1; i < array.length; i++) {
    if (array[i] > largest) {
      largest = array[i];
    }
  }
  return largest;
}
console.log(findTheLargestNumber([3, 9, 15, 10, 7, 6]));

function reduceDuplicate(array) {
    for(let i = 0; i < array.length; i++) {
        for(let k = 0; k < array.length; k++) {
            if(array[i] === array[k])
                array.splice(k, 1) 
        }
    }
    return array;
}
console.log(reduceDuplicate([7,8,4,7,8,16]))