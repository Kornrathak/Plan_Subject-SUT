package register

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Planning)
class PlanningSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
	void "test27"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning 1"
			plan.status = 3
		then:
			plan.validate() == false
    }
	
	void "test26"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning 1"
		then:
			plan.validate() == false
    }
	
	void "test25"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning 1"
			plan.status = 1
		then:
			plan.validate() == true
    }
	
	void "test24"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning " + i
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 88, 100, 150, 999, 1999]
    }
	
	void "test23"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning " + i
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') - ('0'..'9')
    }
	
	void "test22"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning " + i
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ('0'..'9')
    }
	
	void "test21"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning" + i + "1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - [' ']
    }
	
	void "test20"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning" + i + "1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << [' ']
    }
	
	void "test19"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plannin" + i + " 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['g']
    }
	
	void "test18"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plannin" + i + " 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['g']
    }
	
	void "test17"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planni" + i + "g 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['n']
    }
	
	void "test16"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planni" + i + "g 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['n']
    }
	
	void "test15"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plann" + i + "ng 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['i']
    }
	
	void "test14"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plann" + i + "ng 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['i']
    }
	
	void "test13"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plan" + i + "ing 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['n']
    }
	
	void "test12"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Plan" + i + "ing 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['n']
    }
	
	void "test11"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Pla" + i + "ning 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['n']
    }
	
	void "test10"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Pla" + i + "ning 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['n']
    }
	
	void "test9"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Pl" + i + "nning 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['a']
    }
	
	void "test8"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Pl" + i + "nning 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['a']
    }
	
	void "test7"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = 'P' + i + "anning 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['l']
    }
	
	void "test6"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = 'P' + i + "anning 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['l']
    }
	
	void "test5"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = i + "lanning 1"
			plan.status = 0
		then:
			plan.validate() == false
		where:
			i << ('A'..'Z') + ('a'..'z') + ('0'..'9') - ['P']
    }
	
	void "test4"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = i + "lanning 1"
			plan.status = 0
		then:
			plan.validate() == true
		where:
			i << ['P']
    }
	
	void "test3"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.status = 0
		then:
			plan.validate() == false
    }
	
	void "test2"() {
		given:
			def plan = new Planning()
		when:
			plan.name = "Planning 1"
			plan.status = 0
		then:
			plan.validate() == false
    }

    void "test1"() {
		given:
			def plan = new Planning()
		when:
			plan.code = 1
			plan.name = "Planning 1"
			plan.status = 0
		then:
			plan.validate() == true
    }
}
