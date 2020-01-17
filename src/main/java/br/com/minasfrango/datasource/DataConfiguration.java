package br.com.minasfrango.datasource;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {

    // @Bean
    // public DataSource dataSource() {
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://mobiledb.mysql.dbaas.com.br/mobiledb");
    // dataSource.setUsername("mobiledb");
    // dataSource.setPassword("let152117");
    // return dataSource;
    // }
    //
    // @Bean
    // public JpaVendorAdapter jpaVendorAdapter() {
    // HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    // adapter.setDatabase(Database.MYSQL);
    // adapter.setShowSql(true);
    // // adapter.setGenerateDdl(true);
    // adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    // adapter.setPrepareConnection(true);
    // return adapter;
    // }
}
