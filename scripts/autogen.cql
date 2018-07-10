CREATE KEYSPACE outsiders WITH REPLICATION = {
    'class':'SimpleStrategy',
	'replication_factor':1
};

CREATE TYPE outsiders.modmap (
	modifier text,
	value int,
	d text
);

CREATE TYPE outsiders.timespan (
    unit text,
    value int,
    per text
);

CREATE TYPE outsiders.target (
    range int,
    shape text,
    size int,
    type text
);

CREATE TYPE outsiders.spellinfo (
    arcane boolean,
    divine boolean,
    school text,
    spelllevel int
);

CREATE TYPE outsiders.wallet (
    copper int,
    silver int,
    gold int,
    platinum int
);

CREATE TYPE outsiders.inventory (
    size int,
    wallet frozen<wallet>,
    itemIds map<text, int>
);

CREATE TYPE outsiders.characterdescription (
    name text,
    playername text,
    homeland text,
    deity text,
    alignment text,
    gender text,
    age text,
    height text,
    weight text,
    hair text,
    eyes text
);

CREATE TABLE outsiders.ability (
	id text PRIMARY KEY,
    name text,
    description text,
    modifiers list<frozen<modmap>>,
    timespan frozen<timespan>,
    target frozen<target>,
    type text,
    spellinfo frozen<spellinfo>
);

CREATE TABLE outsiders.item (
	id text PRIMARY KEY,
    name text,
    description text,
    modifiers list<frozen<modmap>>,
    types list<text>,
    abilityIds list<text>
);

CREATE TABLE outsiders.classlevel (
	id text PRIMARY KEY,
    level int,
    classtype text,
    innateabilityIds list<text>,
    chosenabilityIds list<text>,
    modifiers list<frozen<modmap>>
);

CREATE TABLE outsiders.race (
	id text PRIMARY KEY,
    type text,
	size text,
    variant text,
    modifiers list<frozen<modmap>>,
    abilityIds list<text>
);

CREATE TABLE outsiders.character (
    id text PRIMARY KEY,
    inventory frozen<inventory>,
    classlevelIds list<text>,
    raceId text,
    modifiers list<frozen<modmap>>,
    featAbilityIds list<text>,
    characterdescription frozen<characterdescription>
);

CREATE TABLE outsiders.user (
	id text PRIMARY KEY,
    email text,
    name text,
    password text,
    characterIds list<text>
);

CREATE INDEX user_email
ON outsiders.user ( email );

CREATE INDEX item_name
ON outsiders.item ( name );

CREATE INDEX race_name
ON outsiders.race ( type );

CREATE INDEX classlevel_classtype
ON outsiders.classlevel ( classtype );

CREATE INDEX classlevel_level
ON outsiders.classlevel ( level );

CREATE INDEX ability_name
ON outsiders.ability ( name );

CREATE INDEX race_type
ON outsiders.race ( type );

CREATE INDEX item_name
ON outsiders.item ( name );