CREATE TABLE AlleKunder (
    id INTEGER AUTO_INCREMENT NOT NULL,
    persNr VARCHAR(20) NOT NULL,
    navn VARCHAR(255) NOT NULL,
    adr VARCHAR(255) NOT NULL,
    regNr VARCHAR(10) NOT NULL,
    merke  VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    passord VARCHAR(255) NOT NULL,
        PRIMARY KEY(id)
);

CREATE TABLE AlleBiler (
    bil_id INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255),
    type VARCHAR(255),
        PRIMARY KEY(bil_id)
);

