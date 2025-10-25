package api.payload;

public class AddOrUpdateApiResponse {
	Integer  response;
	Message message;
	

	public Integer getResponse() {
		return response;
	}
	public void setResponse(Integer response) {
		this.response = response;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
