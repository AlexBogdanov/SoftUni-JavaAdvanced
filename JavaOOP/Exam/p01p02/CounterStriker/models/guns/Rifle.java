package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    private static final int FIRE_BULLETS_COUNT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < FIRE_BULLETS_COUNT) {
            return 0;
        }

        int oldBullets = super.getBulletsCount();
        int newBullets = oldBullets - FIRE_BULLETS_COUNT;
        super.setBulletsCount(newBullets);
        return FIRE_BULLETS_COUNT;
    }

}
