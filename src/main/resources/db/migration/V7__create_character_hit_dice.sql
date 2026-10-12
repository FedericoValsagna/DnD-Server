-- Hit Dice gastados por tamaño de dado (10 = d10). Solo los que tienen alguno gastado: el total sale de las clases.
CREATE TABLE character_hit_dice (
    character_id UUID NOT NULL REFERENCES characters (id) ON DELETE CASCADE,
    die          INT  NOT NULL,
    used         INT  NOT NULL CHECK (used > 0),
    PRIMARY KEY (character_id, die)
);
