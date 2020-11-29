package de.dhbw.simulation.api;


import de.dhbw.simulation.model.Person;
import de.dhbw.simulation.service.PersonService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();

    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@NonNull @PathVariable("id") UUID id) {

        return personService.getPersonById(id)
                    .orElse(null);
    }
    
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id ) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public  void updatePerson(@PathVariable("id") UUID id,@RequestBody @NonNull Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);

    }


}
