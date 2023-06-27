package com.filesystem;

import java.util.ArrayList;
import java.util.List;

    public class Folder extends FileSystemObject{
        private List<FileSystemObject> contents;

        public Folder(String name) {
            super(name);
            contents = new ArrayList<>();
        }

        public void add(FileSystemObject obj) {
            contents.add(obj);
        }

        public List<FileSystemObject> getContents() {
            return contents;
        }

        public FileSystemObject get(String name) {
            for (FileSystemObject obj : contents) {
                if (obj.getName().equals(name)) {
                    return obj;
                }
            }
            return null;
        }
    }

