package com.example.cassandra.client;

import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.cassandra.client.domain.PathMap;
import com.example.cassandra.client.repository.KeyspaceRepository;
import com.example.cassandra.client.repository.PathMapRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Let's try to connect cassandra:");

        CassandraConnector connector = new CassandraConnector();
        connector.connect("cassandra-cluster.nos-automation.svc", 9042, "dc1");
        CqlSession session = connector.getSession();

        KeyspaceRepository keys = new KeyspaceRepository( session );
        keys.useKeyspace( "k1" );

        PathMapRepository pathMapRepo = new PathMapRepository( session );
        List<PathMap> pathMapList = pathMapRepo.selectAll();

        for ( PathMap pathMap : pathMapList )
        {
            System.out.println( pathMap.getFileId() + "|" + pathMap.getFileName() + "|" + pathMap.getFileStorage() );
        }

        connector.close();
    }

}
