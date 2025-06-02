let scoreBoard = document.querySelector("#score");
let missBoard = document.getElementById("missed");
let start_button = document.querySelector("#btn-start");
let gameArea = document.querySelector("#area-game");

//popups//
let popup = document.getElementById("popup");
let popup_message = document.getElementById("popup-message");
let popup_close = document.getElementById("popup-close");

let score = 0;
let missed = 0;
let tototalBox = 0;
let gameRunning = false;
let intervalId;
let gameDuration = 10000; // 30 seconds
let boxLifetime = 3000;

const countScore = () => {
  score++;
  scoreBoard.textContent = score;
};
const decreaseScore = () => {
  score = Math.max(0, score - 1);
  scoreBoard.textContent = score;
};
const countMissed = () => {
  missed++;
  missBoard.textContent = missed;
};

function create_box() {
  //create the box to be shown
  let box = document.createElement("div");

  const areaWidth = gameArea.clientWidth - 50; // avoid overflow (box width = 50)
  const areaHeight = gameArea.clientHeight - 50;

  const left = Math.random() * areaWidth;
  const top = Math.random() * areaHeight;

  box.style.top = top + "px";
  box.style.left = left + "px";
  box.classList.add("box");

  gameArea.appendChild(box);
  tototalBox++;

  box.addEventListener("click", () => {
    if (gameArea.contains(box)) {
      gameArea.removeChild(box);
      countScore();
    }
  });
  setTimeout(() => {
    if (!gameRunning) return; // don't update after game ends

    if (gameArea.contains(box)) {
      gameArea.removeChild(box);
      decreaseScore();
      countMissed();
    }
  }, boxLifetime);
}

start_button.addEventListener("click", (e) => {
  score = 0;
  missed = 0;
  gameRunning = true;
  scoreBoard.textContent = score;
  missBoard.textContent = missed;
  endTheGame();
  start_button.disabled = true;
});

function endTheGame() {
  let interval = setInterval(create_box, 1000);

  setTimeout(() => {
    clearInterval(interval);

    start_button.disabled = false;
    gameRunning = false;

    setTimeout(() => {
      popup_message.innerHTML = `
      🎮 Game Over!<br>
      ✅ Score: ${score}<br>
      ❌ Missed: ${missed}
      totalBox: ${tototalBox}`;

      popup.style.display = "block";
      gameArea.classList.add("frozen");
    }, boxLifetime);
  }, gameDuration);
}
popup_close.addEventListener("click", () => {
  popup.style.display = "none";
  gameArea.classList.remove("frozen");
  gameArea.innerHTML = "";
});
