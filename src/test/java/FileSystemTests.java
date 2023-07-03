import com.filesystem.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FileSystemTests {
    // Создание файловой системы
    private FileSystem fs;

    /*
    Один тест
    Создаем структуру -> получаем структуру и сравниваем
     */

    @Test
    public void testPrintStructureShouldReturnWithOneFile() {
        // Добавление нового файла в существующую папку
        fs.add("folder1/folder2/file1.txt");
        String expectedName = """
                root/
                  folder1/
                    file.txt
                """;
        assertEquals(expectedName, fs.print());
    }

    @Test
    public void testPrintStructureShouldReturnWithTwoFiles() {
        // Добавление нового файла в существующую папку
        fs.add("folder1/folder2/file1.txt");
        String expectedName = """
                root/
                  folder1/
                    file.txt
                    file2.txt
                """;
        assertEquals(expectedName, fs.print());
    }

    @Test
    public void testPrintStructureShouldReturnWithTwoFoldersTwoFiles() {
        // Добавление нового файла в существующую папку
        fs.add("folder1/folder2/file1.txt");
        String expectedName = """
                root/
                  folder2/
                    file.txt
                  folder1/
                    file2.txt
                """;
        assertEquals(expectedName, fs.print());
    }
}
