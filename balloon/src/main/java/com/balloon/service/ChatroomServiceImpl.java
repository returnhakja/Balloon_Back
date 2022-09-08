package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balloon.dto.ChatroomDTO;
import com.balloon.entity.Chatroom;
import com.balloon.repository.ChatroomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatroomServiceImpl implements ChatroomService {

   private final ChatroomRepository chatroomRepo;

   @Transactional(readOnly = true)
   @Override
   public List<ChatroomDTO> getAllChatroom() {
      List<ChatroomDTO> chatroomDTOList = new ArrayList<ChatroomDTO>();
      List<Chatroom> chatroomEntityList = chatroomRepo.findAll();
      for (Chatroom chatroomEntity : chatroomEntityList) {
         chatroomDTOList.add(chatroomEntity.toDTO(chatroomEntity));
      }
      return chatroomDTOList;
   }

   @Transactional(readOnly = true)
   @Override
   public ChatroomDTO getOneChatroom(Long chatroomId) {
      ChatroomDTO chatroomDTO = new ChatroomDTO();
      Chatroom chatroomEntity = chatroomRepo.findChatroomByChatroomId(chatroomId);
      chatroomDTO = chatroomEntity.toDTO(chatroomEntity);
      return chatroomDTO;
   }

   @Transactional
   @Override
   public Long getCreateChatroom(ChatroomDTO chatroomDTO) {
      Chatroom chatroomEntity = chatroomDTO.toEntity(chatroomDTO);
      return chatroomRepo.save(chatroomEntity).getChatroomId();
   }

   @Transactional
   @Override
   public List<ChatroomDTO> getCreateSchroom(List<ChatroomDTO> chatroomDTO) {
      List<ChatroomDTO> chatroomDTOList = new ArrayList<ChatroomDTO>();
      List<Chatroom> chatroomEntityList = new ArrayList<Chatroom>();

      for (ChatroomDTO chatroomDto : chatroomDTO) {
         chatroomEntityList.add(chatroomDto.toEntity(chatroomDto));
      }
      chatroomEntityList = chatroomRepo.saveAll(chatroomEntityList);

      for (Chatroom chatroomEntity : chatroomEntityList) {
         chatroomDTOList.add(chatroomEntity.toDTO(chatroomEntity));
      }
      return chatroomDTOList;
   }

   @Transactional
   @Override
   public void getUpdateChatroom(ChatroomDTO chatroomDTO) {
      Chatroom chatroomEntity = chatroomDTO.toEntity(chatroomDTO);
      chatroomEntity.updateEntity(chatroomDTO.getChatroomName(), chatroomDTO.getHeadCount());
      System.out.println(chatroomEntity);
      chatroomRepo.save(chatroomEntity);
   }

   @Transactional
   @Override
   public void deleteChatroom(Long chatroomId) {
      chatroomRepo.deleteById(chatroomId);
   }
}