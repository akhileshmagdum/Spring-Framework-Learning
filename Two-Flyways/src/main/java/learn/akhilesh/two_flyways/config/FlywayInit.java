package learn.akhilesh.two_flyways.config;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayInit {

    @Autowired
    private DataSource primaryDb;

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDb;

    @PostConstruct
    public void flyway() {
        Flyway flywayP = Flyway.configure().dataSource(primaryDb).locations("db/primary").load();
        Flyway flywayS = Flyway.configure().dataSource(secondaryDb).locations("db/second").load();

        flywayP.migrate();
        flywayS.migrate();
    }
}
