package project.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.service.ConditionService;

@Component
public class DatabaseInitializer implements CommandLineRunner{

    private final ConditionService conditionService;

    public DatabaseInitializer(ConditionService conditionService) {
        this.conditionService = conditionService;
    }


    @Override public void run(String... args) throws Exception {
          conditionService.initConditions();
    }
}

