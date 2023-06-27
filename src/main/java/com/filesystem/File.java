package com.filesystem;

public class File extends FileSystemObject{
    private String extension;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
    }

    public String getExtension(){
        return extension;
    }
}
