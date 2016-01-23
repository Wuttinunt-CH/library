package library

class UserGroup {

	String id_group
	String group_name
	//int borrow
	Integer total_borrow
	Integer fine

	static hasMany = [user:User]

	static mapping = {
        version false
    }

    String toString(){
    	return "$group_name"
    }
	
    static constraints = {
    }
}
