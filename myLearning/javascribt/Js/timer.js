//
let min = document.querySelector("#minutes");
let sec = document.querySelector("#seconds");
let input_timer = document.querySelector("#input-minutes");
let start_btn = document.querySelector("#btn-start");
let reset_btn = document.querySelector("#btn-reset");


let interval;
let totalSeconds = 0;




start_btn.addEventListener("click", () => {
  let input = parseInt(input_timer.value);
  if (input > 0) {
    totalSeconds = input * 60;
    updateDisplay();
    input_timer.disabled = true;
    start_btn.disabled = true;

    interval = setInterval(() => {
      totalSeconds--;
      updateDisplay();
      if (totalSeconds <= 0) {
        clearInterval(interval);
        alert("⏰ Timer Finished");
        input_timer.disabled = false;
        start_btn.disabled = false;
      }
    }, 1000);
  }
});


reset_btn.addEventListener("click", () => {
  clearInterval(interval);
  min.textContent = "00";
  sec.textContent = "00";
  input_timer.disabled = false;
  start_btn.disabled = false;
});



function updateDisplay() {
  let minutes = Math.floor(totalSeconds / 60);
  let seconds = totalSeconds % 60;
  min.textContent = String(minutes).padStart(2, "0");
  sec.textContent = String(seconds).padStart(2, "0");
}