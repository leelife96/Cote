package shopmall;

public class Customer {
    private int id;    // 고객의 식별자를 저장하는 변수입니다.
    private String name; // 고객의 이름을 저장하는 변수입니다.
    private String phoneNumber; // 고객의 전화번호를 저장하는 변수입니다.
    private String email; // 고객의 이메일 주소를 저장하는 변수입니다.	

    public Customer(int id, String name, String phoneNumber, String email) {  // 생성자 Customer는 이 멤버 변수들을 초기화하는 역할을 합니다.
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    
    // Customer 클래스에는 각 멤버 변수에 접근하기 위한 게터(getter) 메서드들이 있습니다. 
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
