package project.model.entity;

import jakarta.persistence.*;
import project.model.entity.enums.ConditionNameEnum;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    private ConditionNameEnum conditionName;
    private String description;



    public Condition() {
    }



    @Enumerated(EnumType.STRING)
    public ConditionNameEnum getConditionName() {
        return conditionName;
    }
    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }



    @Column(nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
