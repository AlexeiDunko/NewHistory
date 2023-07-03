package com.filesystem;

public class FileSystem {
        public Folder root = new Folder("root");

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

    public String print() {
        StringBuilder sb = new StringBuilder();
        printFolder(root, " ", sb);
        return sb.toString();
    }

    private void printFolder(Folder folder, String indent, StringBuilder sb) {
        sb.append(indent).append(folder.getName()).append("/").append("\n");

        for (FileSystemObject item : folder.getContents()) {
            if (item instanceof Folder) {
                printFolder((Folder)item, indent + "  ", sb);
            } else {
                sb.append(indent).append("  ").append(item.getName()).append("\n");
            }
        }
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

