package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(AddUser)
class AddUserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

     void "test การใส่ชื่อผู้ใช้"() {
        given:"ความยาวหลัง BMDเท่ากับ 7 ตัวเลขเท่านั้น"

        def u = new AddUser()

        when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ u"
        u.username = um
        u.dates = new Date()

        then:
        u.validate() == result
        where:
        un           |   result
        "B5603848"   |   true
        "B5603000"   |   true
        "B5555555"   |   true
        "B5600"      |   false
        "B56032"     |   false
    }
}
