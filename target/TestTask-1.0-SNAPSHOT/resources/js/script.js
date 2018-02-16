
 function setDisabled() {
     var elements = document.forms[0]["types"];
     var elementsInput = document.forms[0]["quantitys"];

     for (var i = 0; i < elements.length; i++) {
         if (elements[i].checked) {
             elementsInput[i].disabled = false;
         }
         else  elementsInput[i].disabled = true;
     }

}
    function validateForm()
    {
        var notValid=0;
        var countDisabled=0;
        var elementsInput = document.getElementsByName('quantitys');
        for (var i = 0; i < elementsInput.length; i++) {
            var val = Number(elementsInput[i].value);

            //если ни выбрано ничего
            if(elementsInput[i].disabled==true) {countDisabled++}
            if(countDisabled==elementsInput.length)
            {
                notValid++;
            }
            //проверка на положительность количества
            if (val<=0 & elementsInput[i].disabled==false)
            {
                notValid++;

            }
            //проверка на заполненность
            if ((elementsInput[i].value==null&elementsInput[i].disabled==false)|(elementsInput[i].value==""&elementsInput[i].disabled==false)) {
                notValid++;

            }
            //проверка на принадлежность к числовому формату
            if (isNaN(elementsInput[i].value) & elementsInput[i].disabled==false)
            {
                notValid++;

            }

            //проверка на принадлежность к целому числу
            if (!(Math.floor(val) == val) & (elementsInput[i].disabled==false)) {
                notValid++;

            }

        }

        if (notValid>0) {
            alert("field is empty or incorrect");
            return false;
        }
        else return true;

    }





