package lv.llu.bites;

import lv.llu.bites.dao.MainDao;
import lv.llu.bites.model.Device;
import lv.llu.bites.model.Sensor;
import lv.llu.bites.model.UserSensor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
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
    public Response getBooks() {
        try {
            final List<Device> deviceList = mainDao.listDevices();
            if (deviceList.isEmpty()) {
                return Response.noContent().build();
            } else {
                return Response.ok().entity(deviceList).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/us/{id}")
    public Response getUserSensors(@PathParam("id") Long deviceId) {
        try {
            final List<UserSensor> userSensorList = mainDao.listUserSensors(deviceId);
            if (userSensorList.isEmpty()) {
                return Response.noContent().build();
            } else {
                return Response.ok().entity(userSensorList).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/sen/{id}")
    public Response listSensorsById(@PathParam("id") Long sensorId) {
        try {
            final List<Sensor> sensorList = mainDao.listSensorsById(sensorId);
            if (sensorList.isEmpty()) {
                return Response.noContent().build();
            } else {
                return Response.ok().entity(sensorList).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }

    /**
     * List sensors as: /service/rest/sensors?s=1&s=2&s=3
     *
     * @param sensorIds
     *
     * @return
     */
    @GET
    @Path("/sensors")
    public Response listSensorsByIds(@QueryParam("s") List<Long> sensorIds) {
        try {
            final List<Sensor> sensorList = mainDao.listSensorsByIds(sensorIds);
            if (sensorList.isEmpty()) {
                return Response.noContent().build();
            } else {
                return Response.ok().entity(sensorList).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }

}
