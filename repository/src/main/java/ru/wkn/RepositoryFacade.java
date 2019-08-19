package ru.wkn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.services.IService;

/**
 * The class {@code RepositoryFacade} represents the facade of the repository.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public class RepositoryFacade {

    /**
     * The abstract representation of the repository service.
     */
    private IService service;

    /**
     * Initializes a newly created {@code RepositoryFacade} object with the assignment value from the context for the
     * {@code service} property.
     *
     * @param serviceBeanName the repository service bean name
     */
    public RepositoryFacade(String serviceBeanName) {
        service = (IService) new ClassPathXmlApplicationContext("/META-INF/spring-data-context.xml")
                .getBean(serviceBeanName);
    }
}
