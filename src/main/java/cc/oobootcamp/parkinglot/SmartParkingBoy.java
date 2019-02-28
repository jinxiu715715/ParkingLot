package cc.oobootcamp.parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
	
	
	
	public SmartParkingBoy(String ParkingBoyNo) {
		super(ParkingBoyNo);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void parkLotSort() {
		//Collections.sort(manageParkingLots);
		
		Collections.sort(ParkingLots, new Comparator<ParkingLot>() {
            public int compare(ParkingLot PreParkingLot, ParkingLot nextParkingLot) {
           	 if(nextParkingLot.getRestSpace() >PreParkingLot.getRestSpace()){
                    return 1;
                }else{
               	 return -1;
                }
           }
        });
	}

}
