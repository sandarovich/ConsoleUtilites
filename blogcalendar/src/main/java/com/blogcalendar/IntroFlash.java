package com.blogcalendar;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class IntroFlash implements Runnable {
    static final Logger LOGGER = Logger.getLogger(IntroFlash.class);
	@Override
	public void run() {
		LOGGER.info("*************************************************************************************************************************");
		LOGGER.info("*************************************************************************************************************************");
		System.out.println("______ _ _                           _____ _     _                             _        _    ___          ");
		System.out.println("| ___ (_) |                         /  ___| |   (_)                           | |      | |  / _ \\         ");
		System.out.println("| |_/ /_| |_ ___   _ __ ___  _   _  \\ \'--.| |__  _ _ __   ___   _ __ ___   ___| |_ __ _| | / /_\\ \\___ ___");
		System.out.println("| ___ \\ | __/ _ \\ | '_ \' _ \\| | | |  \'--. \\ \'_ \\| | \'_ \\ / _ \\ | \'_ \' _ \\ / _ \\ __/ _\' | | |  _  / __/ __|");
		System.out.println("| |_/ / | ||  __/ | | | | | | |_| | /\\__/ / | | | | | | |  __/ | | | | | |  __/ || (_| | | | | | \\__ \\__ \\");
		System.out.println("\\____/|_|\\__\\___| |_| |_| |_|\\__, | \\____/|_| |_|_|_| |_|\\___| |_| |_| |_|\\___|\\__\\__,_|_| \\_| |_/___/___/");
		System.out.println("                              __/ |                                                                       ");
		System.out.println("                             |___/                                                                        ");
		System.out.println("     ( )	 _____        _         _____          _           _    _____      _            _       _ ");
		System.out.println("      H		|  __ \\      | |       |  __ \\        (_)         | |  / ____|    | |          | |     | |            ");
		System.out.println("      H		| |  | | __ _| |_ ___  | |__) |__ _ __ _  ___   __| | | |     __ _| | ___ _   _| | __ _| |_ ___  _ __ ");
		System.out.println("     _H_ 	| |  | |/ _` | __/ _ \\ |  ___/ _ \\ '__| |/ _ \\ / _` | | |    / _` | |/ __| | | | |/ _` | __/ _ \\| '__|");
		System.out.println("  .-'-.-'-.	| |__| | (_| | ||  __/ | |  |  __/ |  | | (_) | (_| | | |___| (_| | | (__| |_| | | (_| | || (_) | | ");
		System.out.println("/          \\	|_____/ \\__,_|\\__\\___| |_|   \\___|_|  |_|\\___/ \\__,_|  \\_____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|");
		System.out.println("|           |");
		System.out.println("|   .-------'._");
		System.out.println("|  / /  '.' '. \\");
		System.out.println("|  \\ \\ @   @ / / ");
		System.out.println("|   '---------' ");       
		System.out.println("|    _______|  ");
		System.out.println("|  .'-+-+-+|  ");
		System.out.println("|  '.-+-+-+|   ");      
		System.out.println("|    \"\"\"\"\"\"|\\");
		System.out.println("'-.__   __.-'");
		System.out.println("     \"\"\" ");
		System.out.println("*************************************************************************************************************************");
		System.out.println(" OLEXANDER KOLODIAZHNY @ 2015");
		System.out.println("*************************************************************************************************************************");
		
		Scanner rs = new Scanner(System.in);
		int i;
		
		while(true) {
			i = (rs.nextLine().isEmpty()) ? 1 : 0;
			if (i == 1) {
				try {
					Runtime.getRuntime().exec("clear");
					break;
				} catch (IOException e) {
					
					e.printStackTrace();
				}         
			}
		}
	}

}
