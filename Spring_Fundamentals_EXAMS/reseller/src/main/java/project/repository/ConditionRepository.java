package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Condition;
import project.model.entity.enums.ConditionNameEnum;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, String> {
    Condition findByConditionName(ConditionNameEnum condition);
}
