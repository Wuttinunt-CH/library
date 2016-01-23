package library

class Book {
	String idBook	
	String nameBook
	String publisher
	String status
	Integer price
	Date dateReg
	String author
	Integer buildYear
	String shelf
	String detail
	Date dateReturn

	static belongsTo = [typeBook: TypeBook]
	//static hasMany = [borrow: Borrow]
	//static hasOne = [borrowdetail: BorrowDetail]
	static mapping = {
        version false
        
    }

    static constraints = {
    	idBook (unique: true)
    	dateReturn nullable: true ,blank: false
    	detail nullable: true ,blank: false
    }
}
