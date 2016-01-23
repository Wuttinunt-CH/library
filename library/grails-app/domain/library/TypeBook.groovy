package library

class TypeBook {

	String type

	static hasMany = [book: Book]

	String toString(){
		return "$type"
	}

    static constraints = {
    }
}
