package br.com.compasso.response;

public class Message {

	private Object content;

	/**
	 * @param content
	 */
	public Message(Object content) {
		this.content = content;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [content=" + content + "]";
	}
}