package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Session {
	ArrayList<Hospital> sessions;

	public ArrayList<Hospital> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Hospital> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		String value="";
		sessions.forEach( h -> System.out.println("[hospital=" + h.toString() + "]") );
		return value;
	}
	
}
