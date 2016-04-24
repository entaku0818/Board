package board.entity;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;


@Entity
public class Board {

    public Integer id;

    public String name;

    public String memo;

    @Temporal(TemporalType.DATE)
    public Timestamp time;

}