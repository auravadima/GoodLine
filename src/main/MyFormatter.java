package main;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return String.format("%s: %s\n", DateFormat.getTimeInstance().format(new Date()),record.getMessage());
    }
}