package com.filesystem;

import com.filesystem.File;
import com.filesystem.FileSystemObject;

public class FolderOperations{

    public static void printDirectory(Folder folder, String indentation) {
        System.out.println(indentation + folder.getName() + "/");
        for (FileSystemObject obj : folder.getContents()) {
            if (obj instanceof Folder) {
                printDirectory((Folder) obj, indentation + "  ");
            } else if (obj instanceof File) {
                System.out.println(indentation + "  " + obj.getName() + "." + ((File) obj).getExtension());
            }
        }
    }
}
