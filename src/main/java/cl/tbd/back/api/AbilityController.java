package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Ability;
import cl.tbd.back.service.AbilityService;

@RequestMapping("api/v1/abilities")
@RestController
public class AbilityController {

    private final AbilityService abilityService;

    @Autowired
    public AbilityController(@Valid @NonNull AbilityService volunteerService) {
        this.abilityService = volunteerService;
    }

    @PostMapping
    public void insertAbility(@RequestBody Ability volunteer) {
        abilityService.insertAbility(volunteer);
    }

    @GetMapping
    public List<Ability> selectAllAbilities() {
        return abilityService.selectAllAbilities();
    }

    @GetMapping(path = "{id}")
    public Ability selectAbilityById(@PathVariable("id") UUID id) {
        return abilityService.selectAbilityById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateAbilityNameById(@PathVariable("id") UUID id, @Valid @NonNull Ability volunteer) {
        abilityService.updateAbilityDescriptionById(id, volunteer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAbilityById(@PathVariable("id") UUID id) {
        abilityService.deleteAbilityById(id);
    }

}