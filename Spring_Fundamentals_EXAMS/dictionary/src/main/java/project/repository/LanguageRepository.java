package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Language;
import project.model.entity.enums.LanguageNameEnum;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {
    Language findByLanguageName(LanguageNameEnum language);
}
