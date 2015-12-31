package com.github.origin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {

	static Logger log = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) throws InterruptedException, IOException {
		
		File wait = new File("origin-upgrade.jar");
		long start = System.currentTimeMillis();
		while(System.currentTimeMillis() - start < 2 * 60 * 1000 && !wait.exists()) {
			log.info("V3 : Waiting for "+wait);
			Thread.sleep(2000);
		}
		if(wait.exists()){
			System.out.println("found");
			new ProcessBuilder(JRE.jre(), "-jar", "relaunch.jar",
					"origin.jar",
					"origin-upgrade.jar",
					"log.txt",
					JRE.jre(),
					"-jar",
					"origin.jar"
					)
			  .redirectErrorStream(true)
			  .redirectOutput(new File("relaunch.txt"))
			  .start();
		}
	}

}
