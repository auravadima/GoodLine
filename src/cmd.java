import org.apache.commons.cli.*;

import java.text.SimpleDateFormat;

public class cmd {

    private String[] args = null;
    public static Options option = new Options();
    CommandLineParser parser = new DefaultParser();


    public String[] Parse(String[] args) throws ParseException {
        this.args = args;
        option.addOption("l", "login", true, "Enter login (required)");
        option.addOption("p","pass",true, "Enter password (required)");
        option.addOption("res", true, "Enter res");
        option.addOption("r","role",true, "Enter role (required if res argument exists");
        option.addOption("ds", true, "Enter start date");
        option.addOption("de",true, "Enter end date (required if ds argument exists");
        option.addOption("vol",true, "Enter vol (required if ds/de argument exists");
        option.addOption("h","help",true,"Show help");

        String[] returnArguments = new String[7];
        CommandLine cmd = null;
        boolean logPass = false;
        boolean resRole = false;
        try {
            cmd = parser.parse(option, args);

            if (cmd.hasOption("h")) {
                help();
                System.exit(-1);
                return null;
            }

            if (cmd.hasOption("login") && cmd.hasOption("pass")) {
                returnArguments[0] = cmd.getOptionValue("login");
                returnArguments[1] = cmd.getOptionValue("pass");
                logPass = true;
            }

            if (logPass && cmd.hasOption("res") && cmd.hasOption("role")) {
                returnArguments[2] = cmd.getOptionValue("res");
                returnArguments[3] = cmd.getOptionValue("role");
                resRole = true;
            }
            else {
                returnArguments[2] = "";
                returnArguments[3] = "";
            }

            if(resRole && cmd.hasOption("ds") && cmd.hasOption("de") && cmd.hasOption("vol")) {
                returnArguments[4] = cmd.getOptionValue("ds");
                returnArguments[5] = cmd.getOptionValue("de");
                returnArguments[6] = cmd.getOptionValue("vol");
            }
            else{
                returnArguments[4] = "";
                returnArguments[5] = "";
                returnArguments[6] = "";
            }
        }
        catch (ParseException e) {

        }
        return returnArguments;
    }

    public static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", option, true);
    }

}
