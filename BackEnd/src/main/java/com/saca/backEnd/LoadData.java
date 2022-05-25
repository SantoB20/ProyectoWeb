package com.saca.backEnd;

import com.saca.entities.Compra;
import com.saca.entities.Licor;
import com.saca.entities.User;
import com.saca.entities.compraDetalle;
import com.saca.repositories.CompraRepository;
import com.saca.repositories.LicorRepository;
import com.saca.repositories.UserRepository;
import com.saca.repositories.detalleCompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class LoadData {
        
        @Autowired
        private BCryptPasswordEncoder encoder;

        @Bean
        CommandLineRunner initLicores(LicorRepository repo) {
                return args -> {
                        repo.save(new Licor("Dom Perignon", "Francia", "Champagne", 3, 12, 1660400));
                        repo.save(new Licor("Casillero del diablo", "Chile", "Vino", 6, 13, 70000));
                        repo.save(new Licor("Barolo", "Italia", "Vino", 3, 14, 884000));
                        repo.save(new Licor("Armand de Brignac", "Francia", "Champagne", 0, 12, 2490000));
                        repo.save(new Licor("Bombay", "Inglaterra", "Ginebra", 4, 47, 274890));
                        repo.save(new Licor("Bulldog", "Inglaterra", "Ginebra", 6, 40, 209980));
                        repo.save(new Licor("Petrus", "Francia", "Vino", 4, 17, 1200000));
                        repo.save(new Licor("Chivas Regal", "Escocia", "Whisky", 8, 40, 122000));
                        repo.save(new Licor("Don Julio", "Mexico", "Tequila", 9, 40, 220000));
                        repo.save(new Licor("Glenfiddich", "Escocia", "Whisky", 6, 40, 121990));
                        repo.save(new Licor("Hendriks", "Escoces", "Ginebra", 5, 44, 189800));
                        repo.save(new Licor("Patron", "Mexico", "Tequila", 9, 40, 219990));
                        repo.save(new Licor("Macallan", "Escoces", "Whisky", 6, 43, 365700));
                        repo.save(new Licor("Siete leguas", "Mexico", "Tequila", 6, 38, 219990));
                        repo.save(new Licor("Moet", "Francia", "Champagne", 3, 12, 2035399));
                        System.out.println("Licores cargados");
                };
        }

        @Bean
        CommandLineRunner initUsuarios(UserRepository repoUser, CompraRepository repoCompra, LicorRepository repoLicor,
                        detalleCompraRepository repoDetalle) {
                return args -> {

                        User us1 = new User("usuario1", "usuario1@gmail.com", "54321", encoder.encode("123456"),"CLIENT");
                        User us2 = new User("usuario2", "usuario2@gmail.com", "98765", encoder.encode("123456"),"CLIENT");
                        User us3 = new User("admin","admin@gmail.com","23456",encoder.encode("123456"),"ADMIN");

                        repoUser.save(us1);
                        repoUser.save(us2);
                        repoUser.save(us3);

                        Compra comp1_1 = new Compra(us1);
                        repoCompra.save(comp1_1);

                        comp1_1.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(1L).get().getNombre(),
                                                        repoLicor.findById(1L).get().getPrecio(), comp1_1)));
                        comp1_1.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(5L).get().getNombre(),
                                                        repoLicor.findById(5L).get().getPrecio(), comp1_1)));
                        comp1_1.setTotal(repoLicor.findById(1L).get().getPrecio()
                                        + repoLicor.findById(5L).get().getPrecio());
                        repoCompra.save(comp1_1);

                        us1.agregarCompra(comp1_1);

                        Compra comp1_2 = new Compra(us1);
                        repoCompra.save(comp1_2);

                        comp1_2.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(7L).get().getNombre(),
                                                        repoLicor.findById(7L).get().getPrecio(), comp1_2)));
                        comp1_2.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(9L).get().getNombre(),
                                                        repoLicor.findById(9L).get().getPrecio(), comp1_2)));
                        comp1_2.setTotal(repoLicor.findById(7L).get().getPrecio()
                                        + repoLicor.findById(9L).get().getPrecio());
                        repoCompra.save(comp1_2);

                        us1.agregarCompra(comp1_2);

                        repoUser.save(us1);

                        Compra comp2_1 = new Compra(us2);
                        repoCompra.save(comp2_1);

                        comp2_1.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(14L).get().getNombre(),
                                                        repoLicor.findById(14L).get().getPrecio(), comp2_1)));
                        comp2_1.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(11L).get().getNombre(),
                                                        repoLicor.findById(11L).get().getPrecio(), comp2_1)));
                        comp2_1.setTotal(repoLicor.findById(14L).get().getPrecio()
                                        + repoLicor.findById(11L).get().getPrecio());
                        repoCompra.save(comp2_1);

                        us2.agregarCompra(comp2_1);

                        Compra comp2_2 = new Compra(us2);
                        repoCompra.save(comp2_2);

                        comp2_2.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(15L).get().getNombre(),
                                                        repoLicor.findById(15L).get().getPrecio(), comp2_2)));
                        comp2_2.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(4L).get().getNombre(),
                                                        repoLicor.findById(4L).get().getPrecio(), comp2_2)));
                        comp2_2.agregarLicor(
                                        repoDetalle.save(new compraDetalle(repoLicor.findById(2L).get().getNombre(),
                                                        repoLicor.findById(2L).get().getPrecio(), comp2_2)));
                        comp2_2.setTotal(repoLicor.findById(15L).get().getPrecio()
                                        + repoLicor.findById(4L).get().getPrecio()
                                        + repoLicor.findById(2L).get().getPrecio());
                        repoCompra.save(comp2_2);

                        us2.agregarCompra(comp2_2);

                        repoUser.save(us2);

                        System.out.println("Usuarios con compras creados");
                };
        }

}
