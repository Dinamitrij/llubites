package lv.llu.bites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UserSensors")
public class UserSensor implements Serializable {

    private static final long serialVersionUID = -5930511453320510523L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_device")
    private Long idDevice;

    @Column(name = "id_sensor")
    private Long idSensor;

    @Column(name = "position")
    private Integer position;

    @Column(name = "last_value")
    private Double lastValue;

    @Column(name = "last_measurement")
    private Date lastMeasurement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Long idDevice) {
        this.idDevice = idDevice;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getLastValue() {
        return lastValue;
    }

    public void setLastValue(Double lastValue) {
        this.lastValue = lastValue;
    }

    public Date getLastMeasurement() {
        return lastMeasurement;
    }

    public void setLastMeasurement(Date lastMeasurement) {
        this.lastMeasurement = lastMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserSensor that = (UserSensor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (idDevice != null ? !idDevice.equals(that.idDevice) : that.idDevice != null) {
            return false;
        }
        if (idSensor != null ? !idSensor.equals(that.idSensor) : that.idSensor != null) {
            return false;
        }
        if (lastMeasurement != null ? !lastMeasurement.equals(that.lastMeasurement) : that.lastMeasurement != null) {
            return false;
        }
        if (lastValue != null ? !lastValue.equals(that.lastValue) : that.lastValue != null) {
            return false;
        }
        if (position != null ? !position.equals(that.position) : that.position != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idDevice != null ? idDevice.hashCode() : 0);
        result = 31 * result + (idSensor != null ? idSensor.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (lastValue != null ? lastValue.hashCode() : 0);
        result = 31 * result + (lastMeasurement != null ? lastMeasurement.hashCode() : 0);
        return result;
    }
}
