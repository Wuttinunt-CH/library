package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Return)
class ReturnSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "input Wrong data Return Book"() {

    	given:
        def r = new Return()

        when:
        r.dateReturn = "12345"
        r.idBook = "1001"
        r.authoritie = "Wuttinunt Ch"

        r = r.save(flush: true)

        then:

        r.validate() == false
    }
}
