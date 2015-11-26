package com.blogcalendar;

import org.apache.log4j.Logger;

/**
 * @author Olexander Kolodiazhny 2015
 * Final project of GoJavaB4 program. :
 * 1. Descriptive date length calculator.
 * 
 * App is console and re-runable. Added special text effects for more fun.
 *
 */
public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class);
    
    private App() {
    }

    public static void main(String[] args) {
        
        LOGGER.info("Starting...");
        new IntroFlash().run();
        
        LOGGER.info("Bye");
    }
}