// geting the variables
let task = document.getElementById('input-todo');
let saveBtn = document.getElementById('save');
let ul = document.getElementById('taskInput')


//registering the event listener
saveBtn.addEventListener('click', (e) => {

    //creating the li-node to give the todoInout and to append the .ul-class
    let li = document.createElement('li');
    if( task.value == '') {
        alert('fill it')
        return
    }    
    li.textContent = task.value;
    //creating the deleteBtn
    let deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.classList.add("deleteBtn")

    // //making deleteBtn's functionality {this i make }
    // deleteBtn.addEventListener('click', () => {
    //     ul.removeChild(li)
    // })
    
    // appending te deleteBtn to the li 
    li.appendChild(deleteBtn);


    //appending li to the ul
    ul.appendChild(li);

    //reset the input value
    task.value = '';

})

// Event delegation: one event listener on the ul to handle deletes {this one from wep}
ul.addEventListener('click', (e) => {
    if (e.target.classList.contains('deleteBtn')) {
        const li = e.target.parentElement; // get the li containing the clicked delete button
        ul.removeChild(li);
    }
});