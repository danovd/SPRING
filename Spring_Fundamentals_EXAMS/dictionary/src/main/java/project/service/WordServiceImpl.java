package project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.User;
import project.model.entity.Word;
import project.model.entity.enums.LanguageNameEnum;
import project.model.service.WordServiceModel;
import project.repository.LanguageRepository;
import project.repository.UserRepository;
import project.repository.WordRepository;
import project.util.CurrentUser;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {


    private final WordRepository wordRepository;
    private final ModelMapper modelMapper;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public WordServiceImpl(WordRepository wordRepository, ModelMapper modelMapper, LanguageRepository languageRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.wordRepository = wordRepository;
        this.modelMapper = modelMapper;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void add(WordServiceModel wordServiceModel) {
        Word word = modelMapper.map(wordServiceModel, Word.class);
        word.setLanguage(languageRepository.findByLanguageName(wordServiceModel.getLanguage()));

        User creator = userRepository.findById(currentUser.getId()).orElse(null);
        word.setAddedBy(creator);

        wordRepository.save(word);

    }

    @Override
    public Set<Word> getAllByLanguage(LanguageNameEnum languageNameEnum) {


        return wordRepository.findAllByLanguage_LanguageName(languageNameEnum);
        //          It can be complicated with View Model too ;)
        //          .stream().map(word -> modelMapper.map(word, WordViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        wordRepository.deleteAll();
    }
}
