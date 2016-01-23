package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(BookOrder)
class BookOrderSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test input data"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.bookname = "test1" 
		o.booktypes = "test2"
		o.bookpub = "test3"
		o.booknum = 1
		o.bookcost = 2
    	o = o.save(flush: true)

    	then:

		o.validate() == true    	
    }

    void "test input no name"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.booktypes = "test2"
		o.bookpub = "test3"
		o.booknum = 1
		o.bookcost = 2
    	

    	then:

		o.validate() == false   	
   }

   void "test input no types"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.bookname = "test1" 
		//o.booktypes = "test2"
		o.bookpub = "test3"
		o.booknum = 1
		o.bookcost = 2
    	

    	then:

		o.validate() == false   	
   }

   void "test input no pub"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.bookname = "test1" 
		o.booktypes = "test2"
		//o.bookpub = "test3"
		o.booknum = 1
		o.bookcost = 2
    	

    	then:

		o.validate() == false   	
   }

   void "test input no num"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.bookname = "test1" 
		o.booktypes = "test2"
		o.bookpub = "test3"
		//o.booknum = 1
		o.bookcost = 2
    	

    	then:

		o.validate() == false   	
   }

   void "test input no cost"() {
    	given:
    	def o = new BookOrder()

    	when:
    	o.bookname = "test1" 
		o.booktypes = "test2"
		o.bookpub = "test3"
		o.booknum = 1
		//o.bookcost = 2
    	

    	then:

		o.validate() == false   	
   }
}