package com.project.digitalLibrary.cccc_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaa_entities.UserOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.UserModel;
import com.project.digitalLibrary.bbbb_outputmappers.UserOutputMapper;
import com.project.digitalLibrary.zzzz_utils.ResourceNotFoundException;

@Component
public class UserRepository {

	private final UserJPARepository userJPARepository;
	private final UserOutputMapper userOutputMapper;

	@Autowired
	public UserRepository(UserJPARepository userJPARepository, UserOutputMapper userOutputMapper) {
		this.userJPARepository = userJPARepository;
		this.userOutputMapper = userOutputMapper;
	}

	public UserModel addUser(UserModel userModel) {
		UserOutputEntity outputEntity = this.userOutputMapper.mapFromModel(userModel);
		UserOutputEntity savedOutputEntity = this.userJPARepository.save(outputEntity);
		return this.userOutputMapper.mapToModel(savedOutputEntity);
	}

	public UserModel getUserByEmail(String email) {
		return this.userJPARepository.findByEmail(email).map(this.userOutputMapper::mapToModel)
				.orElseThrow(() -> new ResourceNotFoundException(UserModel.class, "email", email));
	}

	public UserModel getUserById(long id) {
		return this.userJPARepository.findById(id).map(this.userOutputMapper::mapToModel)
				.orElseThrow(() -> new ResourceNotFoundException(UserModel.class, "id", String.valueOf(id)));
	}
}
