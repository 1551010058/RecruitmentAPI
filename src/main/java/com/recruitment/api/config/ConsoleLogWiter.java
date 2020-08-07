package com.recruitment.api.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogWiter implements ILogWriter {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void error(String error, String detail) {
		if (detail != null) {
			System.err.println(String.format("[ERROR] %s: [%s] -> %s", df.format(new Date()), error, detail));
		} else {
			System.err.println(String.format("[ERROR] %s: %s", df.format(new Date()), error));
		}
	}

	@Override
	public void warn(String warn) {
		System.err.println(String.format("[WARN] %s: %s", df.format(new Date()), warn));
	}

	@Override
	public void info(String info) {
		System.out.println(String.format("[INFO] %s: %s", df.format(new Date()), info));
	}

}
