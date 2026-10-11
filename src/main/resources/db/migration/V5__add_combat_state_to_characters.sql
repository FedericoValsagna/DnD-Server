-- Estado de combate: HP actual y temporales y death saves. El estado (consciente, muriendo, estable, muerto) no se
-- guarda: sale del HP y de los death saves. Los personajes que ya existían arrancan con el HP lleno.
ALTER TABLE characters ADD COLUMN current_hit_points INT;
UPDATE characters SET current_hit_points = max_hit_points;
ALTER TABLE characters ALTER COLUMN current_hit_points SET NOT NULL;
ALTER TABLE characters ADD CONSTRAINT characters_current_hit_points_check
    CHECK (current_hit_points BETWEEN 0 AND max_hit_points);

ALTER TABLE characters ADD COLUMN temporary_hit_points INT NOT NULL DEFAULT 0
    CHECK (temporary_hit_points BETWEEN 0 AND 999);
ALTER TABLE characters ADD COLUMN death_save_successes INT NOT NULL DEFAULT 0
    CHECK (death_save_successes BETWEEN 0 AND 3);
ALTER TABLE characters ADD COLUMN death_save_failures INT NOT NULL DEFAULT 0
    CHECK (death_save_failures BETWEEN 0 AND 3);
ALTER TABLE characters ADD CONSTRAINT characters_death_saves_check
    CHECK ((death_save_successes = 0 AND death_save_failures = 0) OR current_hit_points = 0);
ALTER TABLE characters ADD CONSTRAINT characters_death_saves_complete_check
    CHECK (death_save_successes < 3 OR death_save_failures < 3);

-- CA cargada a mano (gana sobre la calculada; NULL = calculada) y velocidad base, hasta que existan equipo y razas.
ALTER TABLE characters ADD COLUMN armor_class_override INT CHECK (armor_class_override BETWEEN 1 AND 50);
ALTER TABLE characters ADD COLUMN base_speed INT NOT NULL DEFAULT 30 CHECK (base_speed BETWEEN 0 AND 200);
