package api.payload;

public class SerialStructureDtoCabinet {
	
	Integer id;
	String serialStructure;
	String partType;
	int companyId;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerialStructure() {
		return serialStructure;
	}
	public void setSerialStructure(String serialStructure) {
		this.serialStructure = serialStructure;
	}
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
	