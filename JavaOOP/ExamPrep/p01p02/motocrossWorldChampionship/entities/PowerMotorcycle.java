package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class PowerMotorcycle extends MotorcycleImpl {

    private static double CUBIC_CENTIMETERS = 450;
    private static int MINIMUM_HORSE_POWER = 70;
    private static int MAXIMUM_HORSE_POWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSE_POWER || horsePower > MAXIMUM_HORSE_POWER) {
            throw new IllegalArgumentException(String.format(
                ExceptionMessages.INVALID_HORSE_POWER, horsePower
            ));
        }

        super.setHorsePower(horsePower);
    }

}
