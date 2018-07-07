package org.outsiders.release.bootstrap;

import java.util.Collections;
import java.util.UUID;

import org.outsiders.release.domain.Ability;
import org.outsiders.release.domain.CharacterDescription;
import org.outsiders.release.domain.Character;
import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.Inventory;
import org.outsiders.release.domain.Item;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.SpellInfo;
import org.outsiders.release.domain.Target;
import org.outsiders.release.domain.Timespan;
import org.outsiders.release.domain.User;
import org.outsiders.release.domain.Wallet;
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
		addData();
    }

    public void addData() {
    	String id = UUID.randomUUID().toString();
    	String id2 = UUID.randomUUID().toString();
    	String id3 = UUID.randomUUID().toString();
    	String id4 = UUID.randomUUID().toString();
    	String id5 = UUID.randomUUID().toString();
    	String id6 = UUID.randomUUID().toString();
    	
    	Timespan timespan = new Timespan();
    	Target target = new Target();
    	SpellInfo spellInfo = new SpellInfo();
    	Ability ability = new Ability();
    	Wallet wallet = new Wallet();
    	Item item = new Item();
    	Inventory inventory = new Inventory();
    	ClassLevel classLevel = new ClassLevel();
    	Race race = new Race();
    	CharacterDescription characterDescription = new CharacterDescription();
    	Character character = new Character();
    	
    	ability.setSpellInfo(spellInfo);
    	ability.setTimespan(timespan);
    	ability.setTarget(target);
    	ability.setId(id);
    	
    	abilityService.insert(ability);
    	LOG.info("Ability inserted with id = {}", ability.getId());
    	
    	item.setId(id2);
    	item.setAbilityIds(Collections.singletonList(id));
    	
    	itemService.insert(item);
    	LOG.info("Item inserted with id = {}", item.getId());
    	
    	race.setId(id3);
    	race.setAbilityIds(Collections.singletonList(id));
    	
    	raceService.insert(race);
    	LOG.info("Race inserted with id = {}", race.getId());
    	
    	classLevel.setId(id4);
    	classLevel.setInnateAbilityIds(Collections.singletonList(id));
    	classLevel.setChosenAbilityIds(Collections.singletonList(id));
    	
    	classLevelService.insert(classLevel);
    	LOG.info("ClassLevel inserted with id = {}", classLevel.getId());
    	
    	inventory.setWallet(wallet);
    	inventory.setItemIds(Collections.singletonList(id2));
    	
    	character.setId(id5);
    	character.setInventory(inventory);
    	character.setCharacterDescription(characterDescription);
    	
    	characterService.insert(character);
    	LOG.info("Character inserted with id = {}", character.getId());
 	
        User user = new User();
        
        user.setId(id6);
        user.setName("Logan");
        user.setEmail("lrmoen92@gmail.com");
        user.setPassword("password");
        user.setCharacterIds(Collections.singletonList(character.getId()));
        
        userService.insert(user);
        LOG.info("User inserted with id = {}", user.getId());
    	
    }
}