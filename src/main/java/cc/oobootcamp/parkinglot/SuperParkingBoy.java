package cc.oobootcamp.parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends ParkingBoy {
	
	public SuperParkingBoy(String ParkingBoyNo) {
		super(ParkingBoyNo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parkLotSort() {
		//Collections.sort(manageParkingLots);
		
		Collections.sort(super.ParkingLots, new Comparator<ParkingLot>() {
            public int compare(ParkingLot PreParkingLot, ParkingLot nextParkingLot) {
            	 if(nextParkingLot.getVacancyRate() >PreParkingLot.getVacancyRate()){
                     return 1;
                 }else{
                	 return -1;
                 }
            }
        });
	}

}
