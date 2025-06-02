//storing 5 question in an array and thier anwers as object
let question1 = {
  question: "What is the Capital of France",
  correct_answer: "Paris",
  answer1: "Mogadisho",
  answer2: "London",
  answer3: "Rome",
};
let question2 = {
  question: "What is the Capital of England",
  correct_answer: "London",
  answer1: "Zagreb",
  answer2: "Berlin",
  answer3: "Rome",
};
let question3 = {
  question: "What is the Capital of Ukraine",
  answer1: "Helsinki",
  answer2: "London",
  answer3: "Rome",
  correct_answer: "Kyiv",
};
let question4 = {
  question: "What is the Capital of Somalia",
  answer1: "Paris",
  correct_answer: "Mogadisho",
  answer2: "Kyiv",
  answer3: "Rome",
};
let question5 = {
  question: "What is the Capital of Belgium",
  answer2: "Madrid",
  answer1: "Mogadisho",
  correct_answer: "Brussels",
  answer3: "London",
};

let quizArray = [question1, question2, question3, question4, question5];

//selecting all elements
let quizContainer = document.getElementById("quiz-div");
let start_btn = document.getElementById("start");
let radios = document.getElementsByName("quiz");

let progress = document.getElementById("progress");
let span = document.getElementById("span");
let h3_question = document.getElementById("question");
let next = document.getElementById("btn-next");
let previous = document.getElementById("btn-previous");
let submit_btn = document.getElementById("btn-submit");

let radio_btn1 = document.getElementById("radio-btn1");
let radio_btn2 = document.getElementById("radio-btn2");
let radio_btn3 = document.getElementById("radio-btn3");
let radio_btn4 = document.getElementById("radio-btn4");

let radio_label1 = document.getElementById("label1");
let radio_label2 = document.getElementById("label2");
let radio_label3 = document.getElementById("label3");
let radio_label4 = document.getElementById("label4");

let userAnswers = new Array(quizArray.length).fill(null);

let count, score;

start_btn.addEventListener("click", () => {
  count = 0;
  score = 0;
  userAnswers = new Array(quizArray.length).fill(null); // clear previous answers

  // Reset UI state
  quizContainer.style.display = "block";
  start_btn.style.display = "none";
  next.style.display = "flex";
  previous.style.display = "flex";
  previous.disabled = true;
  submit_btn.style.display = "none";

  // Load first question
  takeQuiz(count);
});

const takeQuiz = function (count) {
  start_btn.style.display = "none";
  printExam(count);
  next.addEventListener("click", () => {
    const selected = document.querySelector('input[name="quiz"]:checked');
    if (!selected) {
      alert("Please select an option before continuing.");
      return; // stop moving to next
    }

    userAnswers[count] = selected.value;
    count++;
    printExam(count);

    if (count === quizArray.length - 1) {
      submit_btn.style.display = "block";
      next.style.display = "none";
    }

    previous.disabled = false;
  });
  previous.addEventListener("click", () => {
    if (count >= 0) {
      count--;
      printExam(count);
    }
    if (count != 4) {
      next.style.display = "flex";
      submit_btn.style.display = "none";
    }
  });

  submit_btn.addEventListener("click", () => {
    const selected = document.querySelector('input[name="quiz"]:checked');
    if (!selected) {
      alert("Please select an option before submitting.");
      return;
    }
    userAnswers[count] = selected.value; // Save last answer
    score = 0;
    quizArray.forEach((question, index) => {
      if (userAnswers[index] === question.correct_answer) {
        score++;
      }
    });

    quizContainer.style.display = "none";
    start_btn.style.display = "block";
    count = 0;

    alert("You scored: " + score + " / " + quizArray.length);
  });
};

const printExam = function (count) {
  progress.setAttribute("value", count + 1);
  span.textContent = count + 1;

  let questionObj = quizArray.at(count);
  h3_question.textContent = questionObj.question;

  radio_btn1.setAttribute("value", questionObj.answer1);
  radio_btn2.setAttribute("value", questionObj.answer2);
  radio_btn3.setAttribute("value", questionObj.correct_answer);
  radio_btn4.setAttribute("value", questionObj.answer3);

  radio_label1.textContent = questionObj.answer1;
  radio_label2.textContent = questionObj.answer2;
  radio_label3.textContent = questionObj.correct_answer;
  radio_label4.textContent = questionObj.answer3;

  // Reset all radios
  radios.forEach((radio) => (radio.checked = false));

  // Restore saved selection (if any)
  if (userAnswers[count]) {
    radios.forEach((radio) => {
      if (radio.value === userAnswers[count]) {
        radio.checked = true;
      }
    });
  }
};

const collectScore = function (count) {
  const selected = document.querySelector('input[name="quiz"]:checked');
  score = 0;

  if (selected) {
    alert("You selected: " + selected.value);
    if (selected.value === quizArray.at(count).correct_answer) {
      score++;
      alert(selected.value === quizArray.at(count).correct_answer);
    }
  } else {
    alert("Please select an option!");
  }
};
