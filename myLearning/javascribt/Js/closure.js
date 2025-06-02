// calling function after delay of time
function saveData() {
    console.log('saving Data')
}

function passData(fn, delay) {
    let timerId;
   return function() {
    clearTimeout(timerId)
    timerId = setTimeout(() => {
        return fn();
    },delay)
   }
}

let storeData = passData(saveData, 1000);

storeData();
storeData();
storeData();



//
function throttle(fn, delay) {

    return () => {
        fn();
    }

}