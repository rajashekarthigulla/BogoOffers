package com.example.demo;

public class CustomException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2668877196933970724L;

	public CustomException(String message) {
        super(message);
    }
}
