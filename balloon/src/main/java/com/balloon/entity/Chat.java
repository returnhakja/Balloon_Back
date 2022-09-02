package com.balloon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.balloon.dto.ChatDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class Chat {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "chat_id")
   private Long chatId;

   @Column(name = "chat_content")
   private String chatContent;

   @Column(name = "chat_time")
   @CreatedDate
   private LocalDateTime chatTime;

   @Column(name = "status")
   private Long status;

   @ManyToOne
   @JoinColumn(name = "chatroom_id")
   private Chatroom chatroom;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "emp_id")
   private Employee employee;


   public ChatDTO toDTO(Chat chatEntity) {
      ChatDTO chatDTO = ChatDTO.builder().chatId(chatEntity.getChatId()).chatContent(chatEntity.getChatContent())
            .chatTime(chatEntity.getChatTime()).status(chatEntity.getStatus()).chatroom(chatEntity.getChatroom())
            .employee(chatEntity.getEmployee()).build();
      return chatDTO;
   }

   public ChatDTO toChatDTO(Chat chatEntity) {
      ChatDTO chatDTO = ChatDTO.builder().chatContent(chatEntity.getChatContent()).chatTime(chatEntity.getChatTime())
    		  .status(chatEntity.getStatus()).chatroom(chatEntity.getChatroom()).employee(chatEntity.getEmployee())
            .build();
      return chatDTO;
   }
}