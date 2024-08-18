package facade;

public class MoviePlayerFacade {
    private DvdPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Projector projector;

    public MoviePlayerFacade(DvdPlayer dvdPlayer, SoundSystem soundSystem, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
        this.projector = projector;
    }

    public void playMovie(String movie) {
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movie);
        soundSystem.turnOn();
        soundSystem.setVolume(10);
        projector.turnOn();
        projector.setInput(dvdPlayer);
        projector.project();
    }

    public void stopMovie() {
        dvdPlayer.turnOff();
        soundSystem.turnOff();
        projector.turnOff();
    }
}
