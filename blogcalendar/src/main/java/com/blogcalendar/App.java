package com.blogcalendar;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.blogcalendar.languagestrategy.*;

/**
 * @author Olexander Kolodiazhny 2015
 * Final project of GoJavaB4 program. :
 * 1. Descriptive date length calculator.
 * 
 * App is console and re-runable. Added special text effects for more fun.
 *
 */
public class App {

    public static final Logger LOGGER = Logger.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) throws ParseException, IOException {

        LOGGER.info("Starting...");
        new IntroFlash().run();
        
        boolean exit = false;
        while(!exit) {
            App.run();
            LOGGER.info("To EXIT press x + Enter, AnyKey + Enter to continue");
            exit = new Scanner(System.in).nextLine().matches("x")? true: false;
        }
        LOGGER.info("Good Bye");
    }


    public static void run() throws IOException  {

        LanguageStrategy strategy = UserIO.readlang();

        Date entryDate= UserIO.readDate();
        Date now = new Date();

        LOGGER.info("In: " +  UserIO.df.format(entryDate));
        LOGGER.info("Now: " + UserIO.df.format(now));

        DescriptiveDateLength ddl = new DescriptiveDateLength(entryDate);
        ddl.setStrategy(strategy);
        App.LOGGER.info("*****************************************");
        LOGGER.info("Out: " + ddl.getDescriptiveDateLength());
        App.LOGGER.info("*****************************************");

    }

}