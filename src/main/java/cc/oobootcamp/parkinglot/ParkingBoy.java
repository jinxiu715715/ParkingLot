package cc.oobootcamp.parkinglot;

import java.util.Collections;
import java.util.List;

public class ParkingBoy {

	protected String ParkingBoyNo;
	protected List<ParkingLot> ParkingLots;

	public ParkingBoy(String ParkingBoyNo) {
		this.ParkingBoyNo = ParkingBoyNo;
	}

	public void setParkingLots(List<ParkingLot> parkingLots) {
		ParkingLots = parkingLots;
	}

	// private List<ParkingLot> manageParkingLots;

	public String getParkingBoyNo() {
		return ParkingBoyNo;
	}

	// 停车场排序
	public void parkLotSort() {
		// Collections.sort(manageParkingLots);

	}

	// 分配停车场,票和停车场关系
	public Ticket assignParkLotAndPacking(Car car) {
		// Collections.sort(manageParkingLots);
		parkLotSort();
		for (int i = 0; i < ParkingLots.size(); i++) {
			if (ParkingLots.get(i).getRestSpace() > 0) {
				return ParkingLots.get(i).parking(car, this);
			}
		}
		// 所用停车场都满了
		throw new ParkingLotFullException();
	}

	public Car extractCar(Ticket ticket) {

		for (int i = 0; i < ParkingLots.size(); i++) {
			if (ParkingLots.get(i).getParkingLotNo().equals(ticket.getParkingLotNo())) {
				return ParkingLots.get(i).extractCar(ticket);
			}
		}
		throw new ExtractCarFailedException();
	}

	/*
	 * //根据车票，从停车场取车 public ParkingLot getParkLotByTicket(Ticket ticket) {
	 * //Collections.sort(manageParkingLots);
	 * 
	 * return manageParkingLots.get(0); }
	 */

}
