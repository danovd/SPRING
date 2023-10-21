package project.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.service.LanguageService;

@Component
public class DatabaseInitializer implements CommandLineRunner{

    private final LanguageService languageService;

    public DatabaseInitializer(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override public void run(String... args) throws Exception {
        languageService.initLanguages();

    }
}

