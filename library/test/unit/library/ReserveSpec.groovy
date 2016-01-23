package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reserve)
class ReserveSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test reserve"() {

    	given: 

    	def s = new Reserve()

    	when:
    	s.idbook = "B5617883"
    	s.namebook = "calculas"
    	s.date = new Date()
    	s.idname = 3424310
    	s.fname = "atiwut"
    	s.lname = "puangdokmai"

    	then:
    	s.validate() == true
    }

    void "test idbook"() {

    	given: 

    	def s = new Reserve()

    	when:
    	s.idbook = id + "5617883"
    	s.namebook = "calculas"
    	s.date = new Date()
    	s.idname = 3424310
    	s.fname = "atiwut"
    	s.lname = "puangdokmai"

    	then:
    	s.validate() == true

    	where:
    	id << ('A'..'Z')

    	
    }

        void "test fname"() {

        given: 

        def s = new Reserve()

        when:
        s.idbook = "B5617883"
        s.namebook = "calculas"
        s.date = new Date()
        s.idname = 3424310
        s.fname = id
        s.lname = "puangdokmai"

        then:
        s.validate() == result

        where:

        id              |        result
        "atiwut"        |        true
        "styger"        |        true
        "34dsa"         |        false
        "anuwut23"      |        false        
        "3424234233"    |        false

        
    }

    void "test lname"() {

        given: 

        def s = new Reserve()

        when:
        s.idbook = "B5617883"
        s.namebook = "calculas"
        s.date = new Date()
        s.idname = 3424310
        s.fname = "atiwut"
        s.lname = id

        then:
        s.validate() == result

        where:

        id                   |        result
        "puangdokmai"        |        true
        "boyger"             |        true
        "3farya"             |        false
        "rodmono8"           |        false        
        "7724768246"         |        false

        
    }
    

    
}
