package register

class Planning {

	Integer code
	String name
	Integer status

	static hasMany = [items: HavingSubject]

    static constraints = {
		name(matches: /[P][l][a][n][n][i][n][g][ ]\d+/)
		status(inList: [0, 1])
    }
}
