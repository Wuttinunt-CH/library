package library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Table_reservations)
class Table_reservationsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test Table_reservations"() {
    	given:"กำหนดให้ t คือข้อมูล Table_reservations"

    	def t = new Table_reservations()

    	when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ t"
        t.id = "1"
    	t.idcode = "B5600000" 
    	t.dates = new Date()
    	t.hour = "3 hr"
    	t.rooms = "Single room"
    	t.objective = "read a book"

    	then:"ตรวจสอบข้อมูลถูกต้อง"
    	t.validate() == true
    }
    void "ทดสอบรหัสนักศึกษาที่ขึ้นต้นด้วย B,M และD เท่านั้น"(){
        given:

        def t = new Table_reservations()

        when:
        t.id = "1"
        t.idcode =id= "A5600000" 
    	t.dates = new Date() 
    	t.hour = "3 hr"
    	t.rooms = "Single room"
    	t.objective = "read a book"

    	then:
    	t.validate() == false
    	where:
        id <<('A'..'Z')-['B','M','D']
    }
    void "test for rooms is null"() {
    	given:"กำหนดให้ t คือข้อมูล Table_reservations"

    	def t = new Table_reservations()

    	when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ t"
        t.id = "1"
    	t.idcode = "B5600000" 
    	t.dates = new Date()
    	t.hour = "3 hr"
    	t.rooms = null
    	t.objective = "read a book"

    	then:
    	t.validate() == false
    }
    void "test for rooms is null"() {
    	given:"กำหนดให้ t คือข้อมูล Table_reservations"

    	def t = new Table_reservations()

    	when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ t"
        t.id = "1"
    	t.idcode = "B5600000" 
    	t.dates = new Date()
    	t.hour = "3 hr"
    	t.rooms = "Single room"
    	t.objective = null

    	then:
    	t.validate() == false
    }
    void "test for hour is null"() {
    	given:"กำหนดให้ t คือข้อมูล Table_reservations"

    	def t = new Table_reservations()

    	when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ t"
        t.id = "1"
    	t.idcode = "B5600000" 
    	t.dates = new Date()
    	t.hour = null
    	t.rooms = "Single room"
    	t.objective = "read a book"

    	then:
    	t.validate() == false
    }
    void "test ตัวหนังสือท้าย hour  ว่า hr"() {
        given:"ความยาวหลัง BMDเท่ากับ 7 ตัวเลขเท่านั้น"

        def t = new Table_reservations()

        when:"เมื่อใส่ข้อมูลที่ถูกต้องให้ t"
        t.id = "1"
        t.idcode = h 
        t.dates = new Date()
        t.hour = "3 hr"
        t.rooms = "Single room"
        t.objective = "read a book"

        then:
        t.validate() == result
        where:
        h            |   result
        "B5603848"   |   true
        "B5603000"   |   true
        "B5555555"   |   true
        "B5600"      |   false
        "B56032"     |   false
    }
}
