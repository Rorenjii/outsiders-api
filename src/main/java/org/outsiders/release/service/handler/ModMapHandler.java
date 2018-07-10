package org.outsiders.release.service.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.outsiders.release.domain.Ability;
import org.outsiders.release.domain.Character;
import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.Item;
import org.outsiders.release.domain.ModMap;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.constant.ItemType;
import org.outsiders.release.service.AbilityService;
import org.outsiders.release.service.CharacterService;
import org.outsiders.release.service.ClassLevelService;
import org.outsiders.release.service.ItemService;
import org.outsiders.release.service.RaceService;
import org.outsiders.release.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModMapHandler {

//	private static final Logger LOG = LoggerFactory.getLogger(ModMapHandler.class);
//
//    @Autowired
//    private UserService userService;
//    
//    @Autowired
//    private CharacterService characterService;
    
    @Autowired
    private AbilityService abilityService;
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private RaceService raceService;
    
    @Autowired
    private ClassLevelService classLevelService;
    
    public Set<ModMap> getTotalStats(Character character) {
    	
    	List<ClassLevel> classLevels = new ArrayList<>();
    	List<Ability> abilities = new ArrayList<>();
    	List<Item> items = new ArrayList<>();
    	Race race = new Race();
    	
    	Set<ModMap> result = new HashSet<>();
    	
    	character.getClassLevelIds().forEach(id -> classLevels.add(classLevelService.findById(id).get()));
    	character.getFeatAbilityIds().forEach(id -> abilities.add(abilityService.findById(id).get()));
    	character.getInventory().getItemIds().forEach((id, num) -> items.add(itemService.findById(id).get()));
    	
    	race = raceService.findById(character.getRaceId()).get();
    	
    	for (Item item : items) {
    		if (item.getTypes().contains(ItemType.EQUIPPABLE)) {
    			result = concatModMaps(result, item.getModifiers());
    			for(String id : item.getAbilityIds()) {
    				if (abilityService.findById(id).get().isItem()) {
    					result = concatModMaps(result, item.getModifiers());
    				}
    			}
			}
    	}
    	
    	for (ClassLevel classLevel : classLevels) {
    		classLevel.getChosenAbilityIds().forEach(id -> {
    			abilities.add(abilityService.findById(id).get());
    		});
    		classLevel.getInnateAbilityIds().forEach(id -> {
    			abilities.add(abilityService.findById(id).get());
    		});
    		result = concatModMaps(result, classLevel.getModifiers());
    	}
    	
    	race.getAbilityIds().forEach(id -> abilities.add(abilityService.findById(id).get()));
    	
    	result = concatModMaps(result, race.getModifiers());
    	result = concatModMaps(result, character.getModifiers());
    	
    	for (Ability ability : abilities) {
    		Set<ModMap> temp = new HashSet<>();
    		if (ability.isPassive() || ability.isItem()) {
    			temp = concatModMaps(temp, ability.getModifiers());
    		}
    		result = concatModMaps(result, temp);
    	}	
    	return result;
    }
    
    private Set<ModMap> concatModMaps(Iterable<ModMap> original, Iterable<ModMap> update) {
    	Set<ModMap> result = new HashSet<>();
		original.forEach(originalMap -> {
	    	update.forEach(updateMap -> {
				if (originalMap.getModifier().equals(updateMap.getModifier())) {
					originalMap.setValue(originalMap.getValue() + updateMap.getValue());
					originalMap.setModifier(originalMap.getModifier());
				}
	    	});
    	});
		original.forEach(mm -> result.add(mm));
    	return result;
    }
}
