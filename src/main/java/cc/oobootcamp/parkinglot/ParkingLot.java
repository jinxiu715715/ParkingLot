package cc.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ParkingLot {
	

	private int sumSpcae;
	private int restSpace;
	private String parkingLotNo;
	private Map<Ticket,Car> parkedCars = new HashMap();
	
	
	public String getParkingLotNo() {
		return parkingLotNo;
	}



	public void setParkingLotNo(String parkingLotNo) {
		this.parkingLotNo = parkingLotNo;
	}

	
	
	public ParkingLot(int restSpace) {
		this.restSpace = restSpace; 
	}
	
	public ParkingLot(int restSpace, int sumSpcae) {
		this.restSpace = restSpace; 
		this.sumSpcae = sumSpcae;
	}
	
	public ParkingLot(int restSpace, String parkingLotNo) {
		this.restSpace = restSpace; 
		this.parkingLotNo = parkingLotNo;
	}
	
	public ParkingLot(int restSpace, int sumSpcae, String parkingLotNo) {
		this.restSpace = restSpace; 
	}

	
	
	public int getSumSpcae() {
		return sumSpcae;
	}

	public void setSumSpcae(int sumSpcae) {
		this.sumSpcae = sumSpcae;
	}
	
	public int getRestSpace() {
		return restSpace;
	}

	public void setRestSpace(int restSpace) {
		this.restSpace = restSpace;
	}
	
	public float getVacancyRate() {
		return (float)restSpace/sumSpcae;
	}

	public Ticket parking(Car car) {
		if (this.restSpace < 1) {
			throw new ParkingLotFullException();
		}
		restSpace --;
		Ticket ticket = new Ticket();
		parkedCars.put(ticket, car);
		return ticket;
	}
	public Ticket parking(Car car, ParkingBoy parkingboy) {
		if (this.restSpace < 1) {
			throw new ParkingLotFullException();
		}
		restSpace --;
		Ticket ticket = new Ticket();
		ticket.setParkingBoyNo(parkingboy.getParkingBoyNo());
		ticket.setParkingLotNo(parkingLotNo);
		parkedCars.put(ticket, car);
		return ticket;
	}

	public Car extractCar(Ticket ticket) {
		if(!parkedCars.containsKey(ticket)) {
			throw new ExtractCarFailedException();
		}
		restSpace ++;
		return parkedCars.remove(ticket);
	}
	
	//停车场报表
	 public List accoutParkingLot(){
		 
		List<Map>  resultArrayList = new ArrayList(); 
		for (Iterator<Entry<Ticket, Car>> items = parkedCars.entrySet().iterator(); items.hasNext();) {
			//parkedCars.get
			Map<String, String> result= new HashMap();
			Entry<Ticket, Car> item = items.next(); 
			result.put("ParkingBoyNo", item.getKey().getParkingBoyNo());
			result.put("ParkingLotNo", item.getKey().getParkingLotNo());
			result.put("CarNo", item.getValue().getCatNo());
			resultArrayList.add(result);
		}
		return resultArrayList;
	}
}
