package ro.mycode.telefonapi.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.telefonapi.dtos.TelefonDTO;
import ro.mycode.telefonapi.exceptii.ExceptiiTelefonDBEmpty;
import ro.mycode.telefonapi.exceptii.TelefonNotFoundException;
import ro.mycode.telefonapi.model.Telefon;
import ro.mycode.telefonapi.repositpry.TelefonRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class TelefonService {

    private TelefonRepo telefonRepo;

    public TelefonService(TelefonRepo telefonRepo){
        this.telefonRepo=telefonRepo;
    }

    public List<Telefon>getAllTelefoane()throws ExceptiiTelefonDBEmpty{
        List<Telefon>telefoane=telefonRepo.findAll();
        if(telefoane.size()>0){
            return telefoane;
        }
        throw  new ExceptiiTelefonDBEmpty();
    }

    public  void deleteTelefonByModel(String model)throws TelefonNotFoundException{
        Telefon byModel=telefonRepo.findByModel(model);
        if(byModel != null){
            telefonRepo.getAllTelefoaneByModel(model);
        }else{
            throw new TelefonNotFoundException();
        }
    }
    @Transactional
    public  void addTelefon(Telefon telefon) throws TelefonNotFoundException{

    }

    @Transactional
    @Modifying

    public  void update(@RequestBody TelefonDTO telefon,String model)throws TelefonNotFoundException{

        Telefon t=telefonRepo.findByModel(telefon.getModel());

        if(t==null){
            throw new TelefonNotFoundException();
        }

        if(telefon.getMarca().equals("")==false){
            t.setMarca(telefon.getMarca());
        }
        if(telefon.getModel().equals("")==false){
            t.setModel(telefon.getModel());
        }

        if(telefon.getPret()!=0){
            t.setPret(telefon.getPret());
        }

    }

}