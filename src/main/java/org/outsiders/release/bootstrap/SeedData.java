package org.outsiders.release.bootstrap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.outsiders.release.domain.Ability;
import org.outsiders.release.domain.CharacterDescription;
import org.outsiders.release.domain.Character;
import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.Inventory;
import org.outsiders.release.domain.Item;
import org.outsiders.release.domain.ModMap;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.SpellInfo;
import org.outsiders.release.domain.Target;
import org.outsiders.release.domain.Timespan;
import org.outsiders.release.domain.User;
import org.outsiders.release.domain.Wallet;
import org.outsiders.release.domain.constant.AbilityType;
import org.outsiders.release.domain.constant.Alignment;
import org.outsiders.release.domain.constant.ClassType;
import org.outsiders.release.domain.constant.ItemType;
import org.outsiders.release.domain.constant.ModifierType;
import org.outsiders.release.domain.constant.RaceType;
import org.outsiders.release.domain.constant.School;
import org.outsiders.release.domain.constant.Shape;
import org.outsiders.release.domain.constant.Size;
import org.outsiders.release.domain.constant.TargetType;
import org.outsiders.release.domain.constant.TimeUnit;
import org.outsiders.release.service.AbilityService;
import org.outsiders.release.service.CharacterService;
import org.outsiders.release.service.ClassLevelService;
import org.outsiders.release.service.ItemService;
import org.outsiders.release.service.RaceService;
import org.outsiders.release.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(SeedData.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private CharacterService characterService;
    
    @Autowired
    private AbilityService abilityService;
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private RaceService raceService;
    
    @Autowired
    private ClassLevelService classLevelService;

	@Override
	public void run(String... args) throws Exception {
//		addData();
//		makeImperia();
//		bootstrapClasses();
//		bootstrapRaces();
//		bootstrapAbilities();
//		bootstrapItems();
    	LOG.info("ALL DATA SEEDED SUCCESSFULLY");
    }
	
	private <T> List<T> addToListInBulk(T... obj) {
		List<T> list = new ArrayList<>();
		for (T o : obj) {
			list.add(o);
		}
		return list;
	}
	
	private <T> Set<T> addToSetInBulk(T... obj) {
		Set<T> set = new HashSet<>();
		for (T o : obj) {
			set.add(o);
		}
		return set;
	}

    public void addData() {
    	Timespan timespan = new Timespan();
    	
    	timespan.setUnit(TimeUnit.MINUTE);
    	timespan.setValue(10);
    	
    	Target target = new Target();
    	
    	target.setType(TargetType.AOE);
    	target.setShape(Shape.CIRCLE);
    	target.setSize(20);
    	target.setRange(100);
    	
    	SpellInfo spellInfo = new SpellInfo();
    	
    	spellInfo.setArcane(true);
    	spellInfo.setDivine(false);
    	spellInfo.setSchool(School.ABJURATION);
    	spellInfo.setSpellLevel(4);
    	
    	Wallet wallet = new Wallet();
    	
    	wallet.setCopper(10);
    	wallet.setSilver(40);
    	wallet.setGold(300);
    	wallet.setPlatinum(30);
    	
    	CharacterDescription characterDescription = new CharacterDescription();
    	
    	characterDescription.setAge("23");
    	characterDescription.setAlignment(Alignment.N);
    	characterDescription.setDeity("Sarenrae");
    	characterDescription.setEyes("Silver");
    	characterDescription.setGender("F");
    	characterDescription.setHair("Silver");
    	characterDescription.setHeight("6 feet 0 inches");
    	characterDescription.setHomeland("Ternathus");
    	characterDescription.setName("Imperia");
    	characterDescription.setPlayerName("Logan");
    	characterDescription.setWeight("140 lbs");
    	
    	Item item = new Item();
    	Inventory inventory = new Inventory();
    	ClassLevel classLevel = new ClassLevel();
    	Race race = new Race();
    	Character character = new Character();
    	Ability ability = new Ability();
    	ModMap modMap = new ModMap();
    	
    	modMap.setModifier(ModifierType.CURRENTHP);
    	modMap.setValue(20);
    	
    	ability.setSpellInfo(spellInfo);
    	ability.setTimespan(timespan);
    	ability.setTarget(target);
    	ability.setDescription("Creates a storm of ice doing blah blah blah");
    	ability.setName("Ice Storm");
    	ability.setType(AbilityType.SPELL);
    	ability.setModifiers(Collections.singletonList(modMap));
    	
    	abilityService.insert(ability);
    	LOG.info("Ability inserted with id = {}", ability.getId());
    	
    	item.setAbilityIds(Collections.singletonList(ability.getId()));
    	item.setName("Wand of Ice Storm");
    	item.setDescription("This twisted wand is slightly chill to the touch");
    	item.setTypes(Collections.singletonList(ItemType.EQUIPPABLE));
    	item.setModifiers(Collections.singletonList(modMap));
    	
    	itemService.insert(item);
    	LOG.info("Item inserted with id = {}", item.getId());
    	
    	race.setAbilityIds(Collections.singletonList(ability.getId()));
    	race.setSize(Size.MEDIUM);
    	race.setType(RaceType.HALFELF);
    	race.setVariant("Moon Elf");
    	race.setModifiers(Collections.singletonList(modMap));
    	
    	raceService.insert(race);
    	LOG.info("Race inserted with id = {}", race.getId());
    	
    	classLevel.setInnateAbilityIds(Collections.singletonList(ability.getId()));
    	classLevel.setChosenAbilityIds(Collections.singletonList(ability.getId()));
    	classLevel.setClassType(ClassType.ROGUE);
    	classLevel.setLevel(21);
    	classLevel.setModifiers(Collections.singletonList(modMap));
    	
    	classLevelService.insert(classLevel);
    	LOG.info("ClassLevel inserted with id = {}", classLevel.getId());
    	
    	inventory.setWallet(wallet);
    	inventory.setItemIds(Collections.singletonMap(item.getId(), 1));
    	inventory.setSize(30);
    	
    	character.setInventory(inventory);
    	character.setCharacterDescription(characterDescription);
    	character.setClassLevelIds(Collections.singletonList(classLevel.getId()));
    	character.setFeatAbilityIds(Collections.singletonList(ability.getId()));
    	character.setRaceId(race.getId());
    	character.setModifiers(Collections.singletonList(modMap));
    	
    	characterService.insert(character);
    	LOG.info("Character inserted with id = {}", character.getId());
 	
        User user = new User();
        
        user.setName("Logan");
        user.setEmail("lrmoen92@gmail.com");
        user.setPassword("password");
        user.setCharacterIds(Collections.singletonList(character.getId()));
        
        userService.insert(user);
        LOG.info("User inserted with id = {}", user.getId());
    	
		User user3 = userService.findByEmail(user.getEmail());
		LOG.info(user3.toString());
		User user4 = userService.findById(user.getId()).get();
		LOG.info(user4.toString());
    }
    
    public void bootstrapClasses() {
    	

    	ClassLevel barbarian1 = new ClassLevel();
    	ClassLevel barbarian2 = new ClassLevel();
    	ClassLevel barbarian3 = new ClassLevel();
    	ClassLevel barbarian4 = new ClassLevel();
    	ClassLevel barbarian5 = new ClassLevel();
    	ClassLevel barbarian6 = new ClassLevel();
    	ClassLevel barbarian7 = new ClassLevel();
    	ClassLevel barbarian8 = new ClassLevel();
    	ClassLevel barbarian9 = new ClassLevel();
    	ClassLevel barbarian10 = new ClassLevel();
    	ClassLevel barbarian11 = new ClassLevel();
    	ClassLevel barbarian12 = new ClassLevel();
    	ClassLevel barbarian13 = new ClassLevel();
    	ClassLevel barbarian14 = new ClassLevel();
    	ClassLevel barbarian15 = new ClassLevel();
    	ClassLevel barbarian16 = new ClassLevel();
    	ClassLevel barbarian17 = new ClassLevel();
    	ClassLevel barbarian18 = new ClassLevel();
    	ClassLevel barbarian19 = new ClassLevel();
    	ClassLevel barbarian20 = new ClassLevel();

    	ClassLevel bard1 = new ClassLevel();
    	ClassLevel bard2 = new ClassLevel();
    	ClassLevel bard3 = new ClassLevel();
    	ClassLevel bard4 = new ClassLevel();
    	ClassLevel bard5 = new ClassLevel();
    	ClassLevel bard6 = new ClassLevel();
    	ClassLevel bard7 = new ClassLevel();
    	ClassLevel bard8 = new ClassLevel();
    	ClassLevel bard9 = new ClassLevel();
    	ClassLevel bard10 = new ClassLevel();
    	ClassLevel bard11 = new ClassLevel();
    	ClassLevel bard12 = new ClassLevel();
    	ClassLevel bard13 = new ClassLevel();
    	ClassLevel bard14 = new ClassLevel();
    	ClassLevel bard15 = new ClassLevel();
    	ClassLevel bard16 = new ClassLevel();
    	ClassLevel bard17 = new ClassLevel();
    	ClassLevel bard18 = new ClassLevel();
    	ClassLevel bard19 = new ClassLevel();
    	ClassLevel bard20 = new ClassLevel();
    	
    	ClassLevel druid1 = new ClassLevel();
    	ClassLevel druid2 = new ClassLevel();
    	ClassLevel druid3 = new ClassLevel();
    	ClassLevel druid4 = new ClassLevel();
    	ClassLevel druid5 = new ClassLevel();
    	ClassLevel druid6 = new ClassLevel();
    	ClassLevel druid7 = new ClassLevel();
    	ClassLevel druid8 = new ClassLevel();
    	ClassLevel druid9 = new ClassLevel();
    	ClassLevel druid10 = new ClassLevel();
    	ClassLevel druid11 = new ClassLevel();
    	ClassLevel druid12 = new ClassLevel();
    	ClassLevel druid13 = new ClassLevel();
    	ClassLevel druid14 = new ClassLevel();
    	ClassLevel druid15 = new ClassLevel();
    	ClassLevel druid16 = new ClassLevel();
    	ClassLevel druid17 = new ClassLevel();
    	ClassLevel druid18 = new ClassLevel();
    	ClassLevel druid19 = new ClassLevel();
    	ClassLevel druid20 = new ClassLevel();
    	
    	ClassLevel cleric1 = new ClassLevel();
    	ClassLevel cleric2 = new ClassLevel();
    	ClassLevel cleric3 = new ClassLevel();
    	ClassLevel cleric4 = new ClassLevel();
    	ClassLevel cleric5 = new ClassLevel();
    	ClassLevel cleric6 = new ClassLevel();
    	ClassLevel cleric7 = new ClassLevel();
    	ClassLevel cleric8 = new ClassLevel();
    	ClassLevel cleric9 = new ClassLevel();
    	ClassLevel cleric10 = new ClassLevel();
    	ClassLevel cleric11 = new ClassLevel();
    	ClassLevel cleric12 = new ClassLevel();
    	ClassLevel cleric13 = new ClassLevel();
    	ClassLevel cleric14 = new ClassLevel();
    	ClassLevel cleric15 = new ClassLevel();
    	ClassLevel cleric16 = new ClassLevel();
    	ClassLevel cleric17 = new ClassLevel();
    	ClassLevel cleric18 = new ClassLevel();
    	ClassLevel cleric19 = new ClassLevel();
    	ClassLevel cleric20 = new ClassLevel();
    	
    	ClassLevel fighter1 = new ClassLevel();
    	ClassLevel fighter2 = new ClassLevel();
    	ClassLevel fighter3 = new ClassLevel();
    	ClassLevel fighter4 = new ClassLevel();
    	ClassLevel fighter5 = new ClassLevel();
    	ClassLevel fighter6 = new ClassLevel();
    	ClassLevel fighter7 = new ClassLevel();
    	ClassLevel fighter8 = new ClassLevel();
    	ClassLevel fighter9 = new ClassLevel();
    	ClassLevel fighter10 = new ClassLevel();
    	ClassLevel fighter11 = new ClassLevel();
    	ClassLevel fighter12 = new ClassLevel();
    	ClassLevel fighter13 = new ClassLevel();
    	ClassLevel fighter14 = new ClassLevel();
    	ClassLevel fighter15 = new ClassLevel();
    	ClassLevel fighter16 = new ClassLevel();
    	ClassLevel fighter17 = new ClassLevel();
    	ClassLevel fighter18 = new ClassLevel();
    	ClassLevel fighter19 = new ClassLevel();
    	ClassLevel fighter20 = new ClassLevel();
    	
    	ClassLevel paladin1 = new ClassLevel();
    	ClassLevel paladin2 = new ClassLevel();
    	ClassLevel paladin3 = new ClassLevel();
    	ClassLevel paladin4 = new ClassLevel();
    	ClassLevel paladin5 = new ClassLevel();
    	ClassLevel paladin6 = new ClassLevel();
    	ClassLevel paladin7 = new ClassLevel();
    	ClassLevel paladin8 = new ClassLevel();
    	ClassLevel paladin9 = new ClassLevel();
    	ClassLevel paladin10 = new ClassLevel();
    	ClassLevel paladin11 = new ClassLevel();
    	ClassLevel paladin12 = new ClassLevel();
    	ClassLevel paladin13 = new ClassLevel();
    	ClassLevel paladin14 = new ClassLevel();
    	ClassLevel paladin15 = new ClassLevel();
    	ClassLevel paladin16 = new ClassLevel();
    	ClassLevel paladin17 = new ClassLevel();
    	ClassLevel paladin18 = new ClassLevel();
    	ClassLevel paladin19 = new ClassLevel();
    	ClassLevel paladin20 = new ClassLevel();
    	
    	ClassLevel wizard1 = new ClassLevel();
    	ClassLevel wizard2 = new ClassLevel();
    	ClassLevel wizard3 = new ClassLevel();
    	ClassLevel wizard4 = new ClassLevel();
    	ClassLevel wizard5 = new ClassLevel();
    	ClassLevel wizard6 = new ClassLevel();
    	ClassLevel wizard7 = new ClassLevel();
    	ClassLevel wizard8 = new ClassLevel();
    	ClassLevel wizard9 = new ClassLevel();
    	ClassLevel wizard10 = new ClassLevel();
    	ClassLevel wizard11 = new ClassLevel();
    	ClassLevel wizard12 = new ClassLevel();
    	ClassLevel wizard13 = new ClassLevel();
    	ClassLevel wizard14 = new ClassLevel();
    	ClassLevel wizard15 = new ClassLevel();
    	ClassLevel wizard16 = new ClassLevel();
    	ClassLevel wizard17 = new ClassLevel();
    	ClassLevel wizard18 = new ClassLevel();
    	ClassLevel wizard19 = new ClassLevel();
    	ClassLevel wizard20 = new ClassLevel();
    	
    	ClassLevel ranger1 = new ClassLevel();
    	ClassLevel ranger2 = new ClassLevel();
    	ClassLevel ranger3 = new ClassLevel();
    	ClassLevel ranger4 = new ClassLevel();
    	ClassLevel ranger5 = new ClassLevel();
    	ClassLevel ranger6 = new ClassLevel();
    	ClassLevel ranger7 = new ClassLevel();
    	ClassLevel ranger8 = new ClassLevel();
    	ClassLevel ranger9 = new ClassLevel();
    	ClassLevel ranger10 = new ClassLevel();
    	ClassLevel ranger11 = new ClassLevel();
    	ClassLevel ranger12 = new ClassLevel();
    	ClassLevel ranger13 = new ClassLevel();
    	ClassLevel ranger14 = new ClassLevel();
    	ClassLevel ranger15 = new ClassLevel();
    	ClassLevel ranger16 = new ClassLevel();
    	ClassLevel ranger17 = new ClassLevel();
    	ClassLevel ranger18 = new ClassLevel();
    	ClassLevel ranger19 = new ClassLevel();
    	ClassLevel ranger20 = new ClassLevel();
    	
    	ClassLevel sorcerer1 = new ClassLevel();
    	ClassLevel sorcerer2 = new ClassLevel();
    	ClassLevel sorcerer3 = new ClassLevel();
    	ClassLevel sorcerer4 = new ClassLevel();
    	ClassLevel sorcerer5 = new ClassLevel();
    	ClassLevel sorcerer6 = new ClassLevel();
    	ClassLevel sorcerer7 = new ClassLevel();
    	ClassLevel sorcerer8 = new ClassLevel();
    	ClassLevel sorcerer9 = new ClassLevel();
    	ClassLevel sorcerer10 = new ClassLevel();
    	ClassLevel sorcerer11 = new ClassLevel();
    	ClassLevel sorcerer12 = new ClassLevel();
    	ClassLevel sorcerer13 = new ClassLevel();
    	ClassLevel sorcerer14 = new ClassLevel();
    	ClassLevel sorcerer15 = new ClassLevel();
    	ClassLevel sorcerer16 = new ClassLevel();
    	ClassLevel sorcerer17 = new ClassLevel();
    	ClassLevel sorcerer18 = new ClassLevel();
    	ClassLevel sorcerer19 = new ClassLevel();
    	ClassLevel sorcerer20 = new ClassLevel();
    	
    	ClassLevel monk1 = new ClassLevel();
    	ClassLevel monk2 = new ClassLevel();
    	ClassLevel monk3 = new ClassLevel();
    	ClassLevel monk4 = new ClassLevel();
    	ClassLevel monk5 = new ClassLevel();
    	ClassLevel monk6 = new ClassLevel();
    	ClassLevel monk7 = new ClassLevel();
    	ClassLevel monk8 = new ClassLevel();
    	ClassLevel monk9 = new ClassLevel();
    	ClassLevel monk10 = new ClassLevel();
    	ClassLevel monk11 = new ClassLevel();
    	ClassLevel monk12 = new ClassLevel();
    	ClassLevel monk13 = new ClassLevel();
    	ClassLevel monk14 = new ClassLevel();
    	ClassLevel monk15 = new ClassLevel();
    	ClassLevel monk16 = new ClassLevel();
    	ClassLevel monk17 = new ClassLevel();
    	ClassLevel monk18 = new ClassLevel();
    	ClassLevel monk19 = new ClassLevel();
    	ClassLevel monk20 = new ClassLevel();
    	
    	ClassLevel rogue1 = new ClassLevel();
    	ClassLevel rogue2 = new ClassLevel();
    	ClassLevel rogue3 = new ClassLevel();
    	ClassLevel rogue4 = new ClassLevel();
    	ClassLevel rogue5 = new ClassLevel();
    	ClassLevel rogue6 = new ClassLevel();
    	ClassLevel rogue7 = new ClassLevel();
    	ClassLevel rogue8 = new ClassLevel();
    	ClassLevel rogue9 = new ClassLevel();
    	ClassLevel rogue10 = new ClassLevel();
    	ClassLevel rogue11 = new ClassLevel();
    	ClassLevel rogue12 = new ClassLevel();
    	ClassLevel rogue13 = new ClassLevel();
    	ClassLevel rogue14 = new ClassLevel();
    	ClassLevel rogue15 = new ClassLevel();
    	ClassLevel rogue16 = new ClassLevel();
    	ClassLevel rogue17 = new ClassLevel();
    	ClassLevel rogue18 = new ClassLevel();
    	ClassLevel rogue19 = new ClassLevel();
    	ClassLevel rogue20 = new ClassLevel();
    	
    	barbarian1.setClassType(ClassType.BARBARIAN);
    	barbarian1.setLevel(1);
    	barbarian2.setClassType(ClassType.BARBARIAN);
    	barbarian2.setLevel(2);
    	barbarian3.setClassType(ClassType.BARBARIAN);
    	barbarian3.setLevel(3);
    	barbarian4.setClassType(ClassType.BARBARIAN);
    	barbarian4.setLevel(4);
    	barbarian5.setClassType(ClassType.BARBARIAN);
    	barbarian5.setLevel(5);
    	barbarian6.setClassType(ClassType.BARBARIAN);
    	barbarian6.setLevel(6);
    	barbarian7.setClassType(ClassType.BARBARIAN);
    	barbarian7.setLevel(7);
    	barbarian8.setClassType(ClassType.BARBARIAN);
    	barbarian8.setLevel(8);
    	barbarian9.setClassType(ClassType.BARBARIAN);
    	barbarian9.setLevel(9);
    	barbarian10.setClassType(ClassType.BARBARIAN);
    	barbarian10.setLevel(10);
    	barbarian11.setClassType(ClassType.BARBARIAN);
    	barbarian11.setLevel(11);
    	barbarian12.setClassType(ClassType.BARBARIAN);
    	barbarian12.setLevel(12);
    	barbarian13.setClassType(ClassType.BARBARIAN);
    	barbarian13.setLevel(13);
    	barbarian14.setClassType(ClassType.BARBARIAN);
    	barbarian14.setLevel(14);
    	barbarian15.setClassType(ClassType.BARBARIAN);
    	barbarian15.setLevel(15);
    	barbarian16.setClassType(ClassType.BARBARIAN);
    	barbarian16.setLevel(16);
    	barbarian17.setClassType(ClassType.BARBARIAN);
    	barbarian17.setLevel(17);
    	barbarian18.setClassType(ClassType.BARBARIAN);
    	barbarian18.setLevel(18);
    	barbarian19.setClassType(ClassType.BARBARIAN);
    	barbarian19.setLevel(19);
    	barbarian20.setClassType(ClassType.BARBARIAN);
    	barbarian20.setLevel(20);
		
		bard1.setClassType(ClassType.BARD);
    	bard1.setLevel(1);
    	bard2.setClassType(ClassType.BARD);
    	bard2.setLevel(2);
    	bard3.setClassType(ClassType.BARD);
    	bard3.setLevel(3);
    	bard4.setClassType(ClassType.BARD);
    	bard4.setLevel(4);
    	bard5.setClassType(ClassType.BARD);
    	bard5.setLevel(5);
    	bard6.setClassType(ClassType.BARD);
    	bard6.setLevel(6);
    	bard7.setClassType(ClassType.BARD);
    	bard7.setLevel(7);
    	bard8.setClassType(ClassType.BARD);
    	bard8.setLevel(8);
    	bard9.setClassType(ClassType.BARD);
    	bard9.setLevel(9);
    	bard10.setClassType(ClassType.BARD);
    	bard10.setLevel(10);
    	bard11.setClassType(ClassType.BARD);
    	bard11.setLevel(11);
    	bard12.setClassType(ClassType.BARD);
    	bard12.setLevel(12);
    	bard13.setClassType(ClassType.BARD);
    	bard13.setLevel(13);
    	bard14.setClassType(ClassType.BARD);
    	bard14.setLevel(14);
    	bard15.setClassType(ClassType.BARD);
    	bard15.setLevel(15);
    	bard16.setClassType(ClassType.BARD);
    	bard16.setLevel(16);
    	bard17.setClassType(ClassType.BARD);
    	bard17.setLevel(17);
    	bard18.setClassType(ClassType.BARD);
    	bard18.setLevel(18);
    	bard19.setClassType(ClassType.BARD);
    	bard19.setLevel(19);
    	bard20.setClassType(ClassType.BARD);
    	bard20.setLevel(20);
		
		cleric1.setClassType(ClassType.CLERIC);
    	cleric1.setLevel(1);
    	cleric2.setClassType(ClassType.CLERIC);
    	cleric2.setLevel(2);
    	cleric3.setClassType(ClassType.CLERIC);
    	cleric3.setLevel(3);
    	cleric4.setClassType(ClassType.CLERIC);
    	cleric4.setLevel(4);
    	cleric5.setClassType(ClassType.CLERIC);
    	cleric5.setLevel(5);
    	cleric6.setClassType(ClassType.CLERIC);
    	cleric6.setLevel(6);
    	cleric7.setClassType(ClassType.CLERIC);
    	cleric7.setLevel(7);
    	cleric8.setClassType(ClassType.CLERIC);
    	cleric8.setLevel(8);
    	cleric9.setClassType(ClassType.CLERIC);
    	cleric9.setLevel(9);
    	cleric10.setClassType(ClassType.CLERIC);
    	cleric10.setLevel(10);
    	cleric11.setClassType(ClassType.CLERIC);
    	cleric11.setLevel(11);
    	cleric12.setClassType(ClassType.CLERIC);
    	cleric12.setLevel(12);
    	cleric13.setClassType(ClassType.CLERIC);
    	cleric13.setLevel(13);
    	cleric14.setClassType(ClassType.CLERIC);
    	cleric14.setLevel(14);
    	cleric15.setClassType(ClassType.CLERIC);
    	cleric15.setLevel(15);
    	cleric16.setClassType(ClassType.CLERIC);
    	cleric16.setLevel(16);
    	cleric17.setClassType(ClassType.CLERIC);
    	cleric17.setLevel(17);
    	cleric18.setClassType(ClassType.CLERIC);
    	cleric18.setLevel(18);
    	cleric19.setClassType(ClassType.CLERIC);
    	cleric19.setLevel(19);
    	cleric20.setClassType(ClassType.CLERIC);
    	cleric20.setLevel(20);
		
		druid1.setClassType(ClassType.DRUID);
    	druid1.setLevel(1);
    	druid2.setClassType(ClassType.DRUID);
    	druid2.setLevel(2);
    	druid3.setClassType(ClassType.DRUID);
    	druid3.setLevel(3);
    	druid4.setClassType(ClassType.DRUID);
    	druid4.setLevel(4);
    	druid5.setClassType(ClassType.DRUID);
    	druid5.setLevel(5);
    	druid6.setClassType(ClassType.DRUID);
    	druid6.setLevel(6);
    	druid7.setClassType(ClassType.DRUID);
    	druid7.setLevel(7);
    	druid8.setClassType(ClassType.DRUID);
    	druid8.setLevel(8);
    	druid9.setClassType(ClassType.DRUID);
    	druid9.setLevel(9);
    	druid10.setClassType(ClassType.DRUID);
    	druid10.setLevel(10);
    	druid11.setClassType(ClassType.DRUID);
    	druid11.setLevel(11);
    	druid12.setClassType(ClassType.DRUID);
    	druid12.setLevel(12);
    	druid13.setClassType(ClassType.DRUID);
    	druid13.setLevel(13);
    	druid14.setClassType(ClassType.DRUID);
    	druid14.setLevel(14);
    	druid15.setClassType(ClassType.DRUID);
    	druid15.setLevel(15);
    	druid16.setClassType(ClassType.DRUID);
    	druid16.setLevel(16);
    	druid17.setClassType(ClassType.DRUID);
    	druid17.setLevel(17);
    	druid18.setClassType(ClassType.DRUID);
    	druid18.setLevel(18);
    	druid19.setClassType(ClassType.DRUID);
    	druid19.setLevel(19);
    	druid20.setClassType(ClassType.DRUID);
    	druid20.setLevel(20);
		
		fighter1.setClassType(ClassType.FIGHTER);
    	fighter1.setLevel(1);
    	fighter2.setClassType(ClassType.FIGHTER);
    	fighter2.setLevel(2);
    	fighter3.setClassType(ClassType.FIGHTER);
    	fighter3.setLevel(3);
    	fighter4.setClassType(ClassType.FIGHTER);
    	fighter4.setLevel(4);
    	fighter5.setClassType(ClassType.FIGHTER);
    	fighter5.setLevel(5);
    	fighter6.setClassType(ClassType.FIGHTER);
    	fighter6.setLevel(6);
    	fighter7.setClassType(ClassType.FIGHTER);
    	fighter7.setLevel(7);
    	fighter8.setClassType(ClassType.FIGHTER);
    	fighter8.setLevel(8);
    	fighter9.setClassType(ClassType.FIGHTER);
    	fighter9.setLevel(9);
    	fighter10.setClassType(ClassType.FIGHTER);
    	fighter10.setLevel(10);
    	fighter11.setClassType(ClassType.FIGHTER);
    	fighter11.setLevel(11);
    	fighter12.setClassType(ClassType.FIGHTER);
    	fighter12.setLevel(12);
    	fighter13.setClassType(ClassType.FIGHTER);
    	fighter13.setLevel(13);
    	fighter14.setClassType(ClassType.FIGHTER);
    	fighter14.setLevel(14);
    	fighter15.setClassType(ClassType.FIGHTER);
    	fighter15.setLevel(15);
    	fighter16.setClassType(ClassType.FIGHTER);
    	fighter16.setLevel(16);
    	fighter17.setClassType(ClassType.FIGHTER);
    	fighter17.setLevel(17);
    	fighter18.setClassType(ClassType.FIGHTER);
    	fighter18.setLevel(18);
    	fighter19.setClassType(ClassType.FIGHTER);
    	fighter19.setLevel(19);
    	fighter20.setClassType(ClassType.FIGHTER);
    	fighter20.setLevel(20);
		
		monk1.setClassType(ClassType.MONK);
    	monk1.setLevel(1);
    	monk2.setClassType(ClassType.MONK);
    	monk2.setLevel(2);
    	monk3.setClassType(ClassType.MONK);
    	monk3.setLevel(3);
    	monk4.setClassType(ClassType.MONK);
    	monk4.setLevel(4);
    	monk5.setClassType(ClassType.MONK);
    	monk5.setLevel(5);
    	monk6.setClassType(ClassType.MONK);
    	monk6.setLevel(6);
    	monk7.setClassType(ClassType.MONK);
    	monk7.setLevel(7);
    	monk8.setClassType(ClassType.MONK);
    	monk8.setLevel(8);
    	monk9.setClassType(ClassType.MONK);
    	monk9.setLevel(9);
    	monk10.setClassType(ClassType.MONK);
    	monk10.setLevel(10);
    	monk11.setClassType(ClassType.MONK);
    	monk11.setLevel(11);
    	monk12.setClassType(ClassType.MONK);
    	monk12.setLevel(12);
    	monk13.setClassType(ClassType.MONK);
    	monk13.setLevel(13);
    	monk14.setClassType(ClassType.MONK);
    	monk14.setLevel(14);
    	monk15.setClassType(ClassType.MONK);
    	monk15.setLevel(15);
    	monk16.setClassType(ClassType.MONK);
    	monk16.setLevel(16);
    	monk17.setClassType(ClassType.MONK);
    	monk17.setLevel(17);
    	monk18.setClassType(ClassType.MONK);
    	monk18.setLevel(18);
    	monk19.setClassType(ClassType.MONK);
    	monk19.setLevel(19);
    	monk20.setClassType(ClassType.MONK);
    	monk20.setLevel(20);
		
		paladin1.setClassType(ClassType.PALADIN);
    	paladin1.setLevel(1);
    	paladin2.setClassType(ClassType.PALADIN);
    	paladin2.setLevel(2);
    	paladin3.setClassType(ClassType.PALADIN);
    	paladin3.setLevel(3);
    	paladin4.setClassType(ClassType.PALADIN);
    	paladin4.setLevel(4);
    	paladin5.setClassType(ClassType.PALADIN);
    	paladin5.setLevel(5);
    	paladin6.setClassType(ClassType.PALADIN);
    	paladin6.setLevel(6);
    	paladin7.setClassType(ClassType.PALADIN);
    	paladin7.setLevel(7);
    	paladin8.setClassType(ClassType.PALADIN);
    	paladin8.setLevel(8);
    	paladin9.setClassType(ClassType.PALADIN);
    	paladin9.setLevel(9);
    	paladin10.setClassType(ClassType.PALADIN);
    	paladin10.setLevel(10);
    	paladin11.setClassType(ClassType.PALADIN);
    	paladin11.setLevel(11);
    	paladin12.setClassType(ClassType.PALADIN);
    	paladin12.setLevel(12);
    	paladin13.setClassType(ClassType.PALADIN);
    	paladin13.setLevel(13);
    	paladin14.setClassType(ClassType.PALADIN);
    	paladin14.setLevel(14);
    	paladin15.setClassType(ClassType.PALADIN);
    	paladin15.setLevel(15);
    	paladin16.setClassType(ClassType.PALADIN);
    	paladin16.setLevel(16);
    	paladin17.setClassType(ClassType.PALADIN);
    	paladin17.setLevel(17);
    	paladin18.setClassType(ClassType.PALADIN);
    	paladin18.setLevel(18);
    	paladin19.setClassType(ClassType.PALADIN);
    	paladin19.setLevel(19);
    	paladin20.setClassType(ClassType.PALADIN);
    	paladin20.setLevel(20);
		
		rogue1.setClassType(ClassType.ROGUE);
    	rogue1.setLevel(1);
    	rogue2.setClassType(ClassType.ROGUE);
    	rogue2.setLevel(2);
    	rogue3.setClassType(ClassType.ROGUE);
    	rogue3.setLevel(3);
    	rogue4.setClassType(ClassType.ROGUE);
    	rogue4.setLevel(4);
    	rogue5.setClassType(ClassType.ROGUE);
    	rogue5.setLevel(5);
    	rogue6.setClassType(ClassType.ROGUE);
    	rogue6.setLevel(6);
    	rogue7.setClassType(ClassType.ROGUE);
    	rogue7.setLevel(7);
    	rogue8.setClassType(ClassType.ROGUE);
    	rogue8.setLevel(8);
    	rogue9.setClassType(ClassType.ROGUE);
    	rogue9.setLevel(9);
    	rogue10.setClassType(ClassType.ROGUE);
    	rogue10.setLevel(10);
    	rogue11.setClassType(ClassType.ROGUE);
    	rogue11.setLevel(11);
    	rogue12.setClassType(ClassType.ROGUE);
    	rogue12.setLevel(12);
    	rogue13.setClassType(ClassType.ROGUE);
    	rogue13.setLevel(13);
    	rogue14.setClassType(ClassType.ROGUE);
    	rogue14.setLevel(14);
    	rogue15.setClassType(ClassType.ROGUE);
    	rogue15.setLevel(15);
    	rogue16.setClassType(ClassType.ROGUE);
    	rogue16.setLevel(16);
    	rogue17.setClassType(ClassType.ROGUE);
    	rogue17.setLevel(17);
    	rogue18.setClassType(ClassType.ROGUE);
    	rogue18.setLevel(18);
    	rogue19.setClassType(ClassType.ROGUE);
    	rogue19.setLevel(19);
    	rogue20.setClassType(ClassType.ROGUE);
    	rogue20.setLevel(20);
		
		sorcerer1.setClassType(ClassType.SORCERER);
    	sorcerer1.setLevel(1);
    	sorcerer2.setClassType(ClassType.SORCERER);
    	sorcerer2.setLevel(2);
    	sorcerer3.setClassType(ClassType.SORCERER);
    	sorcerer3.setLevel(3);
    	sorcerer4.setClassType(ClassType.SORCERER);
    	sorcerer4.setLevel(4);
    	sorcerer5.setClassType(ClassType.SORCERER);
    	sorcerer5.setLevel(5);
    	sorcerer6.setClassType(ClassType.SORCERER);
    	sorcerer6.setLevel(6);
    	sorcerer7.setClassType(ClassType.SORCERER);
    	sorcerer7.setLevel(7);
    	sorcerer8.setClassType(ClassType.SORCERER);
    	sorcerer8.setLevel(8);
    	sorcerer9.setClassType(ClassType.SORCERER);
    	sorcerer9.setLevel(9);
    	sorcerer10.setClassType(ClassType.SORCERER);
    	sorcerer10.setLevel(10);
    	sorcerer11.setClassType(ClassType.SORCERER);
    	sorcerer11.setLevel(11);
    	sorcerer12.setClassType(ClassType.SORCERER);
    	sorcerer12.setLevel(12);
    	sorcerer13.setClassType(ClassType.SORCERER);
    	sorcerer13.setLevel(13);
    	sorcerer14.setClassType(ClassType.SORCERER);
    	sorcerer14.setLevel(14);
    	sorcerer15.setClassType(ClassType.SORCERER);
    	sorcerer15.setLevel(15);
    	sorcerer16.setClassType(ClassType.SORCERER);
    	sorcerer16.setLevel(16);
    	sorcerer17.setClassType(ClassType.SORCERER);
    	sorcerer17.setLevel(17);
    	sorcerer18.setClassType(ClassType.SORCERER);
    	sorcerer18.setLevel(18);
    	sorcerer19.setClassType(ClassType.SORCERER);
    	sorcerer19.setLevel(19);
    	sorcerer20.setClassType(ClassType.SORCERER);
    	sorcerer20.setLevel(20);
		
		wizard1.setClassType(ClassType.WIZARD);
    	wizard1.setLevel(1);
    	wizard2.setClassType(ClassType.WIZARD);
    	wizard2.setLevel(2);
    	wizard3.setClassType(ClassType.WIZARD);
    	wizard3.setLevel(3);
    	wizard4.setClassType(ClassType.WIZARD);
    	wizard4.setLevel(4);
    	wizard5.setClassType(ClassType.WIZARD);
    	wizard5.setLevel(5);
    	wizard6.setClassType(ClassType.WIZARD);
    	wizard6.setLevel(6);
    	wizard7.setClassType(ClassType.WIZARD);
    	wizard7.setLevel(7);
    	wizard8.setClassType(ClassType.WIZARD);
    	wizard8.setLevel(8);
    	wizard9.setClassType(ClassType.WIZARD);
    	wizard9.setLevel(9);
    	wizard10.setClassType(ClassType.WIZARD);
    	wizard10.setLevel(10);
    	wizard11.setClassType(ClassType.WIZARD);
    	wizard11.setLevel(11);
    	wizard12.setClassType(ClassType.WIZARD);
    	wizard12.setLevel(12);
    	wizard13.setClassType(ClassType.WIZARD);
    	wizard13.setLevel(13);
    	wizard14.setClassType(ClassType.WIZARD);
    	wizard14.setLevel(14);
    	wizard15.setClassType(ClassType.WIZARD);
    	wizard15.setLevel(15);
    	wizard16.setClassType(ClassType.WIZARD);
    	wizard16.setLevel(16);
    	wizard17.setClassType(ClassType.WIZARD);
    	wizard17.setLevel(17);
    	wizard18.setClassType(ClassType.WIZARD);
    	wizard18.setLevel(18);
    	wizard19.setClassType(ClassType.WIZARD);
    	wizard19.setLevel(19);
    	wizard20.setClassType(ClassType.WIZARD);
    	wizard20.setLevel(20);
		
		ranger1.setClassType(ClassType.RANGER);
    	ranger1.setLevel(1);
    	ranger2.setClassType(ClassType.RANGER);
    	ranger2.setLevel(2);
    	ranger3.setClassType(ClassType.RANGER);
    	ranger3.setLevel(3);
    	ranger4.setClassType(ClassType.RANGER);
    	ranger4.setLevel(4);
    	ranger5.setClassType(ClassType.RANGER);
    	ranger5.setLevel(5);
    	ranger6.setClassType(ClassType.RANGER);
    	ranger6.setLevel(6);
    	ranger7.setClassType(ClassType.RANGER);
    	ranger7.setLevel(7);
    	ranger8.setClassType(ClassType.RANGER);
    	ranger8.setLevel(8);
    	ranger9.setClassType(ClassType.RANGER);
    	ranger9.setLevel(9);
    	ranger10.setClassType(ClassType.RANGER);
    	ranger10.setLevel(10);
    	ranger11.setClassType(ClassType.RANGER);
    	ranger11.setLevel(11);
    	ranger12.setClassType(ClassType.RANGER);
    	ranger12.setLevel(12);
    	ranger13.setClassType(ClassType.RANGER);
    	ranger13.setLevel(13);
    	ranger14.setClassType(ClassType.RANGER);
    	ranger14.setLevel(14);
    	ranger15.setClassType(ClassType.RANGER);
    	ranger15.setLevel(15);
    	ranger16.setClassType(ClassType.RANGER);
    	ranger16.setLevel(16);
    	ranger17.setClassType(ClassType.RANGER);
    	ranger17.setLevel(17);
    	ranger18.setClassType(ClassType.RANGER);
    	ranger18.setLevel(18);
    	ranger19.setClassType(ClassType.RANGER);
    	ranger19.setLevel(19);
    	ranger20.setClassType(ClassType.RANGER);
    	ranger20.setLevel(20);

    	// ABOUT TO SAVE ALL DATA
    	
    	Set<ClassLevel> set = new HashSet<>();
    	
    	Collections.addAll(set, 
    			barbarian1,
				barbarian2,
				barbarian3,
				barbarian4,
				barbarian5,
				barbarian6,
				barbarian7,
				barbarian8,
				barbarian9,
				barbarian10,
				barbarian11,
				barbarian12,
				barbarian13,
				barbarian14,
				barbarian15,
				barbarian16,
				barbarian17,
				barbarian18,
				barbarian19,
				barbarian20,
				    	
				bard1,
				bard2,
				bard3,
				bard4,
				bard5,
				bard6,
				bard7,
				bard8,
				bard9,
				bard10,
				bard11,
				bard12,
				bard13,
				bard14,
				bard15,
				bard16,
				bard17,
				bard18,
				bard19,
				bard20,
				    	
				druid1,
				druid2,
				druid3,
				druid4,
				druid5,
				druid6,
				druid7,
				druid8,
				druid9,
				druid10,
				druid11,
				druid12,
				druid13,
				druid14,
				druid15,
				druid16,
				druid17,
				druid18,
				druid19,
				druid20,
				    	
				cleric1,
				cleric2,
				cleric3,
				cleric4,
				cleric5,
				cleric6,
				cleric7,
				cleric8,
				cleric9,
				cleric10,
				cleric11,
				cleric12,
				cleric13,
				cleric14,
				cleric15,
				cleric16,
				cleric17,
				cleric18,
				cleric19,
				cleric20,
				    	
				fighter1,
				fighter2,
				fighter3,
				fighter4,
				fighter5,
				fighter6,
				fighter7,
				fighter8,
				fighter9,
				fighter10,
				fighter11,
				fighter12,
				fighter13,
				fighter14,
				fighter15,
				fighter16,
				fighter17,
				fighter18,
				fighter19,
				fighter20,
				    	
				paladin1,
				paladin2,
				paladin3,
				paladin4,
				paladin5,
				paladin6,
				paladin7,
				paladin8,
				paladin9,
				paladin10,
				paladin11,
				paladin12,
				paladin13,
				paladin14,
				paladin15,
				paladin16,
				paladin17,
				paladin18,
				paladin19,
				paladin20,
				    	
				wizard1,
				wizard2,
				wizard3,
				wizard4,
				wizard5,
				wizard6,
				wizard7,
				wizard8,
				wizard9,
				wizard10,
				wizard11,
				wizard12,
				wizard13,
				wizard14,
				wizard15,
				wizard16,
				wizard17,
				wizard18,
				wizard19,
				wizard20,
				    	
				ranger1,
				ranger2,
				ranger3,
				ranger4,
				ranger5,
				ranger6,
				ranger7,
				ranger8,
				ranger9,
				ranger10,
				ranger11,
				ranger12,
				ranger13,
				ranger14,
				ranger15,
				ranger16,
				ranger17,
				ranger18,
				ranger19,
				ranger20,
				    	
				sorcerer1,
				sorcerer2,
				sorcerer3,
				sorcerer4,
				sorcerer5,
				sorcerer6,
				sorcerer7,
				sorcerer8,
				sorcerer9,
				sorcerer10,
				sorcerer11,
				sorcerer12,
				sorcerer13,
				sorcerer14,
				sorcerer15,
				sorcerer16,
				sorcerer17,
				sorcerer18,
				sorcerer19,
				sorcerer20,
				    	
				monk1,
				monk2,
				monk3,
				monk4,
				monk5,
				monk6,
				monk7,
				monk8,
				monk9,
				monk10,
				monk11,
				monk12,
				monk13,
				monk14,
				monk15,
				monk16,
				monk17,
				monk18,
				monk19,
				monk20,
				    	
				rogue1,
				rogue2,
				rogue3,
				rogue4,
				rogue5,
				rogue6,
				rogue7,
				rogue8,
				rogue9,
				rogue10,
				rogue11,
				rogue12,
				rogue13,
				rogue14,
				rogue15,
				rogue16,
				rogue17,
				rogue18,
				rogue19,
				rogue20
    			);
    	
    	classLevelService.insert(set);
    	
    	//phew 
    }

    public void bootstrapRaces() {
    	Race halforc = new Race();
    	Race dwarf = new Race();
    	Race elf = new Race();
    	Race halfelf = new Race();
    	Race human = new Race();
    	Race gnome = new Race();
    	Race halfling = new Race();
    	Race dragonborn = new Race();
    	Race tiefling = new Race();
    	Race goliath = new Race();
    	
    	halforc.setSize(Size.MEDIUM);
    	dwarf.setSize(Size.MEDIUM);
    	elf.setSize(Size.MEDIUM);
    	halfelf.setSize(Size.MEDIUM);
    	human.setSize(Size.MEDIUM);
    	gnome.setSize(Size.SMALL);
    	halfling.setSize(Size.SMALL);
    	dragonborn.setSize(Size.MEDIUM);
    	tiefling.setSize(Size.MEDIUM);
    	goliath.setSize(Size.LARGE);
    	
    	halforc.setType(RaceType.HALFORC);
    	dwarf.setType(RaceType.DWARF);
    	elf.setType(RaceType.ELF);
    	halfelf.setType(RaceType.HALFELF);
    	human.setType(RaceType.HUMAN);
    	gnome.setType(RaceType.GNOME);
    	halfling.setType(RaceType.HALFLING);
    	dragonborn.setType(RaceType.DRAGONBORN);
    	tiefling.setType(RaceType.TIEFLING);
    	goliath.setType(RaceType.GOLIATH);
    	
    	List<ModMap> halforcMods = new ArrayList<>();
    	List<ModMap> dwarfMods = new ArrayList<>();
    	List<ModMap> elfMods = new ArrayList<>();
    	List<ModMap> halfelfMods = new ArrayList<>();
    	List<ModMap> humanMods = new ArrayList<>();
    	List<ModMap> gnomeMods = new ArrayList<>();
    	List<ModMap> halflingMods = new ArrayList<>();
    	List<ModMap> dragonbornMods = new ArrayList<>();
    	List<ModMap> tieflingMods = new ArrayList<>();
    	List<ModMap> goliathMods = new ArrayList<>();
    	
    	ModMap con = new ModMap();
    	con.setModifier(ModifierType.CONSTITUTION);
    	con.setValue(2);
    	ModMap wis = new ModMap();
    	wis.setModifier(ModifierType.WISDOM);
    	wis.setValue(2);
    	ModMap cha = new ModMap();
    	cha.setModifier(ModifierType.CHARISMA);
    	cha.setValue(2);
    	ModMap str = new ModMap();
    	con.setModifier(ModifierType.STRENGTH);
    	con.setValue(2);
    	ModMap inl = new ModMap();
    	wis.setModifier(ModifierType.INTELLIGENCE);
    	wis.setValue(2);
    	ModMap dex = new ModMap();
    	cha.setModifier(ModifierType.DEXTERITY);
    	cha.setValue(2);
    	
    	ModMap conm = new ModMap();
    	conm.setModifier(ModifierType.CONSTITUTION);
    	conm.setValue(-2);
    	ModMap wism = new ModMap();
    	wism.setModifier(ModifierType.WISDOM);
    	wism.setValue(-2);
    	ModMap cham = new ModMap();
    	cham.setModifier(ModifierType.CHARISMA);
    	cham.setValue(-2);
    	ModMap strm = new ModMap();
    	conm.setModifier(ModifierType.STRENGTH);
    	conm.setValue(-2);
    	ModMap inlm = new ModMap();
    	wism.setModifier(ModifierType.INTELLIGENCE);
    	wism.setValue(-2);
    	ModMap dexm = new ModMap();
    	cham.setModifier(ModifierType.DEXTERITY);
    	cham.setValue(-2);
    	ModMap spd1 = new ModMap();
    	spd1.setModifier(ModifierType.SPEED);
    	spd1.setValue(20);
    	ModMap spd2 = new ModMap();
    	spd2.setModifier(ModifierType.SPEED);
    	spd2.setValue(30);
    	ModMap spd3 = new ModMap();
    	spd3.setModifier(ModifierType.SPEED);
    	spd3.setValue(40);
    	
    	dwarf.setModifiers(addToListInBulk(con, wis, cham, spd1));
    	elf.setModifiers(addToListInBulk(dex, inl, conm, spd2));
    	gnome.setModifiers(addToListInBulk(con, cha, strm, spd1));
    	halfling.setModifiers(addToListInBulk(dex, cha, strm, spd1));
    	halforc.setModifiers(addToListInBulk(spd2));
    	halfelf.setModifiers(addToListInBulk(spd2));
    	human.setModifiers(addToListInBulk(spd2));
    	tiefling.setModifiers(addToListInBulk(spd2));
    	dragonborn.setModifiers(addToListInBulk(spd2));
    	goliath.setModifiers(addToListInBulk(spd3));
    	
    	
//    	Collections.addAll(c, elements)
    	
    	raceService.insert(addToSetInBulk(
    				halforc,
    				dwarf,
    				elf,
    				halfelf,
    				human,
    				gnome,
    				halfling,
    				dragonborn,
    				tiefling,
    				goliath
    			));
    }
}