package register

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subject)
class SubjectSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
	void "test26"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 999
			sub.status = 2
		then:
			sub.validate() == false
	}
	
	void "test27"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1000
		then:
			sub.validate() == false
	}
	
	void "test26"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 999
			sub.status = 1
		then:
			sub.validate() == true
	}
	
	void "test25"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1000
			sub.status = 0
		then:
			sub.validate() == false
	}
	
	void "test24"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 0
			sub.status = 0
		then:
			sub.validate() == false
	}
	
	void "test23"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 999
			sub.status = 0
		then:
			sub.validate() == true
	}
	
	void "test22"() {
		given:
			def sub = new Subject()
		when:
			sub.code = id
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == result
		where:
			id				|	result
			"523101"		|	true
			"52310x"		|	false
			"5231x1"		|	false
			"523x11"		|	false
			"52x111"		|	false
			"5x1111"		|	false
			"x11111"		|	false
			"1"				|	false
			"12"			|	false
			"123"			|	false
			"1234"			|	false
			"12345"			|	false
			"1234567"		|	false
			"12345678"		|	false
	}
	
	void "test21"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "52310" + i
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test20"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "5231" + i + '1'
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test19"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523" + i + "01"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test18"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "52" + i + "101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test17"() {
		given:
			def sub = new Subject()
		when:
			sub.code = '5' + i + "3101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test16"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "52310" + i
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test15"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "5231" + i + '1'
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test14"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523" + i + "01"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test13"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "52" + i + "101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test12"() {
		given:
			def sub = new Subject()
		when:
			sub.code = '5' + i + "3101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test11"() {
		given:
			def sub = new Subject()
		when:
			sub.code = i + "23101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z')
	}
	
	void "test10"() {
		given:
			def sub = new Subject()
		when:
			sub.code = i + "23101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
		where:
			i << ('0'..'9')
	}
	
	void "test9"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 12345
			sub.status = 0
		then:
			sub.validate() == false
	}
	
	void "test8"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1234
			sub.status = 0
		then:
			sub.validate() == false
	}
	
	void "test7"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 123
			sub.status = 0
		then:
			sub.validate() == true
	}
	
	void "test6"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 12
			sub.status = 0
		then:
			sub.validate() == true
	}
	
	void "test5"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
	}
	
	void "test1"() {
		given:
			def sub = new Subject()
		when:
			sub.code = "523101"
			sub.name = "Computer Programing I"
			sub.time = "Mon 10:00-11:00;"
			sub.sectiongroup = 1
			sub.status = 0
		then:
			sub.validate() == true
    }
}
