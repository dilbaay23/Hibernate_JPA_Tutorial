package udemy_hibernate.entity;

public enum Rating {
	STANDART(100),PREMIUM(200);   // value will be persisted in database

	private int value;
	
	private Rating(int value) {
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
