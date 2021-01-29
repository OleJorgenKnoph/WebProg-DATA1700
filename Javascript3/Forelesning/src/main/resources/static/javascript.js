function beregn() {
    const navn = document.getElementById("navn").value;
    const hoydes = document.getElementById("hoyde").value;
    const vektS = document.getElementById("vekt").value;

    const hoyde = Number(hoydes);
    const vekt = Number(vektS);

    if (isNaN(hoyde) || isNaN(vekt)){
        document.getElementById("bmi").innerHTML = "Sett inn gyldige verdier"
    }
        else {
            const bmi = vekt/Math.pow(hoyde, 2);
                document.getElementById("bmi").innerHTML = navn + " har BMI = " + bmi.toFixed(2);
    }
}

