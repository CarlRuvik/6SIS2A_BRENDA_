var date = document.querySelector('[type=date]');

function noMondays(e){

    var day = new Date( e.target.value ).getUTCDay();

    // Days in JS range from 0-6 where 0 is Sunday and 6 is Saturday

    if( day == 0 | day==6 ){

        e.target.setCustomValidity('Sólo hacer cita de lunes a viernes.');

    } else {

        e.target.setCustomValidity('');

    }

}

date.addEventListener('input',noMondays);