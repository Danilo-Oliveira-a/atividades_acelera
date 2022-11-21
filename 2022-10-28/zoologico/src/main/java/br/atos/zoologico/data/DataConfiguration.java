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
        driveBanco.setUrl("jdbc:mysql://localhost:3306/my_database?useTimezone=true&serverTimezone=UTC");
        driveBanco.setUsername("root");
        driveBanco.setPassword("root");
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
