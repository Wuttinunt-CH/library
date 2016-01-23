package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Borrow)
class BorrowSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test input Borrow Data Right"() {
        given:
        def b = new Borrow()

        when:
        b.dateBorrow = new Date()
        b.dateReturn = new Date()
        b.user = "B5601233"
        b.idBook = i + i + i + i + i + i + i + i + i + i
        b.authoritie = "Wuttinunt Ch"

        b = b.save(flush: true)

        then:

        b.validate() == true

        where:
        i << ('0'..'9')


    }

    void "test input idBook < 10"() {
        given:
        def b = new Borrow()

        when:
        b.dateBorrow = new Date()
        b.dateReturn = new Date()
        b.user = "B5601233"
        b.idBook = i + i + i + i + i + i + i + i + i 
        b.authoritie = "Wuttinunt Ch"

        //b = b.save(flush: true)

        then:

        b.validate() == false

        where:

        i << ('0'..'9')
        
        

}
    void "test input idBook > 10"() {
        given:
        def b = new Borrow()

        when:
        b.dateBorrow = new Date()
        b.dateReturn = new Date()
        b.user = "B5601233"
        b.idBook = i + i + i + i + i + i + i + i + i + i + i
        b.authoritie = "Wuttinunt Ch"

        //b = b.save(flush: true)

        then:

        b.validate() == false

        where:
        i << ('0'..'9')
        
        

}

    void "test input idBook ไม่เป็นตัวเลข"() {
        given:
        def b = new Borrow()

        when:
        b.dateBorrow = new Date()
        b.dateReturn = new Date()
        b.user = "B5601233"
        b.idBook = "test"
        b.authoritie = "Wuttinunt Ch"

        //b = b.save(flush: true)

        then:

        b.validate() == false

       
        
        

}

}
