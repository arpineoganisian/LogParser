
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("1 argument needed");
        }

        if (!(Files.isDirectory(Paths.get(args[0])))) {
            System.out.println("There is no such directory: " + Paths.get(args[0]).toString());
            return;
        }

        LogParser logParser = new LogParser(Paths.get(args[0]));
        logParser.parse();
        List<Log> logList = logParser.getLogList();
        Pattern pattern = Pattern.compile("^(SOLVE_TASK|DONE_TASK).+");
        for (Log l:logList) {
            Matcher matcher = pattern.matcher(l.getEvent());
            if (matcher.find()) {

            }
        }




    }
}
