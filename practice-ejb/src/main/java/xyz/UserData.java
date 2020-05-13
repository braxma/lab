package xyz;

import javax.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

@SessionScoped
public class UserData implements Serializable {

    public void append(final String id, final String data) throws IOException {
        try {
            Files.write(Paths.get(id), (data + "\n").getBytes(), new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND});
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public List<String> read(final String id) throws IOException {
        Path pathToFile = Paths.get(id);
        if(Files.isReadable(pathToFile)) {
            return Files.readAllLines(pathToFile);
        }
        return Collections.emptyList();
    }

}
