let theme = document.querySelector("#themeIocns");

let mode = localStorage.getItem("theme") === "dark-theme" ? "dark-theme" : "light-theme";
document.body.classList.add(mode);
theme.addEventListener("click", () => {
  if (document.body.classList.contains("light-theme")) {
    document.body.classList.remove("light-theme");
    document.body.classList.add("dark-theme");
    localStorage.setItem("theme", "dark-theme");
  } else {
    document.body.classList.remove("dark-theme");
    document.body.classList.add("light-theme");
    localStorage.setItem("theme", "light-theme");
  }
});
