function regUtover() {
    let utover = {
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        klubb: $("#klubb").val(),
        epost: $("#e-post").val(),
        passord: $("#passord").val()
    };

    //Endret knappen til å angi en onclick hendelse som kjører denne hele funksjonen
    $.post("/lagreUtover", utover, function (utover) {
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#klubb").val("");
        $("#e-post").val("");
        $("#passord").val("");
    }).fail(function (jqXHR){
        const json = $.parseJSON(jqXHR.responseText);
        $("#feil").html(json.message);
    })
}