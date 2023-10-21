package project.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.service.ArtistService;

@Component
public class DatabaseInitializer implements CommandLineRunner{

    private final ArtistService artistService;

    public DatabaseInitializer(ArtistService artistService) {
        this.artistService = artistService;
    }


    @Override public void run(String... args) throws Exception {
      artistService.initArtists();
    }
}

