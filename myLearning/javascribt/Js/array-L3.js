//

let marks = [
    {
        'id': 's10',
        'science': 99
    },
    {
        'id': 's9',
        'science': 88
    },
    {
        'id': 's7',
        'science': 93
    },
    {
        'id': 's6',
        'science': 89
    }
]
console.log('all students: ' +JSON.stringify(marks, null, 2))
let studentsAbove90 = [];

//finding all studend which get above 90 marks 1: for-loop and 2nd: filter
// for(let i = 0; i < marks.length; i++) {
//     if(marks[i].science > 90) 
//         studentsAbove90.push({
//             'id': marks[i].id,
//             'science': marks[i].science
//         })
// }

studentsAbove90 =  marks.filter(mark => mark.science >= 90);

console.log('student abouve 90: '+ JSON.stringify(studentsAbove90, null, 2))




// Square numbers using map 
let numbers = [23, 4, 8, 19, 90, 7]
console.log(numbers.map(number => number * 2))


//add all numbers in the array
console.log(numbers.reduce((number, sum) => sum += number))