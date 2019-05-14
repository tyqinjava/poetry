package org.curd;

import org.curd.dao.BaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepository.class)
public class CurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurdApplication.class);
    }
}
