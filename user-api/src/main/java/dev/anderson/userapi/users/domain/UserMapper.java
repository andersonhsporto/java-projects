package dev.anderson.userapi.users.domain;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	void updateFromDto(UserDto dto, @MappingTarget UserEntity entity);
	
	@IterableMapping(qualifiedByName="mapWithoutPassoword")
	List<UserDto> toDtoList(List<UserEntity> list);
	
	@Named("mapWithoutPassoword")
	@Mapping(target = "password", ignore = true)
	UserDto mapWithoutPassword(UserEntity entity);
}
