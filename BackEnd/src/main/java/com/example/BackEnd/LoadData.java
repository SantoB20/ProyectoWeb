package com.example.BackEnd;

import com.example.entities.Compra;
import com.example.entities.Licor;
import com.example.entities.User;
import com.example.repositories.CompraRepository;
import com.example.repositories.LicorRepository;
import com.example.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {
    
    @Bean
    CommandLineRunner initLicores(LicorRepository repo){
        return args ->{
            repo.save(new Licor("Dom Perignon","Francia","Champagne",3,12,1660400));
            repo.save(new Licor("Casillero del diablo", "Chile","Vino",6,13,70000));
            repo.save(new Licor("Barolo", "Italia","Vino",3,14,884000));
            repo.save(new Licor("Armand de Brignac", "Francia","Champagne",0,12,2490000));
            repo.save(new Licor("Bombay", "Inglaterra","Ginebra",4,47,274890));
            repo.save(new Licor("Bulldog", "Inglaterra","Ginebra",6,40,209980));
            repo.save(new Licor("Petrus", "Francia","Vino",4,17,1200000));
            repo.save(new Licor("Chivas Regal", "Escocia","Whisky",8,40,122000));
            repo.save(new Licor("Don Julio", "Mexico","Tequila",9,40,220000));
            repo.save(new Licor("Glenfiddich", "Escocia","Whisky",6,40,121990));
            repo.save(new Licor("Hendriks", "Escoces","Ginebra",5,44,189800));
            repo.save(new Licor("Patron", "Mexico","Tequila",9,40,219990));
            repo.save(new Licor("Macallan", "Escoces","Whisky",6,43,365700));
            repo.save(new Licor("Siete leguas", "Mexico","Tequila",6,38,219990));
            repo.save(new Licor("Moet", "Francia","Champagne",3,12,2035399));
        };
    }

    @Bean
    CommandLineRunner initUsuarios(UserRepository repoUser, CompraRepository repoCompra, LicorRepository repoLicor){
        return args ->{
            User us1 = new User("usuario1","usuario1@gmail.com","54321","123456");
            User us2 = new User("usuario2","usuario2@gmail.com","98765","123456");

            repoUser.save(us1);
            repoUser.save(us2);

            Compra comp1_1 = new Compra(us1);

            comp1_1.agregarLicor(repoLicor.findById(1L).get());
            comp1_1.agregarLicor(repoLicor.findById(5L).get());
            comp1_1.setTotal(repoLicor.findById(1L).get().getPrecio()+repoLicor.findById(5L).get().getPrecio());
            repoCompra.save(comp1_1);

            us1.agregarCompra(comp1_1);

            Compra comp1_2 = new Compra(us1);

            comp1_2.agregarLicor(repoLicor.findById(7L).get());
            comp1_2.agregarLicor(repoLicor.findById(9L).get());
            comp1_2.setTotal(repoLicor.findById(7L).get().getPrecio()+repoLicor.findById(9L).get().getPrecio());
            repoCompra.save(comp1_2);

            us1.agregarCompra(comp1_2);

            repoUser.save(us1);

            Compra comp2_1 = new Compra(us2);

            comp2_1.agregarLicor(repoLicor.findById(14L).get());
            comp2_1.agregarLicor(repoLicor.findById(11L).get());
            comp2_1.setTotal(repoLicor.findById(14L).get().getPrecio()+repoLicor.findById(11L).get().getPrecio());
            repoCompra.save(comp2_1);

            us2.agregarCompra(comp2_1);

            Compra comp2_2 = new Compra(us2);

            comp2_2.agregarLicor(repoLicor.findById(15L).get());
            comp2_2.agregarLicor(repoLicor.findById(4L).get());
            comp2_2.agregarLicor(repoLicor.findById(2L).get());
            comp2_2.setTotal(repoLicor.findById(15L).get().getPrecio() + repoLicor.findById(4L).get().getPrecio() + repoLicor.findById(2L).get().getPrecio());
            repoCompra.save(comp2_2);

            us2.agregarCompra(comp2_2);

            repoUser.save(us2);
        };
    }

}
