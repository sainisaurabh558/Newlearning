package api.payload;

public class Message {

	String messageKey;
	int messageType;
	String message;
	int errorInformations[];
	
	public String getMessageKey() {
		return messageKey;
	}
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int[] getErrorInformations() {
		return errorInformations;
	}
	public void setErrorInformations(int[] errorInformations) {
		this.errorInformations = errorInformations;
	}
	


}
