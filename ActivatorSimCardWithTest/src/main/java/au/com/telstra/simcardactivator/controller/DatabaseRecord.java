package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.ActivateResponse;
import au.com.telstra.simcardactivator.model.Sim;
import au.com.telstra.simcardactivator.record.Record;
import au.com.telstra.simcardactivator.repository.SimRecord;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRecord {

    private final SimRecord simRecord;

    public DatabaseRecord(SimRecord simRecord) {
        this.simRecord = simRecord;
    }

    public void save(Sim sim, ActivateResponse activateResponse){
        Record record=new Record(sim,activateResponse);
        simRecord.save(record);
    }

    public Sim querySimCard(long simId){
        var simCardRecord = simRecord.findById(simId).orElse(null);
        if (simCardRecord == null) {
            return null;
        }
        return new Sim(simCardRecord);
    }
}
