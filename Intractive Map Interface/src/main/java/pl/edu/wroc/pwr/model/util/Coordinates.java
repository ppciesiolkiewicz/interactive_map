package pl.edu.wroc.pwr.model.util;

import java.io.Serializable;

/**
 * Created by krzaczek on 25.10.14.
 */
public class Coordinates implements Serializable {
	Double x;
	Double y;

	public Coordinates() {

	}

	public Coordinates(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}
}