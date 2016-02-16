package register

class Subject {

	String code
	String name
	String time
	Integer section

    static constraints = {
		code(matches: /\d+/, size: 6..6)
		section(matches: /\d+/, max: 999, min: 1)
    }
}
