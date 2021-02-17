package com.securityauditing.demo.convert.impl;

import com.securityauditing.demo.convert.IConvertData;
import com.securityauditing.demo.dto.UserDto;
import com.securityauditing.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class UserConvert implements IConvertData<UserDto, UserEntity> {

    private final ModelMapper modelMapper;

    @Override
    public UserDto convertToDtoOrModel(UserEntity tObject) {
        UserDto userDto = modelMapper.map(tObject, UserDto.class);
        return userDto;
    }

    @Override
    public UserEntity convertToEntity(UserDto eObject) {
        UserEntity userEntity = modelMapper.map(eObject, UserEntity.class);
        return userEntity;
    }

    @Override
    public UserEntity apply(UserDto userDto) {
        return null;
    }
}
