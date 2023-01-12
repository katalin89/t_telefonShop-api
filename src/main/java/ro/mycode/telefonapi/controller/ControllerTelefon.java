package ro.mycode.telefonapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.telefonapi.TelefonApiApplication;
import ro.mycode.telefonapi.model.Telefon;
import ro.mycode.telefonapi.repositpry.TelefonRepo;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerTelefon {
    private TelefonRepo telefonRepo;

    public ControllerTelefon(TelefonRepo telefonRepo) {
        this.telefonRepo = telefonRepo;
    }

    @GetMapping("api/v1/telefoane")//v1=versiune unu
    public List<Telefon>getAllTelefoane(){
        System.out.println("aici");
        return telefonRepo.findAll();
    }

    //endpoint care aduce marcile
    @GetMapping("api/v1/telefoane/marci")
    public List<String> getAllMarci(){
        return  telefonRepo.getAllMarci();
    }

}


