
class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
//        pet dog archer sleep prisonerisawake
//        dog is missing both archer and knight are sleeping and prisoner is awake
        if(!petDogIsPresent) {
            return prisonerIsAwake && (canFastAttack(knightIsAwake) && !archerIsAwake);
        }
        return petDogIsPresent && !archerIsAwake;
    }

}
