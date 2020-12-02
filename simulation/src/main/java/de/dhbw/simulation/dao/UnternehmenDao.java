package de.dhbw.simulation.dao;


import de.dhbw.simulation.model.Unternehmen;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UnternehmenDao {

    int insertUnternehmen(UUID id, Unternehmen unternehmen);

    default int insertUnternehmen(Unternehmen unternehmen) {
        UUID id = UUID.randomUUID();
        return insertUnternehmen(id, unternehmen);

    };

    List<Unternehmen> selectAllUnternehmen();

    Optional<Unternehmen> selectUnternehmenById(UUID id);

    int deleteUnternehmenById(UUID id);

    int updateUnternehmenById(UUID id, Unternehmen unternehmen);

}
