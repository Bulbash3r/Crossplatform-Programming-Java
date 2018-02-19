class CompareEnum {
    /**
     * This enumeration is intended for check relations
     * of user number and random number.
     *
     * NOT_ENTERED: number is not entered in TextField.
     * NOT_STARTED: the game is not running.
     * MORE: user number is more then computer number.
     * LESS: user number is less then computer number.
     * WIN: user write right number, game is over.
     */
    enum compareResult {
        NOT_ENTERED, NOT_STARTED, MORE, LESS, WIN
    }
}