package cc.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingDirector extends ParkingBoy {
	
	private List<ParkingBoy> parkingBoys;

	public List<ParkingBoy> getParkingBoys() {
		return parkingBoys;
	}

	public void setParkingBoys(List<ParkingBoy> parkingBoys) {
		this.parkingBoys = parkingBoys;
	}

	public ParkingDirector(String ParkingBoyNo) {
		super(ParkingBoyNo);
		// TODO Auto-generated constructor stub
	}
	
	public List displayReport() {
		
		List displayReport = new ArrayList();
		
		for (int i = 0; i < super.ParkingLots.size(); i++) {
			displayReport.addAll(ParkingLots.get(i).accoutParkingLot());
		}
		return displayReport;
		
	}

}
