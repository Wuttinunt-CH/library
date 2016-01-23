package library

class BorrowDetail {

		

		static belognsTo = [borrow: Borrow,book: Book]

		static mapping = {}

    static constraints = {
    	//borrow unique: true
    	//book unique: true
    }
}
