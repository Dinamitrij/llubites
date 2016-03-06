package lv.llu.bites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Measurements")
public class Measurement implements Serializable {

    private static final long serialVersionUID = -859025490617464714L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_user_sensor")
    private Long idUserSensor;

    @Column(name = "data")
    private Double data;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserSensor() {
        return idUserSensor;
    }

    public void setIdUserSensor(Long idUserSensor) {
        this.idUserSensor = idUserSensor;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Measurement that = (Measurement) o;

        if (data != null ? !data.equals(that.data) : that.data != null) {
            return false;
        }
        if (date != null ? !date.equals(that.date) : that.date != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (idUserSensor != null ? !idUserSensor.equals(that.idUserSensor) : that.idUserSensor != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idUserSensor != null ? idUserSensor.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
