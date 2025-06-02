
//getitng the hour min and second boxs
let hour = document.getElementById('hour');
let min = document.getElementById('min');
let sec = document.getElementById('sec');

let count_second = 0;
let count_minute = 0;
let count_hour = 0;


function increase() {
    count_second++;
    if(count_second === 60) {
       count_second = 0;
       count_minute++;
    }
    if(count_minute === 60) {
       count_minute = 0;
       count_hour++;
    }
    if(count_hour == 24) {
        count_hour = 0;
    }
        
    sec.textContent = count_second.toString().padStart(2,'0');
    min.textContent = count_minute.toString().padStart(2,'0');
    hour.textContent = count_hour.toString().padStart(2,'0');


    setTimeout(increase, 1000);
       
}
requestAnimationFrame(increase)


