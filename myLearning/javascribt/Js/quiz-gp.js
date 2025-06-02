// Question bank
const quizArray = [
  {
    question: "What is the Capital of France",
    correct_answer: "Paris",
    answer1: "Mogadisho",
    answer2: "London",
    answer3: "Rome",
  },
  {
    question: "What is the Capital of England",
    correct_answer: "London",
    answer1: "Zagreb",
    answer2: "Berlin",
    answer3: "Rome",
  },
  {
    question: "What is the Capital of Ukraine",
    correct_answer: "Kyiv",
    answer1: "Helsinki",
    answer2: "London",
    answer3: "Rome",
  },
  {
    question: "What is the Capital of Somalia",
    correct_answer: "Mogadisho",
    answer1: "Paris",
    answer2: "Kyiv",
    answer3: "Rome",
  },
  {
    question: "What is the Capital of Belgium",
    correct_answer: "Brussels",
    answer1: "Mogadisho",
    answer2: "Madrid",
    answer3: "London",
  }
];

// DOM elements
const quizContainer = document.getElementById("quiz-div");
const start_btn = document.getElementById("start");
const next = document.getElementById("btn-next");
const previous = document.getElementById("btn-previous");
const submit_btn = document.getElementById("btn-submit");
const radios = document.getElementsByName("quiz");

const progress = document.getElementById("progress");
const span = document.getElementById("span");
const h3_question = document.getElementById("question");

const radio_btns = [
  document.getElementById("radio-btn1"),
  document.getElementById("radio-btn2"),
  document.getElementById("radio-btn3"),
  document.getElementById("radio-btn4")
];
const radio_labels = [
  document.getElementById("label1"),
  document.getElementById("label2"),
  document.getElementById("label3"),
  document.getElementById("label4")
];

// State
let count = 0;
let score = 0;
let userAnswers = new Array(quizArray.length).fill(null);

// Helper to show/hide elements
function show(el) {
  el.classList.remove("hidden");
}
function hide(el) {
  el.classList.add("hidden");
}

// Render question
function printExam(index) {
  const q = quizArray[index];
  h3_question.textContent = q.question;

  const choices = [q.answer1, q.answer2, q.correct_answer, q.answer3];

  for (let i = 0; i < 4; i++) {
    radio_btns[i].value = choices[i];
    radio_labels[i].textContent = choices[i];
    radio_btns[i].checked = false;
  }

  // Restore answer if exists
  if (userAnswers[index]) {
    radios.forEach((radio) => {
      if (radio.value === userAnswers[index]) {
        radio.checked = true;
      }
    });
  }

  // Progress bar and count
  progress.value = index + 1;
  span.textContent = index + 1;

  // Button visibility
  previous.disabled = index === 0;
  if (index === quizArray.length - 1) {
    show(submit_btn);
    hide(next);
  } else {
    hide(submit_btn);
    show(next);
  }
}

// Navigation
function navigate(offset) {
  const selected = document.querySelector('input[name="quiz"]:checked');
  if (offset === 1 && !selected) {
    alert("Please select an option before continuing.");
    return;
  }

  if (selected) userAnswers[count] = selected.value;

  count += offset;
  printExam(count);
}

// Submit
submit_btn.addEventListener("click", () => {
  const selected = document.querySelector('input[name="quiz"]:checked');
  if (!selected) {
    alert("Please select an option before submitting.");
    return;
  }

  userAnswers[count] = selected.value;
  score = 0;

  quizArray.forEach((question, index) => {
    if (userAnswers[index] === question.correct_answer) {
      score++;
    }
  });

  alert("You scored: " + score + " / " + quizArray.length);
  resetQuiz();
});

// Reset all state
function resetQuiz() {
  count = 0;
  score = 0;
  userAnswers = new Array(quizArray.length).fill(null);
  printExam(count);
  show(quizContainer);
  hide(start_btn);
}

// Start
start_btn.addEventListener("click", resetQuiz);
next.addEventListener("click", () => navigate(1));
previous.addEventListener("click", () => navigate(-1));
