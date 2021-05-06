import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    String ip;
    String user;
    Date date;
    String event;
    String status;


    public Log(String logString) throws ParseException {
        parseLog(logString);
    }

    private void parseLog(String logSring) throws ParseException {
        String[] splittedLogString = logSring.split("\\t");
        if (splittedLogString.length != 5) {
            throw new RuntimeException();
        }
        else {
            this.ip = splittedLogString[0];
            this.user = splittedLogString[1];
            this.date = new SimpleDateFormat("dd.mm.y HH:mm:ss").parse(splittedLogString[2]);
            this.event = splittedLogString[3];
            this.status = splittedLogString[4];
        }
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String str = ip + "\t" +
                user + "\t" +
                date + "\t" +
                event + "\t" +
                status + "\t";
        return str;
    }
}
