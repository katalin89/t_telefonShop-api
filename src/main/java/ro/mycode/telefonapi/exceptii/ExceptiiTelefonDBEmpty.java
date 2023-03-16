package ro.mycode.telefonapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.telefonapi.constants.Constants.EMPTY_DATABASE_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptiiTelefonDBEmpty extends RuntimeException {

    public ExceptiiTelefonDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
