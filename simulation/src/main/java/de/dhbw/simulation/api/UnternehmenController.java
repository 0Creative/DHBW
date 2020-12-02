package de.dhbw.simulation.api;


import de.dhbw.simulation.model.Unternehmen;
import de.dhbw.simulation.service.UnternehmenService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("api/v1/unternehmen")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnternehmenController {

    private final UnternehmenService unternehmenService;

    @Autowired
    public UnternehmenController(UnternehmenService unternehmenService) {
        this.unternehmenService = unternehmenService;
    }

    @PostMapping
    public void addUnternehmen(@RequestBody Unternehmen unternehmen){
        unternehmenService.addUnternehmen(unternehmen);
    }
    
    @GetMapping
    public List<Unternehmen> getAllUnternehmen() {
        return unternehmenService.getAllUnternehmen();

    }

    @GetMapping(path = "{id}")
    public Unternehmen getUnternehmenById(@NonNull @PathVariable("id") UUID id) {

        return unternehmenService.getUnternehmenById(id)
                    .orElse(null);
    }
    
    @DeleteMapping(path = "{id}")
    public void deleteUnternehmenById(@PathVariable("id") UUID id ) {
        unternehmenService.deleteUnternehmen(id);
    }

    @PutMapping(path = "{id}")
    public  void updateUnternehmen(@PathVariable("id") UUID id,@RequestBody @NonNull Unternehmen unternehmenToUpdate) {
        unternehmenService.updateUnternehmen(id, unternehmenToUpdate);

    }


}
