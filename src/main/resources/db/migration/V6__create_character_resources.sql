-- Usos gastados de los recursos de clase (Rage, Ki, Channel Divinity, ...). Solo los que tienen alguno gastado: el
-- máximo se calcula, y un recurso sin fila está entero.
CREATE TABLE character_resources (
    character_id UUID        NOT NULL REFERENCES characters (id) ON DELETE CASCADE,
    resource     VARCHAR(40) NOT NULL,
    used         INT         NOT NULL CHECK (used > 0),
    PRIMARY KEY (character_id, resource)
);
