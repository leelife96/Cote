package good;


class Customer {
	private String uid;
    private String name;
    private String phoneNumber;

    public Customer(String uid, String name, String phoneNumber) {
    	this.uid = uid;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getUID() {
		return uid;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	
	
}

 