
//  getting all variables with and id in html....
let taskCount = document.getElementById('task-count');
let completedTask = document.getElementById('completed');
let ulList = document.getElementById('ul');
let inputTask = document.getElementById('task');
let addBtn = document.getElementById('btn-add');


// all global variables
let task_counter = 0;
let task_completed = 0;


// all the methods would be here
const taskCounter = () => { 
    task_counter++;
    taskCount.textContent = 'Task: '+ task_counter;
}
const decreaseTaskCounter = () => { 
    task_counter--;
    taskCount.textContent = 'Task: '+ task_counter;
}
const taskCompleteCounter = () => {
    task_completed++;
    completedTask.textContent = 'Completed :'+ task_completed; 
}
const taskCompleteCounterdecreaser = () => {
   if(task_completed !== 0) {
        task_completed--;
        completedTask.textContent = 'Completed: '+ task_completed; 
   }
}
function addElementer(task)  {
    

    if(!(task.trim() === '')) {
        //create a new list tag
        let li = document.createElement('li');
    
        //creaeting a new checkbox
        let checBox = document.createElement('input');
        checBox.type = 'checkbox';

        //creating a new icon
        let icon = document.createElement('i');
        icon.classList.add('fa-solid', 'fa-xmark')


        li.appendChild(checBox)
        li.appendChild(document.createTextNode(task))
        li.appendChild(icon);

        //apend to th ulList
        ulList.appendChild(li);
        taskCounter();

        icon.addEventListener('click' , ( ) => {
            ulList.removeChild(li);
            decreaseTaskCounter();
            taskCompleteCounterdecreaser();
        })
        checBox.addEventListener('click', () => {
            if(checBox.checked) {
                taskCompleteCounter();
                li.style.textDecoration = 'line-through';
            }
            else {
                taskCompleteCounterdecreaser();
                li.style.textDecoration = 'none';
            }
        })

    }
    else {
        alert('exclude the negation')
    }

}

const appStarter = function() {
    inputTask.focus();
    addBtn.addEventListener('click', () => {
        addElementer(inputTask.value);
        inputTask.value = '';
        inputTask.focus();
    })
    document.addEventListener('keydown', (e) => {
        if(e.key == 'Enter') 
            addBtn.click();
    })


}


//call the appStarter
appStarter();