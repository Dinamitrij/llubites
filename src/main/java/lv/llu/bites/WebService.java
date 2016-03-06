package lv.llu.bites;

import lv.llu.bites.model.Device;
import lv.llu.bites.model.UserSensor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/rest")
@Consumes({"application/json"})
@Produces({"application/json"})
@Stateless
public class WebService {

    @PersistenceContext(unitName = "persistenceUnit")
    EntityManager entityManager;

    @GET
    @Path("/dev") // Locally works as: http://localhost:8080/service/rest/dev
    public List<Device> getBooks() {
        List<Device> result = new ArrayList<Device>();
        final Query query = entityManager.createQuery("SELECT d from Device d");
        result = (List<Device>) query.getResultList();
        return result;
    }

    @GET
    @Path("/us")
    public List<UserSensor> getUserSensors() {
        List<UserSensor> result = new ArrayList<UserSensor>();
        final Query query = entityManager.createQuery("SELECT us from UserSensor us");
        result = (List<UserSensor>) query.getResultList();
        return result;
    }

}
