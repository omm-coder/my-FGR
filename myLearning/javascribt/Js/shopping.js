// creating Dynamic List Genetator 
// all would be created in Dom.

let parent_container = document.getElementById('parent-container')


//creating the first h1 tag of my container
let h1 = document.createElement('h1');
h1.textContent = "Shopping List"



//creating the div block of h2andlist
let div = document.createElement('div');
div.classList.add('itemList')

//creating the title h2 tag of the lis
let h2 = document.createElement('h2')
h2.textContent = 'Your Shopping List';


//creating the ul list
let ul = document.createElement('ul');






//making the functionality of the app
//graping the important varaibles
let inputItem = document.getElementById('input-item');
let addItem = document.getElementById('add_btn_item');


addItem.addEventListener('click', () => {
    if(inputItem.value == '') {
        alert("please Enter an item")
        return
    }
    makeListItems(inputItem);
    inputItem.value = '';
    inputItem.focus();
})
document.addEventListener('keydown', (event) => {
    if(event.key == 'Enter') addItem.click();
})
let makeListItems = function(input) {
    // creating the lis

    let li = document.createElement('li')
    li.textContent = input.value;
    let delButton = document.createElement('button')
    delButton.textContent = 'Delete';
    delButton.setAttribute('id','del_item_btn')
    delButton.classList.add('delete_btn');

    li.appendChild(delButton)
    ul.appendChild(li);
    div.appendChild(ul)

    delButton.addEventListener('click', () => {
        ul.removeChild(li);
    })
}

   
//adding elements to the parent-container
// 1- adding h1 to the parent-container 
parent_container.insertBefore(h1,inputItem);


// 2- adding the h2 and ul list in to the div 
div.appendChild(h2);


// 3- adding the div block of h2 and ul list
parent_container.appendChild(div);