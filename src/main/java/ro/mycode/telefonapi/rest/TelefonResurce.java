package ro.mycode.telefonapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.telefonapi.dtos.TelefonDTO;
import ro.mycode.telefonapi.model.Telefon;
import ro.mycode.telefonapi.services.TelefonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/masina")
public class TelefonResurce {

    private TelefonService telefonService;

    public TelefonResurce(TelefonService telefonService){
        this.telefonService=telefonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Telefon>>getAllTelefoane(){
        List<Telefon>allTelefoane=telefonService.getAllTelefoane();
        return new ResponseEntity<>(allTelefoane, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByModel/{model}")
    ResponseEntity deleteByModel(@PathVariable String model){
        this.telefonService.deleteTelefonByModel(model);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody TelefonDTO telefon,String model){
        this.telefonService.update(telefon,model);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
