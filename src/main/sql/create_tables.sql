\set ON_ERROR_STOP on

CREATE TABLE IF NOT EXISTS Person(
    id                                 SERIAL PRIMARY KEY,
    email                              VARCHAR(100),
    created_at	                       TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'UTC'),
    updated_at	                       TIMESTAMP WITHOUT TIME ZONE
);
COMMENT ON TABLE Person IS 'User info.';
ALTER TABLE Person OWNER TO hatool;

CREATE TABLE IF NOT EXISTS Player(
    id                                 SERIAL PRIMARY KEY,
    person_id                          INTEGER,
    name                               VARCHAR(100),
    active                             BOOLEAN NOT NULL DEFAULT TRUE,
    latest_data                        INTEGER,
    position                           INTEGER NOT NULL DEFAULT 0,
    status                             INTEGER NOT NULL DEFAULT 0,
    loyalty                            INTEGER,
    created_at	                       TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'UTC'),
    updated_at	                       TIMESTAMP WITHOUT TIME ZONE,
    FOREIGN KEY (person_id) REFERENCES Person(id)
);
COMMENT ON TABLE Player IS 'Container for player info.';
ALTER TABLE Player OWNER TO hatool;

-- PLAYER DATA
CREATE TABLE IF NOT EXISTS Player_data(
    id                                 SERIAL PRIMARY KEY,
    player_id                          INTEGER,
    created_at	                       TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'UTC'),
    updated_at	                       TIMESTAMP WITHOUT TIME ZONE,
    age                                INTEGER,
    quality                            INTEGER,
    potential                          INTEGER,
    goalie                             INTEGER,
    defence                            INTEGER,
    attack                             INTEGER,
    shooting                           INTEGER,
    passing                            INTEGER,
    speed                              INTEGER,
    strength                           INTEGER,
    self_control                       INTEGER,
    form                               INTEGER,
    experience                         INTEGER,
    ability_index                      INTEGER,
    weeks                              INTEGER,
    growth_potential                   INTEGER,
    efficiency                         INTEGER,
    FOREIGN KEY (player_id) REFERENCES Player(id)
);
COMMENT ON TABLE Player_data IS 'Contains player data on a single day.';
COMMENT ON COLUMN Player_data.player_id IS 'Link to actual player.';
ALTER TABLE Player_data OWNER TO hatool;

ALTER TABLE Player ADD CONSTRAINT latest_data_fk FOREIGN KEY (latest_data) REFERENCES Player_data(id) ON DELETE SET NULL;