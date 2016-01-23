package library

class User {

	//Long id
	String username
	String prefix
	String fname
	String lname
	Character sex
	Integer age
	String tel
	String email
	Date date_reg
	//String username
	String password

	
	String toString(){
    	return "$username"
    }
    

	static belongsTo = [group: UserGroup]
	//static hasMany = [reserv: Table_reservations,borrow:Borrow]

	static mapping = {
        version false
        //autoTimestamp true
    }

   


	
    static constraints = {
    	email email: true ,blank: false
    }
}
