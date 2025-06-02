//  getting all variables with and id in html....
let taskCount = document.getElementById("task-count");
let completedTask = document.getElementById("completed");
let ulList = document.getElementById("ul");
let inputTask = document.getElementById("task");
let addBtn = document.getElementById("btn-add");

function observ() {
  let task_counter = 0;
  let task_completed = 0;

  function printInfo() {
    taskCount.textContent = "Task: " + task_counter;
    completedTask.textContent = "Completed: " + task_completed;
  }

  const counterTask = (event) => {
    event.target.classList.contains("fa-xmark")
      ? task_counter--
      : task_counter++;
    printInfo();
  };
  const countTaskCompleted = (event) => {
    const li = event.target.parentElement;
    if (event.target.checked) {
      task_completed++;
      li.style.textDecoration = "line-through";
    } else {
      task_completed--;
      li.style.textDecoration = "none";
    }

    printInfo();
  };
  const afterDeleteTask = () => {
    if (task_completed > 0) task_completed--;
    printInfo()
  }
  return { counterTask, countTaskCompleted, printInfo, afterDeleteTask};
}

function addElementer(task) {
  //create a new list tag
  let li = document.createElement("li");

  //creaeting a new checkbox
  let checBox = document.createElement("input");
  checBox.type = "checkbox";

  //creating a new icon
  let icon = document.createElement("i");
  icon.classList.add("fa-solid", "fa-xmark");

  li.append(checBox, document.createTextNode(task), icon);

  //apend li to the ulList
  ulList.appendChild(li);
}

const startApp = function () {
  inputTask.focus();
  let my_methods = observ();
  my_methods.printInfo();

  function handleTaskAdd(event) {
    if (!(inputTask.value.trim() === "")) {
      addElementer(inputTask.value);
      my_methods.counterTask(event);
      inputTask.value = "";
      inputTask.focus();
    } else alert("please fill the field");
  }

  addBtn.addEventListener("click", handleTaskAdd);

  document.addEventListener("keydown", (e) => {
    if (e.key == "Enter") handleTaskAdd(e);
  });

  ulList.addEventListener("click", (e) => {
    if (e.target.classList.contains("fa-xmark")) {
      const li = e.target.parentElement;
      ulList.removeChild(li);
      my_methods.counterTask(e);
      my_methods.afterDeleteTask()
    }

    if (e.target.type == "checkbox") {
      my_methods.countTaskCompleted(e);
    }
  });
};

startApp();