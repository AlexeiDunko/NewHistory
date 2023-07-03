package com.filesystem;

public abstract class FileSystemObject {
    protected String name;


    public FileSystemObject(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
