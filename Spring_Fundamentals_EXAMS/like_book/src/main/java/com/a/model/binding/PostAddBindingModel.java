package com.a.model.binding;

import com.a.model.entity.enums.MoodName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostAddBindingModel {

    private String content;
    private MoodName mood;

    public PostAddBindingModel() {
    }
    @NotBlank(message = "Content cannot be empty!")
    @Size(min = 2, max = 150, message = "Content length must be 2-150 chars")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    /// NOTICE!!!! -> NEVER PUT @NotBlank validator on this field
    @NotNull(message = "Mood was not chosen!")
    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }
}
