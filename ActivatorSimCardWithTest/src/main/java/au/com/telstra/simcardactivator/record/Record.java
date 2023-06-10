package au.com.telstra.simcardactivator.record;

import au.com.telstra.simcardactivator.model.ActivateResponse;
import au.com.telstra.simcardactivator.model.Sim;
import javax.persistence.*;


@Entity
public class Record{

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String iccid;

    @Column(nullable = false)
    private String costumerEmail;

    @Column(nullable = false)
    private boolean activate;

    public Record(Sim sim, ActivateResponse activate) {
        this.iccid = sim.getIccid();
        this.costumerEmail = sim.getCustomerEmail();
        this.activate = activate.getSuccess();
    }

    public long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCostumerEmail() {
        return costumerEmail;
    }

    public boolean isActivate() {
        return activate;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", iccid='" + iccid + '\'' +
                ", costumerEmail='" + costumerEmail + '\'' +
                ", activate=" + activate +
                '}';
    }
}
