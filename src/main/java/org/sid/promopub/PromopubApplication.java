package org.sid.promopub;

import org.sid.promopub.dao.PromotionRepository;
import org.sid.promopub.dao.PubliciteRepository;
import org.sid.promopub.entities.Promotion;
import org.sid.promopub.entities.Publicite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class PromopubApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private PubliciteRepository publiciteRepository;

    public static void main(String[] args) {
        SpringApplication.run(PromopubApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Promotion.class, Publicite.class);
       promotionRepository.save(new Promotion(null,"p1",true,"Col1","php1.png"));
       promotionRepository.save(new Promotion(null,"p2",true,"Col2","php1.png"));
       promotionRepository.save(new Promotion(null,"p3",false,"Col1","php1.png"));
       publiciteRepository.save(new Publicite(null,"Pub1",1500,true,"phpub1"));
       publiciteRepository.save(new Publicite(null,"Pub2",3000,true,"phpub2"));
       publiciteRepository.save(new Publicite(null,"Pub3",2000,true,"phpub3"));
    }
}
