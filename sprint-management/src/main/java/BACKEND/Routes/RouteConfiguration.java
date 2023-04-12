package BACKEND.Routes;

import BACKEND.Controllers.SprintController;
import BACKEND.Models.Sprint;
import jakarta.servlet.ServletException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.*;

@Configuration
@EnableWebMvc
public class RouteConfiguration implements WebMvcConfigurer {

    private final SprintController sprintController;

    public RouteConfiguration(SprintController sprintController) {
        this.sprintController = sprintController;
    }

    @Bean
    public RouterFunction<ServerResponse> sprintRoutes() {
        return route()
                .GET("/sprints", this::getAllSprints)
                .GET("/sprints/{id}", this::getSprintById)
                .POST("/sprints", this::createSprint)
                .PUT("/sprints/{id}", this::updateSprint)
                .DELETE("/sprints/{id}", this::deleteSprint)
                .build();
    }

    private ServerResponse getAllSprints(ServerRequest request) {
        List<Sprint> sprints = sprintController.getAllModels();
        return ok().body(sprints);
    }

    private ServerResponse getSprintById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Sprint sprint = null;
        try {
            sprint = sprintController.getById(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (sprint != null) {
            return ok().body(sprint);
        } else {
            return notFound().build();
        }
    }

    private ServerResponse createSprint(ServerRequest request) throws ServletException, IOException, javax.servlet.ServletException {
        Sprint sprint = request.body(Sprint.class);
        int id = sprintController.create(sprint);
        if (id != -1) {
            sprint.setId(id);
            return ok().body(sprint);
        } else {
            return badRequest().build();
        }
    }

    private ServerResponse updateSprint(ServerRequest request) throws ServletException, IOException, javax.servlet.ServletException {
        int id = Integer.parseInt(request.pathVariable("id"));
        Sprint sprint = request.body(Sprint.class);
        sprint.setId(id);
        boolean updated = sprintController.updateCore(sprint);
        if (updated) {
            return ok().body(sprint);
        } else {
            return badRequest().build();
        }
    }

    private ServerResponse deleteSprint(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        try {
            boolean deleted = sprintController.delete(id);
            if (deleted) {
                return ok().build();
            } else {
                return notFound().build();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return badRequest().build();
        }
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configure) {
        configure.setUseSuffixPatternMatch(false);
    }
}
