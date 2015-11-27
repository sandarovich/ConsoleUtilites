package com.blogcalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.blogcalendar.languagestrategy.EnglishLanguageStrategy;
import com.blogcalendar.languagestrategy.LanguageStrategy;
import com.blogcalendar.languagestrategy.RussianLanguageStrategy;
import com.blogcalendar.languagestrategy.UkraineLanguageStrategy;
import com.blogcalendar.util.Constant;

public class UserIO {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String rl; 
    public static SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static LanguageStrategy readlang() throws IOException {
        App.LOGGER.info("*****************************************");
        App.LOGGER.info("********* CHOOSE LANGUAGE ***************");
        App.LOGGER.info("1 - English");
        App.LOGGER.info("2 - Українська"); 
        App.LOGGER.info("3 - Русский");
        App.LOGGER.info("");
        
        while (true) {
            rl = reader.readLine();

            if (rl.matches("\\d")) {
                int n = Integer.parseInt(rl);
                if (n == 1) {
                    return (new EnglishLanguageStrategy());
                } else if (n == 2) {
                    return (new UkraineLanguageStrategy());
                } else if (n== 3) {
                    return (new RussianLanguageStrategy());
                } else {
                    App.LOGGER.warn("Please enter 1,2,3");
                }
            } 
        }

    }
    public static Date readDate() throws IOException {
        App.LOGGER.info("*****************************************");
        App.LOGGER.info("********* Enter Date ***************");
        App.LOGGER.info("mm.dd.yyyy hh:mm:ss ");
        App.LOGGER.info("*****************************************");
        App.LOGGER.info("");
        // Setting date format according  pattern 

        Date entryDate = null;

        while(true) {
            rl = reader.readLine();
            try {
                Date now = new Date();
                entryDate = df.parse(rl);
                if (entryDate.before(now)) {
                    return entryDate;
                } else{
                    App.LOGGER.warn(Constant.ANSI_RED 
                            + "--> Sorry.Input Date is greater then now. Please try again."
                            + Constant.ANSI_RESET);
                    continue;
                }

            } catch(ParseException e) {
                App.LOGGER.warn(Constant.ANSI_RED +
                        "Please check input format and try again " + e.getMessage()
                        + Constant.ANSI_RESET);
                continue;
            }
        }
    }


}
