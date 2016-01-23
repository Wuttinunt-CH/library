package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    void "1.test false for unique"() {
        given:
        	def c = new Book()
        	def d = new Book()
        	def e = new TypeBook()

        when:
        	c.idBook = "0000000001"	
			c.nameBook = "A"
			c.publisher = "B"
			c.status = "พร้อมให้ยืม"
			c.price = "1"
			c.dateReg = new Date()
			c.author = "C"
			c.buildYear = "1"
			c.shelf = "D"
			c.detail = "E"
			c.dateReturn = new Date()
			e.type = "หนังสือทั่วไป"
      	 	c = c.save(flush:true)

        	d.idBook = "0000000001"	

        then:
        d.validate() == false
    }
}
