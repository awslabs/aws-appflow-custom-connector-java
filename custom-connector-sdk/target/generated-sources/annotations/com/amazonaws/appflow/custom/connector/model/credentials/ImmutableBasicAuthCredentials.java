package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link BasicAuthCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableBasicAuthCredentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableBasicAuthCredentials
    implements BasicAuthCredentials {
  private final String userName;
  private final String password;

  private ImmutableBasicAuthCredentials(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  /**
   * Username.
   */
  @JsonProperty("userName")
  @Override
  public String userName() {
    return userName;
  }

  /**
   * Password.
   */
  @JsonProperty("password")
  @Override
  public String password() {
    return password;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BasicAuthCredentials#userName() userName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param userName A new value for userName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBasicAuthCredentials withUserName(String userName) {
    if (this.userName.equals(userName)) return this;
    String newValue = Preconditions.checkNotNull(userName, "userName");
    return new ImmutableBasicAuthCredentials(newValue, this.password);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BasicAuthCredentials#password() password} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param password A new value for password
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBasicAuthCredentials withPassword(String password) {
    if (this.password.equals(password)) return this;
    String newValue = Preconditions.checkNotNull(password, "password");
    return new ImmutableBasicAuthCredentials(this.userName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableBasicAuthCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableBasicAuthCredentials
        && equalTo((ImmutableBasicAuthCredentials) another);
  }

  private boolean equalTo(ImmutableBasicAuthCredentials another) {
    return userName.equals(another.userName)
        && password.equals(another.password);
  }

  /**
   * Computes a hash code from attributes: {@code userName}, {@code password}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + userName.hashCode();
    h = h * 17 + password.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BasicAuthCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("BasicAuthCredentials")
        .omitNullValues()
        .add("userName", userName)
        .add("password", password)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements BasicAuthCredentials {
    @Nullable String userName;
    @Nullable String password;
    @JsonProperty("userName")
    public void setUserName(String userName) {
      this.userName = userName;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
      this.password = password;
    }
    @Override
    public String userName() { throw new UnsupportedOperationException(); }
    @Override
    public String password() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableBasicAuthCredentials fromJson(Json json) {
    ImmutableBasicAuthCredentials.Builder builder = ImmutableBasicAuthCredentials.builder();
    if (json.userName != null) {
      builder.userName(json.userName);
    }
    if (json.password != null) {
      builder.password(json.password);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link BasicAuthCredentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BasicAuthCredentials instance
   */
  public static ImmutableBasicAuthCredentials copyOf(BasicAuthCredentials instance) {
    if (instance instanceof ImmutableBasicAuthCredentials) {
      return (ImmutableBasicAuthCredentials) instance;
    }
    return ImmutableBasicAuthCredentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableBasicAuthCredentials ImmutableBasicAuthCredentials}.
   * @return A new ImmutableBasicAuthCredentials builder
   */
  public static ImmutableBasicAuthCredentials.Builder builder() {
    return new ImmutableBasicAuthCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableBasicAuthCredentials ImmutableBasicAuthCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_USER_NAME = 0x1L;
    private static final long INIT_BIT_PASSWORD = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String userName;
    private @Nullable String password;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BasicAuthCredentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BasicAuthCredentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      userName(instance.userName());
      password(instance.password());
      return this;
    }

    /**
     * Initializes the value for the {@link BasicAuthCredentials#userName() userName} attribute.
     * @param userName The value for userName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder userName(String userName) {
      this.userName = Preconditions.checkNotNull(userName, "userName");
      initBits &= ~INIT_BIT_USER_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link BasicAuthCredentials#password() password} attribute.
     * @param password The value for password 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder password(String password) {
      this.password = Preconditions.checkNotNull(password, "password");
      initBits &= ~INIT_BIT_PASSWORD;
      return this;
    }

    /**
     * Builds a new {@link ImmutableBasicAuthCredentials ImmutableBasicAuthCredentials}.
     * @return An immutable instance of BasicAuthCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableBasicAuthCredentials build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableBasicAuthCredentials(userName, password);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_USER_NAME) != 0) attributes.add("userName");
      if ((initBits & INIT_BIT_PASSWORD) != 0) attributes.add("password");
      return "Cannot build BasicAuthCredentials, some of required attributes are not set " + attributes;
    }
  }
}
