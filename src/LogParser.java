import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    Path logDir;
    List<Log> logList;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    public void parse() throws IOException {
        File[] allFiles = logDir.toFile().listFiles();
        Pattern pattern = Pattern.compile(".+\\.log$");

        for (File f: allFiles) {
            Matcher matcher = pattern.matcher(f.getName());
            if (matcher.find()) {
                parseLogFile(f);
            }
        }
    }

    public void parseLogFile(File logFile) throws IOException {
        List<String> logString = Files.readAllLines(logFile.toPath());
        this.logList = new ArrayList<>();
        for (String str:logString) {
            try {
                logList.add(new Log(str));
            }
            catch (Exception e) {
                System.out.println("Wrong log format in: " + str);
            }
        }
    }

    public List<Log> getLogList() {
        return this.logList;
    }
}
