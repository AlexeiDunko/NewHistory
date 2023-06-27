import com.filesystem.FileSystem;
import com.filesystem.Folder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTests {
    // Создание файловой системы
    private FileSystem fs;

    @Before
    public void init() {
        // Создание файловой системы
        fs = new FileSystem();
    }

    @Test
    public void addNewFileToFolder() {
        // Добавление нового файла в существующую папку
        fs.add("folder1/file1.txt");
        String expectedName = "file1.txt";
        assertEquals(expectedName, fs.get("folder1").get(expectedName).getName());
    }

    @Test
    public void addNewFolderToFolder() {
        // Добавление новой папки в существующую папку
        fs.add("folder1/folder2");
        String expectedName = "folder2";
        assertEquals(expectedName, fs.get("folder1").get(expectedName).getName());
    }

    @Test
    public void addNewFileToNewFolder() {
        // Добавление нового файла в несуществующую папку (должна создаться вся иерархия)
        fs.add("folder1/folder2/file1.txt");
        String expectedName = "file1.txt";
        assertEquals(expectedName, fs.get("folder1/folder2").get(expectedName).getName());

        fs.add("folder3/newFile.txt");
        expectedName = "newFile.txt";
        assertEquals(expectedName, fs.get("folder3").get(expectedName).getName());
    }

    @Test
    public void addFileWithSameNameAsExistingFile() {
        // Добавление нового файла с тем же именем, что и у существующего файла (должен вернуть null)
        fs.add("folder4/file1.txt");
        assertNull(fs.add("folder4/file1.txt"));
    }

    @Test
    public void addFileWithSameNameAsExistingFolder() {
        // Создание необходимых объектов
        Folder folder = new Folder("folder");
        fs.root = folder;

        Folder existingFolder = new Folder("folder1");
        folder.add(existingFolder);

        // Добавление файла с тем же именем, что и у существующей папки
        assertNull(fs.add("folder1"));

        // Проверка, что папка не была заменена на файл
        String expectedName = "folder1";
        assertTrue(fs.get("folder").get(expectedName) instanceof Folder);
    }
}
