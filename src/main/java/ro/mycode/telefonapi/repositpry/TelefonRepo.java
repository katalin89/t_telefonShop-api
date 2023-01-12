package ro.mycode.telefonapi.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.telefonapi.model.Telefon;

import java.util.List;

@Repository
public interface TelefonRepo extends JpaRepository<Telefon,Long> {

    @Query("select distinct p.marca from Telefon p")
    List<String>getAllMarci();
}


