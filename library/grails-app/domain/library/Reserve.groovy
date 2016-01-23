package library

class Reserve {

	String namebook
	String idbook
	Date date
	Long idname
	String fname
	String lname


    static constraints = {

    	idbook(matches:/[ABCDEFGHIJKLMNOPQRSTUVWXYZ]\d{7}/)
    	//idname(matches:/\d+/,size:7..7)
    	fname(matches:/[abcdefghijklmnopqrstuvwxyz].+[abcdefghijklmnopqrstuvwxyz]/)
        lname(matches:/[abcdefghijklmnopqrstuvwxyz].+[abcdefghijklmnopqrstuvwxyz]/)
    	
    	
    }
}
