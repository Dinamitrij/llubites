package lv.llu.bites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Sensors")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 2431316090845738502L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "place")
    private String place;

    @Column(name = "hiveNr")
    private Integer hiveNr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getHiveNr() {
        return hiveNr;
    }

    public void setHiveNr(Integer hiveNr) {
        this.hiveNr = hiveNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sensor sensor = (Sensor) o;

        if (code != null ? !code.equals(sensor.code) : sensor.code != null) {
            return false;
        }
        if (hiveNr != null ? !hiveNr.equals(sensor.hiveNr) : sensor.hiveNr != null) {
            return false;
        }
        if (id != null ? !id.equals(sensor.id) : sensor.id != null) {
            return false;
        }
        if (place != null ? !place.equals(sensor.place) : sensor.place != null) {
            return false;
        }
        if (type != null ? !type.equals(sensor.type) : sensor.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (hiveNr != null ? hiveNr.hashCode() : 0);
        return result;
    }
}
