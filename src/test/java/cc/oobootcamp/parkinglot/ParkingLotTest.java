package cc.oobootcamp.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParkingLotTest {
	@Test
	public void should_return_ticket_when_one_car_park_given_parkinglot_have_restspace() {
		int spaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(spaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		assertNotNull(ticket);

	}

	@Test(expected = ParkingLotFullException.class)
	public void should_return_park_null_when_one_car_park_given_parkinglot_full() {
		int restspaceNum = 0;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);

	}

	@Test
	public void should_return_car_when_extract_one_car_given_one_parked_car_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		Car extractcar = parkinglot.extractCar(ticket);
		assertEquals(car, extractcar);
		assertSame(car, extractcar);
	}

	@Test(expected = ExtractCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_not_parked_car_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car extractcar = parkinglot.extractCar(new Ticket());

	}

	@Test(expected = ExtractCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_used_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		Car firstExtractcar = parkinglot.extractCar(ticket);
		Car secondExtractcar = parkinglot.extractCar(ticket);
	}

	
	@Test
	public void should_return_ticket_when_one_car_park_given_parkingboy_and_parkinglots_have_restspace() {

		int firstRestSpaceNum = 1;
		int secondRestSpaceNum = 2;
		String parkingBoyNo = "no1";
		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum);
		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum);
		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();
		ParkingBoy parkingBoy = new ParkingBoy(parkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);
		Ticket ticket = parkingBoy.assignParkLotAndPacking(car);
		assertNotNull(ticket);
	}

	
	@Test
	public void should_return_car_when_extract_one_car_given_parkingboy_and_one_parked_car_ticket() {

		int firstRestSpaceNum = 1;
		int secondRestSpaceNum = 2;
		String parkingBoyNo = "no1";
		String firstparkingLotNo = "first";
		String secondparkingLotNo = "second";

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum, firstparkingLotNo);
		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum, secondparkingLotNo);
		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();
		ParkingBoy parkingBoy = new ParkingBoy(parkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);
		Ticket ticket = parkingBoy.assignParkLotAndPacking(car);

		Car extractcar = parkingBoy.extractCar(ticket);

		assertEquals(car, extractcar);

	}

	
	@Test
	public void should_return_ticket_of_more_restspace_parkinglot_when_one_car_park_given_smartparkingboy_and_parkinglots_have_restspace() {

		int firstRestSpaceNum = 1;
		int secondRestSpaceNum = 2;
		String firstParkingLotNo = "pl1";
		String secondParkingLotNo = "pl2";
		String parkingBoyNo = "pb1";

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum);
		parkinglotone.setParkingLotNo(firstParkingLotNo);

		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum);
		parkinglottwo.setParkingLotNo(secondParkingLotNo);

		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();
		SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);
		Ticket ticket = parkingBoy.assignParkLotAndPacking(car);
		assertEquals(secondParkingLotNo, ticket.getParkingLotNo());
	}

	
	@Test
	public void should_return_ticket_of_more_vacancyrate_parkinglot_when_one_car_park_given_superparkingboy_and_parkinglots_have_restspace() {

		int firstSumSpaceNum = 10;
		int firstRestSpaceNum = 5;
		int secondRestSpaceNum = 2;
		int secondSumSpaceNum = 10;

		String firstParkingLotNo = "pl1";
		String secondParkingLotNo = "pl2";
		String parkingBoyNo = "pb1";

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum);
		parkinglotone.setParkingLotNo(firstParkingLotNo);
		parkinglotone.setSumSpcae(firstSumSpaceNum);

		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum);
		parkinglottwo.setParkingLotNo(secondParkingLotNo);
		parkinglottwo.setSumSpcae(secondSumSpaceNum);

		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);

		Car car = new Car();
		SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);
		Ticket ticket = parkingBoy.assignParkLotAndPacking(car);
		assertEquals(firstParkingLotNo, ticket.getParkingLotNo());
	}

	
	@Test
	public void should_return_ticket_when_one_car_park_given_ParkingManager_manage_parkingboys_and_parkinglots_have_restspace() {

		int firstRestSpaceNum = 1;
		int secondRestSpaceNum = 2;
		String fparkingBoyNo = "no1";
		String sparkingBoyNo = "no2";
		String tparkingBoyNo = "no3";
		String parkingManageNo = "no0";
		String firstparkingLotNo = "first";
		String secondparkingLotNo = "second";

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum, firstparkingLotNo);
		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum, secondparkingLotNo);
		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();

		ParkingBoy parkingBoy = new ParkingBoy(fparkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);

		SmartParkingBoy smartParkingBoy = new SmartParkingBoy(sparkingBoyNo);
		smartParkingBoy.setParkingLots(parkingLots);

		SuperParkingBoy superParkingBoy = new SuperParkingBoy(tparkingBoyNo);
		superParkingBoy.setParkingLots(parkingLots);

		List<ParkingBoy> parkingBoys = new ArrayList();
		parkingBoys.add(parkingBoy);
		parkingBoys.add(smartParkingBoy);
		parkingBoys.add(superParkingBoy);

		ParkingManager parkingManager = new ParkingManager(parkingManageNo);
		parkingManager.setParkingBoys(parkingBoys);
		parkingManager.manageParkingBoyParking(car);
		Ticket ticket = parkingBoy.assignParkLotAndPacking(car);
		assertNotNull(ticket);
	}

	@Test
	public void should_return_ticket_when_one_car_park_given_ParkingManager_and_parkinglots_have_restspace() {

		int firstRestSpaceNum = 1;
		int secondRestSpaceNum = 2;
		String parkingManageNo = "no0";
		String firstparkingLotNo = "first";
		String secondparkingLotNo = "second";

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum, firstparkingLotNo);
		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum, secondparkingLotNo);
		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();

		ParkingManager parkingManager = new ParkingManager(parkingManageNo);
		parkingManager.setParkingLots(parkingLots);
		Ticket ticket = parkingManager.assignParkLotAndPacking(car);
		assertNotNull(ticket);
	}

	// 6作为停车场的主管（Parking Director），我希望看到一张报表，其中包括经理和每个停车仔所管理的车
	@Test
	public void should_return_reportlist_when_parkingdirector_want_a_report_given_ParkingManager_and_parkingboys_and_parkinglots() {

		int firstRestSpaceNum = 10;
		int secondRestSpaceNum = 20;
		String fparkingBoyNo = "no1";
		String sparkingBoyNo = "no2";
		String tparkingBoyNo = "no3";
		String parkingManageNo = "no0";
		String parkingDirectorNo = "no4";
		String firstparkingLotNo = "first";
		String secondparkingLotNo = "second";
		String carNoString = "c1";
		String scarNoString = "c2";
		String tcarNoString = "c3";
		String fcarNoString = "c4";
		

		ParkingLot parkinglotone = new ParkingLot(firstRestSpaceNum, firstparkingLotNo);
		ParkingLot parkinglottwo = new ParkingLot(secondRestSpaceNum, secondparkingLotNo);
		List<ParkingLot> parkingLots = new ArrayList();
		parkingLots.add(parkinglotone);
		parkingLots.add(parkinglottwo);
		Car car = new Car();
		car.setCatNo(carNoString);
		Car scar = new Car();
		scar.setCatNo(scarNoString);
		Car tcar = new Car();
		tcar.setCatNo(tcarNoString);
		Car fcar = new Car();
		fcar.setCatNo(fcarNoString);
		

		ParkingBoy parkingBoy = new ParkingBoy(fparkingBoyNo);
		parkingBoy.setParkingLots(parkingLots);
		parkingBoy.assignParkLotAndPacking(car);
		

		SmartParkingBoy smartParkingBoy = new SmartParkingBoy(sparkingBoyNo);
		smartParkingBoy.setParkingLots(parkingLots);
		smartParkingBoy.assignParkLotAndPacking(scar);

		SuperParkingBoy superParkingBoy = new SuperParkingBoy(tparkingBoyNo);
		superParkingBoy.setParkingLots(parkingLots);
		superParkingBoy.assignParkLotAndPacking(tcar);

		ParkingManager parkingManager = new ParkingManager(parkingManageNo);
		parkingManager.setParkingLots(parkingLots);
		parkingManager.assignParkLotAndPacking(fcar);
		
		ParkingDirector parkingDirector = new ParkingDirector(parkingDirectorNo);
		parkingDirector.setParkingLots(parkingLots);
		
		List report= parkingDirector.displayReport();
		
		
		assertNotNull(report);
	}
}
