package com.a.repository;

import com.a.model.entity.Mood;
import com.a.model.entity.enums.MoodName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, String> {
    Optional<Mood> findByMoodName(MoodName moodName);
}
