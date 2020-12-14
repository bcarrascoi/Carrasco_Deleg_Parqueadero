package ec.ups.edu.proyecto.g1.transaccional.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaccion implements Serializable{

	@Id
	private int id;
	private double monto;
	private int tipoTransaccion;
	private Date fecha;
	private String descripcion;

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

	public int getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
