package ro.mycode.telefonapi.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.telefonapi.model.Telefon;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TelefonRepo extends JpaRepository<Telefon,Long> {

    @Query("select distinct p.marca from Telefon p")
    List<String>getAllMarci();

    @Query("select t from Telefon  t where t.marca=?1")
    List<Telefon>getAllTelefoaneByMarca(String marca);

    @Query("select t from Telefon  t where t.model=?1")
    List<Telefon>getAllTelefoaneByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Telefon t where t.id=?1")
    void deleteTelefonByMarca(String marca);


    Telefon findByModel(String model);

    @Transactional
    @Modifying
    @Query("select distinct t from Telefon  t order by t.pret")
    List<Telefon>sortByPrice();

    @Transactional
    @Modifying
    @Query("select distinct t from Telefon t order by  t.marca")
    List<Telefon> sortByMarca();

    @Transactional
    @Modifying
    @Query("select distinct  t from Telefon  t order by t.model")
    List<Telefon>sortByModel();

}


