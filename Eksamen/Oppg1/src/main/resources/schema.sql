CREATE TABLE Kunde (
    KId INT(11) AUTO_INCREMENT,
    Fornavn VARCHAR(50),
    Etternavn VARCHAR(50),
    Adresse VARCHAR(50),
    Postnr VARCHAR(4),
    Telefonnr VARCHAR(50) NOT NULL,
    Epost VARCHAR(50),
    PRIMARY KEY(KId)
);

CREATE TABLE Poststed (
    Postnr VARCHAR(4),
    Poststed VARCHAR(50),
    PRIMARY KEY(Postnr)
);

CREATE TABLE Pakke (
    PId INT(11) AUTO_INCREMENT,
    KId INT(11) AUTO_INCREMENT,
    Volum DECIMAL(10,0),
    Vekt DECIMAL(10,0),
    PRIMARY KEY(PId),
    FOREIGN KEY (KId) REFERENCES Kunde(KId)
);