package ro.mycode.telefonapi.controller;

import org.springframework.web.bind.annotation.*;

import ro.mycode.telefonapi.dtos.TelefonDTO;
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

    @GetMapping("api/v1/phones")//v1=versiune unu
    public List<Telefon> getAllTelefoane() {
        System.out.println("aici");
        return telefonRepo.findAll();
    }

    //endpoint care aduce marcile
    @GetMapping("api/v1/phones/marci")
    public List<String> getAllMarci() {
        return telefonRepo.getAllMarci();
    }

    //enpoint care sa returneze toate obiectele care au marca respectiva,primeste ca parametru marca

    @GetMapping("api/v1/{marca}")
    public List<Telefon> getAllTelefoaneByMarca(@PathVariable String marca) {
        return telefonRepo.getAllTelefoaneByMarca(marca);
    }

    @PostMapping("api/v1/add")
    public Telefon addTelefon(@RequestBody Telefon telefon) {
        this.telefonRepo.save(telefon);

        return telefon;
    }

//    @DeleteMapping("api/v1/deleteByMarca/{marca}")
//    public String deletTelefon(@PathVariable String marca){
//        this.telefonRepo.deleteTelefonByMarca(marca);
//
//        return  marca;
//    }

    @DeleteMapping("api/v1/delete/{id}")
    public int deleteById(@PathVariable int id) {
        this.telefonRepo.deleteById((long) id);
        return id;
    }

    @PutMapping("api/v1/update")
    public Telefon updateTelefon(@RequestBody TelefonDTO telefon) {
        Telefon t = telefonRepo.findByModel(telefon.getModel());
        if (telefon.getPret() != 0) {
            t.setPret(telefon.getPret());
        } else System.out.println("Nu are valoare");

        if (telefon.getModel().equals("") == false) {
            t.setModel(telefon.getModel());
        } else System.out.println("Nu are valoare");

        if (telefon.getMarca().equals("") == false) {
            t.setMarca(telefon.getMarca());
        } else System.out.println("Nu are valoare");
        if (telefon.getPret() != 0) {
            t.setPret(telefon.getPret());
        } else System.out.println("Nu are valoare");
        telefonRepo.save(t);
        return t;

    }

    @GetMapping("api/v1/get/phone/{id}")
    public Telefon getPhoneById(@PathVariable int id) {

        return telefonRepo.findById(Long.valueOf(id)).get();
    }

    @GetMapping("api/v1/sortByPrice")
    public List<Telefon>sortByPrice(){
        return telefonRepo.sortByPrice();
    }

    @GetMapping("api/v1/sortByMarca")
    public  List<Telefon>sortByMarca(){
        return telefonRepo.sortByMarca();
    }
    
    @GetMapping("api/v1/sortByModel")
    public List<Telefon>sortByModel(){
        return telefonRepo.sortByModel();
    }





}






