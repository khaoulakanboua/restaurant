package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.security.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Resto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private double langitude;
	private double latitude;
	private String rank;
	private String h_Open;
	private String h_Close;
	private String week;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@OneToMany(mappedBy = "resto")
	private List<Photo> photo;
	@ManyToOne
	private Zone zone;
	
	@ManyToOne
	private Serie serie;
	@ManyToMany
	@JoinTable(name = "specialite_resto",
	joinColumns = {@JoinColumn(name = "resto_id" )},
    inverseJoinColumns= { @JoinColumn(name = "specialite_id" )})
	private List<Specialite> specialite;
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Serie getSerie() {
		return serie;
	}
	public List<Specialite> getSpecialite() {
		return specialite;
	}
	public void setSpecialite(List<Specialite> specialite) {
		this.specialite = specialite;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public double getLangitude() {
		return langitude;
	}
	public void setLangitude(double langitude) {
		this.langitude = langitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}	
	public String getH_Open() {
		return h_Open;
	}
	public void setH_Open(String h_Open) {
		this.h_Open = h_Open;
	}
	public String getH_Close() {
		return h_Close;
	}
	public void setH_Close(String h_Close) {
		this.h_Close = h_Close;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
}
