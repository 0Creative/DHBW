package de.dhbw.simulation.service;

import de.dhbw.simulation.dao.UnternehmenDao;
import de.dhbw.simulation.model.Unternehmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UnternehmenService {

    private final UnternehmenDao unternehmenDao;

    @Autowired
    public UnternehmenService(@Qualifier("fakeDao") UnternehmenDao unternehmenDao) {

        this.unternehmenDao = unternehmenDao;
    }

    public int addUnternehmen(Unternehmen unternehmen){
        return unternehmenDao.insertUnternehmen(unternehmen);
    }

    public List<Unternehmen> getAllUnternehmen(){
        return unternehmenDao.selectAllUnternehmen();
    }
    public Optional<Unternehmen> getUnternehmenById(UUID id){
        return unternehmenDao.selectUnternehmenById(id);
    }

    public int deleteUnternehmen(UUID id){
        return unternehmenDao.deleteUnternehmenById(id);

    }
    public int updateUnternehmen(UUID id, Unternehmen newUnternehmen){
        return unternehmenDao.updateUnternehmenById(id, newUnternehmen);

    }

}
