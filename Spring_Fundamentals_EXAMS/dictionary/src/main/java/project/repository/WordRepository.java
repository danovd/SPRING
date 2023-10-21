package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Word;
import project.model.entity.enums.LanguageNameEnum;

import java.util.Set;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    Set<Word> findAllByLanguage_LanguageName(LanguageNameEnum languageNameEnum);
}
