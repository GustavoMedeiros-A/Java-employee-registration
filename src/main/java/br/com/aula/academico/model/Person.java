package br.com.aula.academico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @NotNull
    @NotBlank
    private String name;

    private int payCheck;

    private boolean nightWorker;

    private int numberChildren;


    public double freePayCheck(Person person) {
        return payCheck - inss() + isNightWorker() + valueNumberChildren() - discountVoucher();
    }

    private double valueNumberChildren() {
        return (numberChildren >= 3) ? 150 : numberChildren * 50;
    }

    private double isNightWorker() {
        return nightWorker ? 0.06 * payCheck : 0;
    }
    
    private double inss() {
        return payCheck * 0.13;
    }

    private double discountVoucher() {
        return payCheck * 0.06;
    }


    
}
