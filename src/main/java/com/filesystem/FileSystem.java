package com.filesystem;


public class FileSystem {
        public Folder root;

        public Object add(String path) {
            String[] parts = path.split("/");
            Folder currentFolder = root;
            for (int i = 0; i < parts.length; i++) {
                String part = parts[i];
                FileSystemObject obj = currentFolder.get(part);
                if (obj == null) {
                    obj = createObject(part, i == parts.length - 1);
                    currentFolder.add(obj);
                } else if (i == parts.length - 1 && obj instanceof Folder) {

                    System.out.println("Unable to create file. " + part + " is a folder.");
                    return null;
                }
                if (obj instanceof Folder) {
                    currentFolder = (Folder) obj;
                }
            }
            return null;
        }

        private FileSystemObject createObject(String name, boolean isFile) {
            if (isFile) {
                String[] parts = name.split("\\.");
                if (parts.length == 1) {
                    System.out.println("Unable to create file. No extension provided for " + name + ".");
                    return null;
                } else {
                    return new File(parts[0], parts[1]);
                }
            } else {
                return new Folder(name);
            }
        }

        public Folder get(String path) {
            String[] parts = path.split("/");
            Folder currentFolder = root;
            for (String part : parts) {
                currentFolder = (Folder) currentFolder.get(part);
                if (currentFolder == null) {
                    return null;
                }
            }
            return currentFolder;
        }
    }

