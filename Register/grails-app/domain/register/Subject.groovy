package register

class Subject {

	String code
	String name
	String time
	Integer sectiongroup
	Integer status
	
	static hasMany = [itemes: HavingSubject]

    static constraints = {
		code(matches: /\d+/, size: 6..6)
		sectiongroup(matches: /\d+/, max: 999, min: 1)
		status(inList: [0, 1])
    }
}
