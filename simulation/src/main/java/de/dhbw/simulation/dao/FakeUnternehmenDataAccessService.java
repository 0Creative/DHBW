package de.dhbw.simulation.dao;

import de.dhbw.simulation.model.Unternehmen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUnternehmenDataAccessService implements UnternehmenDao {

    private static List<Unternehmen> DB = new ArrayList<>();

    @Override
    public int insertUnternehmen(UUID id, Unternehmen unternehmen) {
        DB.add(new Unternehmen(id, unternehmen.getName(), unternehmen.getBudget()));
        return 1;
    }

    @Override
    public List<Unternehmen> selectAllUnternehmen() {
        return DB;
    }

    @Override
    public Optional<Unternehmen> selectUnternehmenById(UUID id) {
        return DB.stream()
                .filter(unternehmen -> unternehmen.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUnternehmenById(UUID id) {
       Optional<Unternehmen> unternehmenMaybe =  selectUnternehmenById(id);
        if (unternehmenMaybe.isEmpty()){
            return 0;
        }
        DB.remove(unternehmenMaybe.get());
        return 1;
    }

    @Override
    public int updateUnternehmenById(UUID id, Unternehmen update) {
        return selectUnternehmenById(id)
                .map(unternehmen -> {
                    int indexOfUnterehmenToUpdate = DB.indexOf(unternehmen);
                    if (indexOfUnterehmenToUpdate >= 0) {
                        DB.set(indexOfUnterehmenToUpdate, new Unternehmen(id, update.getName(),update.getBudget()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
