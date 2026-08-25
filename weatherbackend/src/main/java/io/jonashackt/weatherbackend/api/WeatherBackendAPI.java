package io.jonashackt.weatherbackend.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jonashackt.weatherbackend.businesslogic.IncredibleLogic;
import io.jonashackt.weatherbackend.model.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/weather")
public class WeatherBackendAPI {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherBackendAPI.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @POST
    @Path("/general/outlook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GeneralOutlook generateGeneralOutlook(Weather weather) throws JsonProcessingException {
        LOG.info("Request for /general/outlook with POST");

        // Some incredible Businesslogic...
        LOG.info("Called Backend");

        LOG.info("Object as JSON:" + objectMapper.writeValueAsString(weather));

        GeneralOutlook outlook = IncredibleLogic.generateGeneralOutlook();
        LOG.info("GeneralOutlook as JSON: \n " + objectMapper.writeValueAsString(outlook));

        return outlook;
    }

    @GET
    @Path("/general/outlook")
    @Produces(MediaType.APPLICATION_JSON)
    public String infoAboutGeneralOutlook() throws JsonProcessingException {
        LOG.info("Request for /general/outlook with GET");

        Weather weather = new Weather();
        weather.setFlagColor("blue");
        weather.setPostalCode("99425");
        weather.addUser(new User(55, 5634500, MethodOfPayment.Bitcoin));
        weather.setProduct(Product.ForecastBasic);

        String weatherJson = objectMapper.writeValueAsString(weather);

        return "Try a POST also against this URL! Just send some body with it like: '" + weatherJson + "'";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String whatsTheSenseInThat(@PathParam("name") String name) {
        LOG.info("Request for /{" + name + "} with GET");
        return "Hello " + name + "! This is a RESTful HttpService written in Spring. Try to use some other HTTP verbs (don´t say 'methods' :P ) :)";
    }
}
