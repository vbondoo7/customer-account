package com.cox.bis.customer.account.model.house;


/**
 * @author jahill
 *
 */
public class Address {

	//Address
	private String addressLine1;
	private String addressLine2;
	private String unit;
	private String city;
	private String state;
	private String zip5;
	private String zip4;
	private String latitiude;
	private String longitude;
	
	//Address Line Components
	private String preDirectional;
	private String streetNumber;
	private String streetName;
	private String streetType;
	private String postDirectional;
	
	//Apartment / Unit / Building
	private String building;
	private String unitType;
	private String unitCode;
	private String apartmentCode;
	

	//Organizational
	private String siteId;
	private String houseNumber;
	private String occupancyCode;
	private String accountNumber9;
	private String companyNumber;
	private String divisionNumber;
	private String franchiseNumber;

	//Types
	private String billTypeCode;
	private String houseAddressable;
	private String houseStatus;
	private String dwellingType;
	
	
	
	
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip5
	 */
	public String getZip5() {
		return zip5;
	}
	/**
	 * @param zip5 the zip5 to set
	 */
	public void setZip5(String zip5) {
		this.zip5 = zip5;
	}
	/**
	 * @return the zip4
	 */
	public String getZip4() {
		return zip4;
	}
	/**
	 * @param zip4 the zip4 to set
	 */
	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}
	/**
	 * @return the latitiude
	 */
	public String getLatitiude() {
		return latitiude;
	}
	/**
	 * @param latitiude the latitiude to set
	 */
	public void setLatitiude(String latitiude) {
		this.latitiude = latitiude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the preDirectional
	 */
	public String getPreDirectional() {
		return preDirectional;
	}
	/**
	 * @param preDirectional the preDirectional to set
	 */
	public void setPreDirectional(String preDirectional) {
		this.preDirectional = preDirectional;
	}
	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * @return the streetType
	 */
	public String getStreetType() {
		return streetType;
	}
	/**
	 * @param streetType the streetType to set
	 */
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	/**
	 * @return the postDirectional
	 */
	public String getPostDirectional() {
		return postDirectional;
	}
	/**
	 * @param postDirectional the postDirectional to set
	 */
	public void setPostDirectional(String postDirectional) {
		this.postDirectional = postDirectional;
	}
	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	/**
	 * @return the unitType
	 */
	public String getUnitType() {
		return unitType;
	}
	/**
	 * @param unitType the unitType to set
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	/**
	 * @return the unitCode
	 */
	public String getUnitCode() {
		return unitCode;
	}
	/**
	 * @param unitCode the unitCode to set
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	/**
	 * @return the apartmentCode
	 */
	public String getApartmentCode() {
		return apartmentCode;
	}
	/**
	 * @param apartmentCode the apartmentCode to set
	 */
	public void setApartmentCode(String apartmentCode) {
		this.apartmentCode = apartmentCode;
	}
	/**
	 * @return the occupancyCode
	 */
	public String getOccupancyCode() {
		return occupancyCode;
	}
	/**
	 * @param occupancyCode the occupancyCode to set
	 */
	public void setOccupancyCode(String occupancyCode) {
		this.occupancyCode = occupancyCode;
	}
	/**
	 * @return the accountNumber9
	 */
	public String getAccountNumber9() {
		return accountNumber9;
	}
	/**
	 * @param accountNumber9 the accountNumber9 to set
	 */
	public void setAccountNumber9(String accountNumber9) {
		this.accountNumber9 = accountNumber9;
	}
	/**
	 * @return the companyNumber
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
	/**
	 * @param companyNumber the companyNumber to set
	 */
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	/**
	 * @return the divisionNumber
	 */
	public String getDivisionNumber() {
		return divisionNumber;
	}
	/**
	 * @param divisionNumber the divisionNumber to set
	 */
	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}
	/**
	 * @return the franchiseNumber
	 */
	public String getFranchiseNumber() {
		return franchiseNumber;
	}
	/**
	 * @param franchiseNumber the franchiseNumber to set
	 */
	public void setFranchiseNumber(String franchiseNumber) {
		this.franchiseNumber = franchiseNumber;
	}
	/**
	 * @return the billTypeCode
	 */
	public String getBillTypeCode() {
		return billTypeCode;
	}
	/**
	 * @param billTypeCode the billTypeCode to set
	 */
	public void setBillTypeCode(String billTypeCode) {
		this.billTypeCode = billTypeCode;
	}
	/**
	 * @return the houseAddressable
	 */
	public String getHouseAddressable() {
		return houseAddressable;
	}
	/**
	 * @param houseAddressable the houseAddressable to set
	 */
	public void setHouseAddressable(String houseAddressable) {
		this.houseAddressable = houseAddressable;
	}
	/**
	 * @return the houseStatus
	 */
	public String getHouseStatus() {
		return houseStatus;
	}
	/**
	 * @param houseStatus the houseStatus to set
	 */
	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}
	/**
	 * @return the dwellingType
	 */
	public String getDwellingType() {
		return dwellingType;
	}
	/**
	 * @param dwellingType the dwellingType to set
	 */
	public void setDwellingType(String dwellingType) {
		this.dwellingType = dwellingType;
	}

}