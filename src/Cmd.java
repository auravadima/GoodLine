import org.apache.commons.cli.*;

import java.security.NoSuchAlgorithmException;

public class Cmd {

    private String[] args = null;
    public static Options option = new Options();
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;

    public Cmd() {
        option.addOption("l", "login", true, "Enter login (required)");
        option.addOption("p", "pass", true, "Enter password (required)");
        option.addOption("res", true, "Enter res");
        option.addOption("r", "role", true, "Enter role (required if res argument exists");
        option.addOption("ds", true, "Enter start date");
        option.addOption("de", true, "Enter end date (required if ds argument exists");
        option.addOption("vol", true, "Enter vol (required if ds/de argument exists");
        option.addOption("h", "help", true, "Show help");
    }

    public boolean isAuthentication() {
        if (cmd.hasOption("login") && cmd.hasOption("pass")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuthorization() {
        if (isAuthentication() && cmd.hasOption("res") && cmd.hasOption("role")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAccounting() {
        if (isAuthorization() && cmd.hasOption("ds") && cmd.hasOption("de") && cmd.hasOption("vol")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHelp() {
        if (cmd.hasOption("h")) {
            return true;
        } else {
            return false;
        }
    }


    public DataSet Parse(String[] args) throws ParseException, NoSuchAlgorithmException {
        this.args = args;

        DataSet set = new DataSet();
        cmd = parser.parse(option, args);

        if (isHelp()) {
            help();
            return null;
        }

        if (isAuthentication()) {
            set.setLogin(cmd.getOptionValue("login"));
            set.setPass(cmd.getOptionValue("pass"));
        }

        if (isAuthorization()) {
            set.setRes(cmd.getOptionValue("res"), cmd.getOptionValue("role"));
        }

        if (isAccounting()) {
            set.setInfo(cmd.getOptionValue("ds"), cmd.getOptionValue("de"), cmd.getOptionValue("vol"));
        }
        return set;
    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", option, true);
    }

}
