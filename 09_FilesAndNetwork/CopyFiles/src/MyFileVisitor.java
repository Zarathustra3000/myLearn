import java.io.IOException;
import java.nio.file.*;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private Path srcFolder, dstFolder;

    public MyFileVisitor(Path srcFolder, Path dstFolder) {
        this.srcFolder = srcFolder;
        this.dstFolder = dstFolder;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        Path newDer = dstFolder.resolve(srcFolder.relativize(path));
        try {
            Files.copy(path, newDer, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        Path newDer = dstFolder.resolve(srcFolder.relativize(path));
        try {
            Files.copy(path, newDer, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

}
