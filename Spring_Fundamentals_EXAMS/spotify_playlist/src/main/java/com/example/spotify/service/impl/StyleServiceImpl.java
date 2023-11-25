package com.example.spotify.service.impl;

import com.example.spotify.model.entity.Style;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import com.example.spotify.repository.StyleRepository;
import com.example.spotify.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {
   private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if(styleRepository.count() == 0){
            Arrays.stream(StyleNameEnum.values())
                    .forEach(styleName -> {

                        Style style = new Style();

                        style.setStyleName(styleName);
                        style.setDescription("Description for " + styleName);

                        styleRepository.save(style);
                    });
        }
    }
}
