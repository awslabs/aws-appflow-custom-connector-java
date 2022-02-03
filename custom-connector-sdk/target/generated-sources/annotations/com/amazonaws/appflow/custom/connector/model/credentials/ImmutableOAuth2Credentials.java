package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link OAuth2Credentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOAuth2Credentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableOAuth2Credentials
    implements OAuth2Credentials {
  private final String accessToken;
  private final @Nullable String refreshToken;

  private ImmutableOAuth2Credentials(String accessToken, @Nullable String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  /**
   * Access Token.
   */
  @JsonProperty("accessToken")
  @Override
  public String accessToken() {
    return accessToken;
  }

  /**
   * Refresh Token.
   */
  @JsonProperty("refreshToken")
  @Override
  public @Nullable String refreshToken() {
    return refreshToken;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OAuth2Credentials#accessToken() accessToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param accessToken A new value for accessToken
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOAuth2Credentials withAccessToken(String accessToken) {
    if (this.accessToken.equals(accessToken)) return this;
    String newValue = Preconditions.checkNotNull(accessToken, "accessToken");
    return new ImmutableOAuth2Credentials(newValue, this.refreshToken);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OAuth2Credentials#refreshToken() refreshToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param refreshToken A new value for refreshToken (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOAuth2Credentials withRefreshToken(@Nullable String refreshToken) {
    if (Objects.equal(this.refreshToken, refreshToken)) return this;
    return new ImmutableOAuth2Credentials(this.accessToken, refreshToken);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOAuth2Credentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOAuth2Credentials
        && equalTo((ImmutableOAuth2Credentials) another);
  }

  private boolean equalTo(ImmutableOAuth2Credentials another) {
    return accessToken.equals(another.accessToken)
        && Objects.equal(refreshToken, another.refreshToken);
  }

  /**
   * Computes a hash code from attributes: {@code accessToken}, {@code refreshToken}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + accessToken.hashCode();
    h = h * 17 + Objects.hashCode(refreshToken);
    return h;
  }

  /**
   * Prints the immutable value {@code OAuth2Credentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OAuth2Credentials")
        .omitNullValues()
        .add("accessToken", accessToken)
        .add("refreshToken", refreshToken)
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
      implements OAuth2Credentials {
    @Nullable String accessToken;
    @Nullable String refreshToken;
    @JsonProperty("accessToken")
    public void setAccessToken(String accessToken) {
      this.accessToken = accessToken;
    }
    @JsonProperty("refreshToken")
    public void setRefreshToken(@Nullable String refreshToken) {
      this.refreshToken = refreshToken;
    }
    @Override
    public String accessToken() { throw new UnsupportedOperationException(); }
    @Override
    public String refreshToken() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableOAuth2Credentials fromJson(Json json) {
    ImmutableOAuth2Credentials.Builder builder = ImmutableOAuth2Credentials.builder();
    if (json.accessToken != null) {
      builder.accessToken(json.accessToken);
    }
    if (json.refreshToken != null) {
      builder.refreshToken(json.refreshToken);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link OAuth2Credentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OAuth2Credentials instance
   */
  public static ImmutableOAuth2Credentials copyOf(OAuth2Credentials instance) {
    if (instance instanceof ImmutableOAuth2Credentials) {
      return (ImmutableOAuth2Credentials) instance;
    }
    return ImmutableOAuth2Credentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOAuth2Credentials ImmutableOAuth2Credentials}.
   * @return A new ImmutableOAuth2Credentials builder
   */
  public static ImmutableOAuth2Credentials.Builder builder() {
    return new ImmutableOAuth2Credentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOAuth2Credentials ImmutableOAuth2Credentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACCESS_TOKEN = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String accessToken;
    private @Nullable String refreshToken;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OAuth2Credentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(OAuth2Credentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      accessToken(instance.accessToken());
      @Nullable String refreshTokenValue = instance.refreshToken();
      if (refreshTokenValue != null) {
        refreshToken(refreshTokenValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link OAuth2Credentials#accessToken() accessToken} attribute.
     * @param accessToken The value for accessToken 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder accessToken(String accessToken) {
      this.accessToken = Preconditions.checkNotNull(accessToken, "accessToken");
      initBits &= ~INIT_BIT_ACCESS_TOKEN;
      return this;
    }

    /**
     * Initializes the value for the {@link OAuth2Credentials#refreshToken() refreshToken} attribute.
     * @param refreshToken The value for refreshToken (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder refreshToken(@Nullable String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Builds a new {@link ImmutableOAuth2Credentials ImmutableOAuth2Credentials}.
     * @return An immutable instance of OAuth2Credentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOAuth2Credentials build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableOAuth2Credentials(accessToken, refreshToken);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ACCESS_TOKEN) != 0) attributes.add("accessToken");
      return "Cannot build OAuth2Credentials, some of required attributes are not set " + attributes;
    }
  }
}
