package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAAcompliantUser {
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    
    public Physician(Integer id) {
    	super(id);
    }
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	    
    	public boolean assignPin(int pin) {
			int length = String.valueOf(pin).length();
			if (length == 4) {
				return true;
			}
			else {
				this.pin = pin; 
				return false;
			}
    	}
	    
	    
	    public boolean accessAuthorized(Integer confirmedAuthID) {
	    	if (this.id == confirmedAuthID) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    
	    
	    
    // TO DO: Setters & Getters
	    public ArrayList<String> getPatientNotes() {
			return patientNotes;
		}

		public void setPatientNotes(ArrayList<String> patientNotes) {
			this.patientNotes = patientNotes;
		}


}
