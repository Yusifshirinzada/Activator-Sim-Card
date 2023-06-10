package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.ActivateResponse;
import au.com.telstra.simcardactivator.model.Sim;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimController {


    private final DatabaseRecord databaseRecord;

    private final SimCardActuationHandler simCardActuationHandler;
    public SimController(DatabaseRecord databaseRecord,SimCardActuationHandler simCardActuationHandler){

        this.databaseRecord=databaseRecord;
        this.simCardActuationHandler=simCardActuationHandler;

    }



    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody Sim simCard) {
        var actuationResult = simCardActuationHandler.actuate(simCard);
        databaseRecord.save(simCard, actuationResult);
    }

    @GetMapping(value = "/query/{simCardId}")
    public Sim handleActivationRequest(@PathVariable Long simCardId) {
        return databaseRecord.querySimCard(simCardId);
    }
}
