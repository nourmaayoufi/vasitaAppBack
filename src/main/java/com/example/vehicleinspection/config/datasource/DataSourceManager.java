package com.example.vehicleinspection.config.datasource;

import com.example.vehicleinspection.model.CentreCVT;
import com.example.vehicleinspection.repository.CentreCVTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;



@Service
public class DataSourceManager {
    private final DynamicRoutingDataSource routingDataSource;
    private final CentreCVTRepository centreRepo;

    @Autowired
    public DataSourceManager(DynamicRoutingDataSource routingDataSource,
                             CentreCVTRepository centreRepo) {
        this.routingDataSource = routingDataSource;
        this.centreRepo = centreRepo;
    }
    public void ensureDataSource(String centreId) {
        if (centreId == null) return;
        String current = RoutingDataSourceContext.getDataSource();
        if (centreId.equals(current)) return;
        if (!routingDataSource.containsDataSource(centreId)) {
            CentreCVT centre = centreRepo.findById(Integer.valueOf(centreId))
                    .orElseThrow(() -> new IllegalArgumentException("Centre not found: " + centreId));
            // Construct JDBC URL from machine field
            String url = String.format("%s", centre.getMachine());
            System.out.println("Data source info : "+centre.getIdCentre()+centre.getMachine()+centre.getUsername()+centre.getPassword());

            DataSource ds = DataSourceBuilder.create()
                    .url(url)
                    .username(centre.getUsername())
                    .password(centre.getPassword())
                    .driverClassName("oracle.jdbc.OracleDriver")
                    .build();

            routingDataSource.addDataSource(centreId, ds);
        }
        RoutingDataSourceContext.setDataSource(centreId);
    }
}