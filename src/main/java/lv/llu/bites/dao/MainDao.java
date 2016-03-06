package lv.llu.bites.dao;

import lv.llu.bites.model.Device;
import lv.llu.bites.model.Sensor;
import lv.llu.bites.model.UserSensor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MainDao {

    @PersistenceContext(unitName = "persistenceUnit")
    EntityManager entityManager;

    public List<Device> listDevices() {
        List<Device> result = new ArrayList<Device>();
        final Query query = entityManager.createQuery("SELECT d from Device d");
        result = (List<Device>) query.getResultList();
        return result;
    }

    public List<UserSensor> listUserSensors(Long deviceId) {
        List<UserSensor> result = new ArrayList<UserSensor>();
        final Query query = entityManager.createQuery("SELECT us FROM UserSensor us WHERE us.idDevice = :deviceId");
        query.setParameter("deviceId", deviceId);
        result = (List<UserSensor>) query.getResultList();
        return result;
    }

    public List<Sensor> listSensorsById(Long sensorId) {
        List<Sensor> result = new ArrayList<Sensor>();
        final Query query = entityManager.createQuery("SELECT s FROM Sensor s WHERE s.id = :sensorId");
        query.setParameter("sensorId", sensorId);
        result = (List<Sensor>) query.getResultList();
        return result;
    }

    public List<Sensor> listSensorsByIds(List<Long> sensorIds) {
        List<Sensor> result = new ArrayList<Sensor>();
        final Query query = entityManager.createQuery("SELECT s FROM Sensor s WHERE s.id IN :sensorIds");
        query.setParameter("sensorIds", sensorIds);
        result = (List<Sensor>) query.getResultList();
        return result;
    }

}
