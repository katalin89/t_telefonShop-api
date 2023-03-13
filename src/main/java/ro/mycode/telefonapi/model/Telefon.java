
package ro.mycode.telefonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

//    public Telefon(String marca, String model, int pret) {
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Telefon")
@Table(name = "telefoane")

public class Telefon implements Comparable<Telefon> {
    @Id
    @SequenceGenerator(name = "telefon_sequence", sequenceName = "telefon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefon_sequence")


    private Long id;

    @Column(name = "marca", nullable = false)
    @Size(min = 4, message = "Marca trebuie sa fie de minim 4 caractere")
    private String marca;

    @Column(name = "model", nullable = false)
    @Size(max = 20, message = "Model poate fi max 20 de caractere")
    private String model;

    @Column(name = "pret")
    @Max(value = 30000, message = "Pretul nu poate depasi 30000 lei")
    private int pret;

    @Override
    public int compareTo(Telefon o) {
        if(this.model.compareTo(o.model)>0){
            return 1;
        }
        if(this.model.compareTo(o.model)<0){
            return -1;
        }else
        return 0;
    }

    @Override
    public  boolean equals(Object o){
        Telefon telefon=(Telefon) o;
        return  this.model.equals(telefon.model);
    }

}