package pl.krol.database.spring.ddl.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDate;

@Entity
public class C {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long number;
    String name;
    LocalDate myDate;
    LocalDate myDate2;
    Color myColor;

    protected C() {
    }

    public C (String name, LocalDate date1, LocalDate date2, Color color){
        this.name=name;
        this.myDate=date1;
        this.myDate2=date2;
        this.myColor=color;
    }

}
