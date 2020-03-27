package com.dovaleac.guessing.game.model.dto;

import com.dovaleac.guessing.game.model.enums.AnswerStatus;

import java.util.Date;

public class Answer {
  private Player player;
  private String answer;
  private Date date;
  private AnswerStatus status;

  public Answer() {
  }

  public Answer(Player player, String answer, Date date,
      AnswerStatus status) {
    this.player = player;
    this.answer = answer;
    this.date = date;
    this.status = status;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public AnswerStatus getStatus() {
    return status;
  }

  public void setStatus(AnswerStatus status) {
    this.status = status;
  }
}
