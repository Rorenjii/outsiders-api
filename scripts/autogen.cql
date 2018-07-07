CREATE KEYSPACE outsiders WITH REPLICATION = {
    'class':'SimpleStrategy',
	'replication_factor':1
};

CREATE TYPE outsiders.timespan (
    unit text,
    value int
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
    itemIds list<text>
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
    modifiers map<text, int>,
    timespan frozen<timespan>,
    target frozen<target>,
    type text,
    spellinfo frozen<spellinfo>
);

CREATE TABLE outsiders.item (
	id text PRIMARY KEY,
    name text,
    description text,
	quantity int,
    modifiers map<text, int>,
    types list<text>,
    abilityIds list<text>
);

CREATE TABLE outsiders.classlevel (
	id text PRIMARY KEY,
    level int,
    role text,
    innateabilityIds list<text>,
    chosenabilityIds list<text>,
    modifiers map<text, int>
);

CREATE TABLE outsiders.race (
	id text PRIMARY KEY,
    type text,
	size text,
    variant text,
    modifiers map<text, int>,
    abilityIds list<text>
);

CREATE TABLE outsiders.character (
    id text PRIMARY KEY,
    inventory frozen<inventory>,
    classlevelIds list<text>,
    raceId text,
    modifiers map<text, int>,
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