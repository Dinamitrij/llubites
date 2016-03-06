package lv.llu.bites.dao;

import lv.llu.bites.model.Device;
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

    public List<UserSensor> listUserSensors() {
        List<UserSensor> result = new ArrayList<UserSensor>();
        final Query query = entityManager.createQuery("SELECT us from UserSensor us");
        result = (List<UserSensor>) query.getResultList();
        return result;
    }

}
