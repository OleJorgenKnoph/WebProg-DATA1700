function sjekkOmFinnes(){
    let obj = {
        Brukernavn: $("#brukernavn").val(),
        Passord: $("#passord").val()
    };

    //The function return a boolean depending on if the value was found or not
    $.get("/sjekkBruker", obj, function (data) {
        if (data){
            $("#resultat").html("Brukernavnet og passordet finnes på server");
        }
        else {
            $("#resultat").html("Brukernavnet og passordet finnes ikke på server");
        }
    })
}