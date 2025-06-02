
// modifying existing elements 
let para = document.getElementById("p1");
let myButton = document.getElementById("btn");


//add the btn to event listener
myButton.addEventListener('click', function changeColor() {
    para.style.color = "purple";
    para.style.fontSize = '26px';
})


// adding the event listner the button of id btn1 
// to create new element.
document.getElementById('btn1').addEventListener('click', () => {
    // createing new elements 
    let paragraph = document.createElement('p')
    let paragraph2 = document.createElement('p2')
    paragraph.textContent = "I am the paragraph which created the dom, and i'm from insertBefore()"
    paragraph2.textContent = "I am the paragraph which created the dom, and i'm from appendChild()"
    document.body.insertBefore(paragraph, document.getElementById('btn1'))
    document.body.appendChild(paragraph2)
})