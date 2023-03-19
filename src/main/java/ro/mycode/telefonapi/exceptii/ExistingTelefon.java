package ro.mycode.telefonapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.telefonapi.constants.Constants.TELEFON_DUPLICATION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingTelefon  extends RuntimeException{

    public ExistingTelefon(){
        super(TELEFON_DUPLICATION);
    }
}
