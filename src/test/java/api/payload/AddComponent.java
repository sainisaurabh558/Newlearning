package api.payload;

import java.util.List;

public class AddComponent {

	Integer  id;
	String componentId;
	String partName;
	int companyId;
	List<SerialStructureDtoCabinet> serialStructureDTOs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public List<SerialStructureDtoCabinet> getSerialStructureDTOs() {
		return serialStructureDTOs;
	}
	public void setSerialStructureDTOs(List<SerialStructureDtoCabinet> serialStructureDTOs) {
		this.serialStructureDTOs = serialStructureDTOs;
	}
	
	
	

	
}
