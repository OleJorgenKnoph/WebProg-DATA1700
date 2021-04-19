function validerOgLoggInn() {
    const navnOK = validerNavn($("#brukernavn").val());
    const passordOK = validerPassord($("#passord").val());

    if (navnOK && passordOK){
        login();
    }
}

function login(){
    const kunde = {
        navn: $("#brukernavn").val(),
        passord: $("#passord").val()
    };

    $.get("/login", kunde, function (innlogget){
        if (innlogget){
            window.location.href = 'index.html';
        }
        else {
            $("#feilPassord").html("Feil i brukernavn eller passord");
        }
    })
        .fail(function (){
        $("#feilPassord").html("Feil på server - prøv igjen senere");
    })
}

function logout() {
    $.get("/logout", function (){
        window.location.href = 'login.html';
    })
}

function sjekkInnlogging(){
    $.get("/sjekkInnlogget", function (innloggetStatus){
    if (innloggetStatus) {
        leggTilInnloggetObjekter();
    }
    })
}