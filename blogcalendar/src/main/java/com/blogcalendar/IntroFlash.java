package com.blogcalendar;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.blogcalendar.util.Constant;

public class IntroFlash implements Runnable {

    @Override
    public void run() {
        App.LOGGER.info(Constant.ANSI_BLUE + "*************************************************************************************************************************" );
        App.LOGGER.info("*************************************************************************************************************************");
        App.LOGGER.info("______ _ _                           _____ _     _                             _        _    ___          ");
        App.LOGGER.info("| ___ (_) |                         /  ___| |   (_)                           | |      | |  / _ \\         ");
        App.LOGGER.info("| |_/ /_| |_ ___   _ __ ___  _   _  \\ \'--.| |__  _ _ __   ___   _ __ ___   ___| |_ __ _| | / /_\\ \\___ ___");
        App.LOGGER.info("| ___ \\ | __/ _ \\ | '_ \' _ \\| | | |  \'--. \\ \'_ \\| | \'_ \\ / _ \\ | \'_ \' _ \\ / _ \\ __/ _\' | | |  _  / __/ __|");
        App.LOGGER.info("| |_/ / | ||  __/ | | | | | | |_| | /\\__/ / | | | | | | |  __/ | | | | | |  __/ || (_| | | | | | \\__ \\__ \\");
        App.LOGGER.info("\\____/|_|\\__\\___| |_| |_| |_|\\__, | \\____/|_| |_|_|_| |_|\\___| |_| |_| |_|\\___|\\__\\__,_|_| \\_| |_/___/___/");
        App.LOGGER.info("                              __/ |                                                                       ");
        App.LOGGER.info(Constant.ANSI_YELLOW +"                             |___/                                                                        ");
        App.LOGGER.info("     ( )	         _____        _         _____          _           _    _____      _            _       _ ");
        App.LOGGER.info("      H		|  __ \\      | |       |  __ \\        (_)         | |  / ____|    | |          | |     | |            ");
        App.LOGGER.info("      H		| |  | | __ _| |_ ___  | |__) |__ _ __ _  ___   __| | | |     __ _| | ___ _   _| | __ _| |_ ___  _ __ ");
        App.LOGGER.info("     _H_ 	| |  | |/ _` | __/ _ \\ |  ___/ _ \\ '__| |/ _ \\ / _` | | |    / _` | |/ __| | | | |/ _` | __/ _ \\| '__|");
        App.LOGGER.info("  .-'-.-'-.	| |__| | (_| | ||  __/ | |  |  __/ |  | | (_) | (_| | | |___| (_| | | (__| |_| | | (_| | || (_) | | ");
        App.LOGGER.info("/          \\	|_____/ \\__,_|\\__\\___| |_|   \\___|_|  |_|\\___/ \\__,_|  \\_____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|");
        App.LOGGER.info("|           |");
        App.LOGGER.info("|   .-------'._");
        App.LOGGER.info("|  / /  '.' '. \\");
        App.LOGGER.info("|  \\ \\ @   @ / / ");
        App.LOGGER.info("|   '---------' ");       
        App.LOGGER.info("|    _______|  ");
        App.LOGGER.info("|  .'-+-+-+|  ");
        App.LOGGER.info("|  '.-+-+-+|   ");      
        App.LOGGER.info("|    \"\"\"\"\"\"|\\");
        App.LOGGER.info("'-.__   __.-'");
        App.LOGGER.info("     \"\"\" " + Constant.ANSI_RESET);
        App.LOGGER.info("*************************************************************************************************************************");
        App.LOGGER.info(" OLEXANDER KOLODIAZHNY @ 2015");
        App.LOGGER.info("*************************************************************************************************************************");
        App.LOGGER.info("");
        App.LOGGER.warn("----> Please Enter to continue <-----");
        waitForInput();
    }

    private static void waitForInput() {
        Scanner rs = new Scanner(System.in);
        int i;

        while(true) {
            i = (rs.nextLine().isEmpty()) ? 1 : 0;
            if (i == 1) {
                try {   
                    //Clear console
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    Runtime.getRuntime().exec("clear");
                    break;
                } catch (IOException e) {
                    App.LOGGER.error(e);
                }         
            }
        }
    }

}
