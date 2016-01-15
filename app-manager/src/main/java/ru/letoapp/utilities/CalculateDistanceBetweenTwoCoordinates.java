package ru.letoapp.utilities;

public class CalculateDistanceBetweenTwoCoordinates {

	public double calculateDistanceBetweenTwoPoints (double lat1, double lon1, double lat2, double lon2) {
		double R = 111.2;		
		double distance = R*Math.sqrt(Math.pow((lat1-lat2), 2) + Math.pow((lon1-lon2)*Math.cos(Math.PI*((lat1 + lat2)/2)/180), 2));
		return distance;
	}


}
