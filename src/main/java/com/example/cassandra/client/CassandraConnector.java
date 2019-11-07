package com.example.cassandra.client;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.internal.core.auth.PlainTextAuthProvider;

import java.net.InetSocketAddress;

public class CassandraConnector
{

    private CqlSession session;

    public void connect(String node, Integer port, String dataCenter) {
        // https://datastax-oss.atlassian.net/browse/JAVA-2236
        /*DriverConfigLoader loader =
                        DriverConfigLoader.programmaticBuilder()
                                          .withClass( DefaultDriverOption.AUTH_PROVIDER_CLASS, PlainTextAuthProvider.class)
                                          .withString(DefaultDriverOption.AUTH_PROVIDER_USER_NAME, "cassandra")
                                          .withString(DefaultDriverOption.AUTH_PROVIDER_PASSWORD, "cassandra")
                                          .build();*/

        CqlSessionBuilder builder = CqlSession.builder();
        builder.addContactPoint(new InetSocketAddress( node, port));
        builder.withLocalDatacenter(dataCenter);
        builder.withAuthCredentials( "cassandra", "cassandra" );

        session = builder.build();

    }

    public CqlSession getSession() {
        return this.session;
    }

    public void close() {
        session.close();
    }

}
