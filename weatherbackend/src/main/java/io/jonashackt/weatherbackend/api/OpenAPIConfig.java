package io.jonashackt.weatherbackend.api;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "weatherbackend",
                version = "v2.0"
        ),
        servers = @Server(url = "http://weatherbackend:8080")
)
public class OpenAPIConfig extends Application {
}
