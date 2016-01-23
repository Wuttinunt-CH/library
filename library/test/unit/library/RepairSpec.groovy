package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Repair)
class RepairSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
 
    void "test input data"() {
    	given:
    	def r = new Repair()

    	when:
    	r.cause = "test"
    	r = r.save(flush: true)

    	then:

		r.validate() == true    	
    }

    void "test input no data"() {
    	given:
    	def r = new Repair()

    	when:
    	r.cause = null
    	

    	then:

		r.validate() == false   	
   }

}
