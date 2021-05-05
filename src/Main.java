
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("1 argument needed");
        }

        if (!(Files.isDirectory(Paths.get(args[0])))) {
            System.out.println("There is no such directory: " + Paths.get(args[0]).toString());
            return;
        }
        // Метод get() класса Paths - из переданной строки или URI получает объект типа Path
        LogParser logParser = new LogParser(Paths.get(args[0]));

        //Путь
        System.out.println(logParser.logDir.toString());


    }
}
