package facade;

public class Client {

    public static void main(String[] args) {
        DvdPlayer dvdPlayer = new DvdPlayer();
        SoundSystem soundSystem = new SoundSystem();
        Projector projector = new Projector();
        MoviePlayerFacade moviePlayerFacade = new MoviePlayerFacade(dvdPlayer, soundSystem, projector);
        moviePlayerFacade.playMovie("The Matrix");
        System.out.println("-------------------------");
        moviePlayerFacade.stopMovie();
    }
}
