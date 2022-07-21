package br.unesp.agrotech.configurations;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class BeansConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/fazenda-vertical");
        driverManagerDataSource.setUsername("mysql-soo");
        driverManagerDataSource.setPassword("Grupo05@SOO");
        return driverManagerDataSource;
    }

    @Bean
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

// spring.datasource.url=jdbc:mysql://localhost:3306/fazenda-vertical
// spring.datasource.username=mysql-soo
// spring.datasource.password=Grupo05@SOO
// spring.datasource.driverClassName=com.mysql.jdbc.Driver
// spring.jpa.show-sql=true
// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
// spring.jpa.properties.hibernate.dialect.storage_engine=innodb
