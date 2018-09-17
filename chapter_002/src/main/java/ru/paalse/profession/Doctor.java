package ru.paalse.profession;

public class Doctor extends Profession {

	public Doctor(String name) {
		super(name, "Doctor"); 
	}

	public Diagnose heal(Patient patient) {
		return patient.getDiagnose();
	}
}