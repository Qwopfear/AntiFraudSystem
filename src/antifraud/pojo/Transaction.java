package antifraud.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;


public class Transaction {

    @JsonIgnore
    @Min(value = 1,message = "Minimum transaction value is 1")
    private Long value;
    private final String result;

    public Transaction(Long value) {
        this.value = value;
        if (value > 1500) {
            result = "PROHIBITED";
        } else {
            if (value > 200) {
                result = "MANUAL_PROCESSING";
            } else {
                result = "ALLOWED";
            }
        }

    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getResult() {
        return result;
    }
}
