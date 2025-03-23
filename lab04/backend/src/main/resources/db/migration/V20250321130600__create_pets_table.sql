CREATE TABLE pets (
    pet_id    BIGINT PRIMARY KEY,
    kind      VARCHAR(64) NOT NULL,
    name      VARCHAR(64) NOT NULL,
    age       INTEGER     NOT NULL
);

CREATE SEQUENCE pet_id_sequence
AS BIGINT
INCREMENT BY 50
START WITH 1
OWNED BY pets.pet_id;
