package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes = new ArrayList<>();  // Initialize the list

    // Constructor
	public Physician(int id) {
		this.id = id;
	}
	
	// Implementing HIPAACompliantUser methods
	@Override
	public boolean assignPin(int pin) {
	    if (String.valueOf(pin).length() == 4) {
	        this.pin = pin;
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
	    return this.id.equals(confirmedAuthID);
	}
	
	// Existing method
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // Setters & Getters
    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}
