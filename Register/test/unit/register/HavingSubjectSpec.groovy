package register

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(HavingSubject)
class HavingSubjectSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	void "test3"() {
		given:
			def hav = new HavingSubject()
		when:
			hav.sub = new Subject()
		then:
			hav.validate() == false
    }
	
	void "test2"() {
		given:
			def hav = new HavingSubject()
		when:
			hav.plan = new Planning()
		then:
			hav.validate() == false
    }

    void "test1"() {
		given:
			def hav = new HavingSubject()
		when:
			hav.plan = new Planning()
			hav.sub = new Subject()
		then:
			hav.validate() == true
    }
}
