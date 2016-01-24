package be.vives;

import be.vives.web.library.services.AuthorService;
import be.vives.web.library.services.BookService;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/api")
public class RestConfig extends ResourceConfig
{

    public RestConfig() {
        this.register(JacksonAnnotationIntrospector.class)
                .register(JacksonJaxbJsonProvider.class)
                .register(AuthorService.class)
                .register(BookService.class);
        
        this.property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);      
    }
    
}
