package ru.wkn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.service.IService;

@Getter
@Setter
public class RepositoryFacade {

    private IService service;

    public RepositoryFacade(String serviceBeanName) {
        service = (IService) new ClassPathXmlApplicationContext("/META-INF/spring-data-context.xml")
                .getBean(serviceBeanName);
    }
}
