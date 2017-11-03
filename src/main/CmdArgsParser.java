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
                .addOption("h", "help", true, "Show help");
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
        set.setLogin(cmd.getOptionValue("login"));
        set.setPass(cmd.getOptionValue("pass"));
        set.setRes(cmd.getOptionValue("res"));
        set.setRole(cmd.getOptionValue("role"));
        set.setDs(cmd.getOptionValue("ds"));
        set.setDe(cmd.getOptionValue("de"));
        set.setVol(cmd.getOptionValue("vol"));
        return set;
    }
}
