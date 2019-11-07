package com.example.cassandra.client.domain;

public class PathMap
{

    private String fileId;
    private String fileName;
    private String fileStorage;

    public String getFileId()
    {
        return fileId;
    }

    public void setFileId( String fileId )
    {
        this.fileId = fileId;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName( String fileName )
    {
        this.fileName = fileName;
    }

    public String getFileStorage()
    {
        return fileStorage;
    }

    public void setFileStorage( String fileStorage )
    {
        this.fileStorage = fileStorage;
    }
}
