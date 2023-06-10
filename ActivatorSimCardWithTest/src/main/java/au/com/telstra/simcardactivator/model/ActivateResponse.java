package au.com.telstra.simcardactivator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivateResponse {
    private boolean success;

    public ActivateResponse() {
    }

    public ActivateResponse(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ActivateResponse {success=" + success + "}";
    }
}
