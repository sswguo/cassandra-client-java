package com.example.cassandra.client.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.example.cassandra.client.domain.PathMap;

import java.util.ArrayList;
import java.util.List;

public class PathMapRepository
{

    public static final String TABLE_NAME = "pathmap";

    private CqlSession session;

    public PathMapRepository( CqlSession session )
    {
        this.session = session;
    }

    public List<PathMap> selectAll()
    {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);
        final String query = sb.toString();
        ResultSet rs = session.execute( query );

        List<PathMap> pathMaps = new ArrayList<PathMap>();

        for ( Row r : rs) {
            PathMap pathMap = new PathMap();
            pathMap.setFileId( r.getString( "fileId" ) );
            pathMap.setFileName( r.getString( "fileName" ) );
            pathMap.setFileStorage( r.getString( "fileStorage" ) );
            pathMaps.add(pathMap);
        }
        return pathMaps;
    }

}
