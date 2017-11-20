package main;

import org.apache.commons.cli.*;

class CmdArgsParser {

    private static Options option = new Options();

    CmdArgsParser() {
        option
                .addOption("l", "login", true, "Enter login (required)")
                .addOption("p", "pass", true, "Enter password (required)")
                .addOption("res", true, "Enter res")
                .addOption("r", "role", true, "Enter role (required if res argument exists")
                .addOption("ds", true, "Enter start date")
                .addOption("de", true, "Enter end date (required if ds argument exists")
                .addOption("vol", true, "Enter vol (required if ds/de argument exists")
                .addOption("h", "help", false, "Show help");
    }

    static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", option, true);
    }

    DataSet parse(String[] args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        cmd = parser.parse(option, args);
        DataSet set = new DataSet();

        set.setHelp(cmd.hasOption("h"));
        if (cmd.hasOption("login") && cmd.getOptionValue("login").matches("\\b[\\w]+\\b")) {
            set.setLogin(cmd.getOptionValue("login"));
        } else if(cmd.hasOption("login")){
            set.setLogin("Incorrect");
        }
        if (cmd.hasOption("pass") && cmd.getOptionValue("pass").matches("\\b[\\w]+\\b")) {
            set.setPass(cmd.getOptionValue("pass"));
        } else if(cmd.hasOption("pass")){
            set.setPass("Incorrect");
        }
        if (cmd.hasOption("res") && cmd.getOptionValue("res").matches("\\b[\\w.]+\\b")) {
            set.setRes(cmd.getOptionValue("res"));
        } else if(cmd.hasOption("res")){
            set.setRes("Incorrect");
        }
        if (cmd.hasOption("role") && cmd.getOptionValue("role").matches("\\b[A-Z]{4,7}+\\b")) {
            set.setRole(cmd.getOptionValue("role"));
        } else if(cmd.hasOption("role")){
            set.setRole("Incorrect");
        }
        if (cmd.hasOption("ds") && cmd.getOptionValue("ds").matches("\\b\\d\\d\\d\\d-\\d\\d-\\d\\d\\b")) {
            set.setDs(cmd.getOptionValue("ds"));
        } else if(cmd.hasOption("ds")){
            set.setDs("Incorrect");
        }
        if (cmd.hasOption("de") && cmd.getOptionValue("de").matches("\\b\\d\\d\\d\\d-\\d\\d-\\d\\d\\b")) {
            set.setDe(cmd.getOptionValue("de"));
        } else if(cmd.hasOption("de")){
            set.setDe("Incorrect");
        }
        if (cmd.hasOption("vol") && cmd.getOptionValue("vol").matches("\\b\\d+\\b")) {
            set.setVol(cmd.getOptionValue("vol"));
        } else if(cmd.hasOption("vol")){
            set.setVol("Incorrect");
        }
        return set;
    }
}
