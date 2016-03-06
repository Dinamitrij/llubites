package lv.llu.bites;

import lv.llu.bites.dao.MainDao;
import lv.llu.bites.model.Device;
import lv.llu.bites.model.UserSensor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/rest")
@Consumes({"application/json"})
@Produces({"application/json"})
@Stateless
public class WebService {

    @EJB
    private MainDao mainDao;

    @GET
    @Path("/dev") // Locally works as: http://localhost:8080/service/rest/dev
    public List<Device> getBooks() {
        return mainDao.listDevices();
    }

    @GET
    @Path("/us")
    public List<UserSensor> getUserSensors() {
        return mainDao.listUserSensors();
    }

}
