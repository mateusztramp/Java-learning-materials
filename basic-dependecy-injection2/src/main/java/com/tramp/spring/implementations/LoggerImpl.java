package com.tramp.spring.implementations;

import java.util.Date;

import com.tramp.spring.Logger;

public class LoggerImpl implements Logger {

	public void log(String message) {
	System.out.println(new Date()+": " + message);
	}

}
