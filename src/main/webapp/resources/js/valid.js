
function validAddress(){

    var form = document.getElementById('formConfirm');
    var a=form["Address"].value;
    if (a==null || a=="")
    {
        alert("Field Address is empty!");
        return false;
    }
    else return true;

}