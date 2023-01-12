
package ro.mycode.telefonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="telefoane")
@AllArgsConstructor
@NoArgsConstructor
public class Telefon  implements Comparable<Telefon>{
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String marca;
    private String model;
    private int pret;

    public Telefon(String marca, String model, int pret) {
        this.marca = marca;
        this.model = model;
        this.pret = pret;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+marca+","+model+","+pret;
        return text;



    }

    @Override
    public int compareTo(Telefon o) {
        return 0;
    }


    public  int compare(Object o){
        Telefon telefon=(Telefon) o;
        if(this.pret>telefon.pret)
        {
            return 1;
        }else if(this.pret<telefon.pret){
            return 0;
        }
        return -1;

    }


}