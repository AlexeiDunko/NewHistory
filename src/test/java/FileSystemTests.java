import com.filesystem.FileSystem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileSystemTests {
    // Создание файловой системы
    private FileSystem fs = new FileSystem();

    /*
    Один тест
    Создаем структуру -> получаем структуру и сравниваем
     */


    @Test
    public void testPrintStructureShouldReturnWithOneFile() {
        fs.add("folder1/folder2/file1.txt");
        String expectedName = "root/\n"
                + "  folder1/\n"
                + "    file.txt\n";
        assertEquals(expectedName, fs.print());
    }





    @Test
    public void testPrintStructureShouldReturnWithTwoFoldersTwoFiles() {
        fs.add("folder1/folder2/file1.txt");
        fs.add("folder2/file2.txt");
        String expectedName = "root/\n"
                + "  folder2/\n"
                + "    file.txt\n"
                + "  folder1/\n"
                + "    file2.txt\n";
        assertEquals(expectedName, fs.print());
    }


}
