package com.github.origin;

import static java.io.File.separator;
import static java.util.regex.Pattern.quote;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class JRE {

	public static String jre() {
		RuntimeMXBean mxbean = ManagementFactory.getPlatformMXBean(RuntimeMXBean.class);
		String java = mxbean.getBootClassPath().split(quote(separator)+"lib",2)[0]+separator+"bin"+separator+"java";
		return new File(java).exists() ? java : java + "w.exe";
		
	}

}
