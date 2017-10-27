package main;

import org.apache.commons.cli.*;

class CmdArgsParser {

    private static Options option = new Options();

    CmdArgsParser() {
        option.addOption("l","login", true, "Enter login (required)");
        option.addOption("p","pass",  true, "Enter password (required)");
        option.addOption("res", true, "Enter res");
        option.addOption("r", "role", true, "Enter role (required if res argument exists");
        option.addOption("ds", true, "Enter start date");
        option.addOption("de", true, "Enter end date (required if ds argument exists");
        option.addOption("vol", true, "Enter vol (required if ds/de argument exists");
        option.addOption("h", "help", true, "Show help");
    }

    static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", option, true);
    }

    DataSet parse(String[] args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        DataSet set = new DataSet();
        cmd = parser.parse(option, args);
        if (cmd.hasOption("h")) {
            help();
            return null;
        }
        set.setLogin(cmd.getOptionValue("login"));
        set.setPass(cmd.getOptionValue("pass"));
        set.setRes(cmd.getOptionValue("res"));
        if(cmd.hasOption("role")){
            set.setRole(cmd.getOptionValue("role"));
        }
        set.setDs(cmd.getOptionValue("ds"));
        set.setDe(cmd.getOptionValue("de"));
        set.setVol(cmd.getOptionValue("vol"));
        return set;
    }
}
