package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    private static final int FIRE_BULLETS_COUNT = 1;

    public Pistol(String name, int bulletsCount) {
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
