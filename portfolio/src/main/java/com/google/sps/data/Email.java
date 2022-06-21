package com.google.sps.data;

/** An item on a todo list. */
public final class Email {
  private final long id;
  private final String email;
  private final long timestamp;

  public Email(long id, String email, long timestamp) {
    this.id = id;
    this.email = email;
    this.timestamp = timestamp;
  }

public void add(Email email2) {
}
}