package library

class Table_reservations{
	Integer id
    String idcode
	Date dates
    String hour
	String rooms
	String objective
	

    //static belongsTo = [owner: User]
    static constraints = {
    	idcode(matches:/[BMD]\d{7}/)
    }
}