package library

class Borrow {

	Long id
	Date dateBorrow
	Date dateReturn
	String user
	String idBook
	String authoritie


	//static belongsTo = [user: User,idBook:Book]

	//static hasOne = [borrowdetail: BorrowDetail]

	static mapping = {}
    static constraints = {
    	idBook(matches:/\d+/,size:10..10)
    }
}
