package fr.tp.dto;

import fr.tp.entities.AppUserEntity;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AppUserDto {
    private UUID id;
    private String firstName;
    private String lastName;

    public AppUserDto(){

    }

    public AppUserDto(UUID id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static AppUserDto fromEntity(AppUserEntity entity) {
        return new AppUserDto(entity.getId(), entity.getFirstName(), entity.getLastName());
    }

    public static List<AppUserDto> fromEntities(List<AppUserEntity> entities) {
        return entities.stream()
                .map(AppUserDto::fromEntity)
                .collect(Collectors.toList());
    }
}
