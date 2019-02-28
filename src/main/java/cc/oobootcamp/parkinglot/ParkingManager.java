package cc.oobootcamp.parkinglot;

import java.util.List;

public class ParkingManager extends ParkingBoy {

	private List<ParkingBoy> parkingBoys;
	
	public List<ParkingBoy> getParkingBoys() {
		return parkingBoys;
	}

	public void setParkingBoys(List<ParkingBoy> parkingBoys) {
		this.parkingBoys = parkingBoys;
	}

	public ParkingManager(String ParkingBoyNo) {
		super(ParkingBoyNo);
		// TODO Auto-generated constructor stub
	}

	// 管理ParkingBoy
	public Ticket manageParkingBoyParking(Car car) {
		//管理策略暂无
		return parkingBoys.get(0).assignParkLotAndPacking(car);
	}

}
