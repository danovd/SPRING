package project.service;

import project.model.entity.Word;
import project.model.entity.enums.LanguageNameEnum;
import project.model.service.WordServiceModel;

import java.util.Set;

public interface WordService {
    void add(WordServiceModel map);

    Set<Word> getAllByLanguage(LanguageNameEnum languageNameEnum);

    void deleteById(String id);

    void deleteAll();
}
