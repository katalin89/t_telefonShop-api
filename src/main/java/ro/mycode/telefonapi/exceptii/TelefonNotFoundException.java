package ro.mycode.telefonapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.telefonapi.constants.Constants.TELEFON_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TelefonNotFoundException extends RuntimeException {

    public TelefonNotFoundException(){
        super(TELEFON_NOT_FOUND_EXCEPTION);
    }
}
