package ec.ups.edu.proyecto.g1.transaccional.modelo;

import java.io.Serializable;
import java.util.Date;

public class Poliza implements Serializable {

	private int id;
	private double monto;
	private Date fechaInicio;
	private Date fechaFin;
	private int tasaInteres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(int tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

}
