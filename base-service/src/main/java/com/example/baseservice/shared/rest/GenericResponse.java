package com.example.baseservice.shared.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  Use the class as Generic response type for all Rest endpoints
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
  private boolean success;
  private String message;
  private T data;
}
