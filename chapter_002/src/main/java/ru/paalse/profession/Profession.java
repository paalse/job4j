package ru.paalse.profession;

public class Profession {
	private String name;
	private String profession;

	public Profession() {
	}

	public Profession(String name, String profession) {
		this.name = name;
		this.profession = profession;
	}

	public String getName() {
		return this.name;
	}

	public String getProf() {
		return this.profession;
	}
}