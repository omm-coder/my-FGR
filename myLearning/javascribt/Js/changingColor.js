// #Fetch all the elements 
let paragraph = document.getElementById("paragraph")
const btn =document.getElementById("btn")
let favColor;

//registering event Listener
btn.addEventListener("click", () => {
    favColor = document.getElementById("favColor").value
    paragraph.style.color = favColor;
    paragraph.style.fontSize = '22px'
  
})

  const area = document.getElementById("area");
  const area1 = document.getElementById("area1");
  const coords = document.getElementById("coords");

  area.addEventListener("mousemove", (e) => {
    coords.textContent = `X: ${e.offsetX}, Y: ${e.offsetY}`;
  });

  area1.addEventListener('contextmenu',() => {
    alert("Right click detected")
  })



