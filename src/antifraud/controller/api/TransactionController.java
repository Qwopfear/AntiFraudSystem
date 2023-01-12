package antifraud.controller.api;


import antifraud.pojo.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController()
@RequestMapping("")
public class TransactionController {

    @PostMapping("/api/antifraud/transaction")
    public ResponseEntity<Object> commitTransaction(
            @RequestBody Map<String, Long> json
    ) {
        Long amount = json.get("amount");
        if (amount < 1) {
            throw new IllegalArgumentException("Minimum value of transactions is 1");
        }
        Transaction transaction = new Transaction(amount);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }


}
