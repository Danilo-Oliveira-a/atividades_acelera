package br.atos.zoologico.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration// Indica que é uma classe de configuração
public class DataConfiguration {

    @Bean // Conexão com o banco de dados
    public DataSource dataSource() {

        DriverManagerDataSource driveBanco = new DriverManagerDataSource();
        driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driveBanco.setUrl("jdbc:mysql://10.0.0.105:3306/my_database?useTimezone=true&serverTimezone=UTC");
        driveBanco.setUsername("user");
        driveBanco.setPassword("root");
//            driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
//            driveBanco.setUrl("jdbc:mysql://b3tb7m1v7hvkjmjw7apy-mysql.services.clever-cloud.com:3306/b3tb7m1v7hvkjmjw7apy?useTimezone=true&serverTimezone=UTC");
//            driveBanco.setUsername("ujhjago0sd02ddly");
//            driveBanco.setPassword("HRshw59rXoOZqxANcxh4");

        return driveBanco;

    }
    @Bean // Parametros do Hibernate
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        adapter.setPrepareConnection(true);


        return adapter;

    }



}
