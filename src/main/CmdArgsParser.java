package main;

import org.apache.commons.cli.*;

class CmdArgsParser {

    private static Options option = new Options();
    private CommandLineParser parser = new DefaultParser();
    private CommandLine cmd = null;

    CmdArgsParser() {
        option.addOption("l", "login", true, "Enter login (required)");
        option.addOption("p", "pass", true, "Enter password (required)");
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

    private boolean hasAuthenticationArgs() {
        return (cmd.hasOption("l") && cmd.hasOption("p"));
    }

    private boolean hasAuthorizationArgs() {
        return (hasAuthenticationArgs() && cmd.hasOption("res") && cmd.hasOption("role"));
    }

    private boolean hasAccountingArgs() {
        return (hasAuthorizationArgs() && cmd.hasOption("ds") & cmd.hasOption("de") & cmd.hasOption("vol"));
    }

    boolean isHelp() {
        return (cmd.hasOption("h"));
    }

    DataSet Parse(String[] args) throws Exception {
        DataSet set = new DataSet();
        cmd = parser.parse(option, args);

        if (!isHelp()) {
            if (hasAuthenticationArgs()) {
                set.setLogin(cmd.getOptionValue("login"));
                set.setPass(cmd.getOptionValue("pass"));
            }
            if (hasAuthorizationArgs()) {
                set.setRes(cmd.getOptionValue("res"), cmd.getOptionValue("role"));
            }
            if (hasAccountingArgs()) {
                set.setInfo(cmd.getOptionValue("ds"), cmd.getOptionValue("de"), cmd.getOptionValue("vol"));
            }
            return set;
        } else {
            help();
            return null;
        }
    }
}
